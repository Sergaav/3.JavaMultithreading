package com.javarush.task.task30.task3008;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                try {
                    pair.getValue().send(new Message(MessageType.TEXT, "Your message do not sent"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            MessageType messageType = null;
            Message message;
            String name = null;
            while (messageType != MessageType.USER_NAME) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Enter your name,please."));
                message = connection.receive();
                if (message.getType() == MessageType.USER_NAME && !message.getData().equals("") && !connectionMap.containsKey(message.getData())) {
                    connectionMap.put(message.getData().toString(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "User is accepted!"));
                    messageType = MessageType.USER_NAME;
                    name = message.getData().toString();
                }
            }
            return name;
        }

        private void notifyUsers(Connection connection, String userName) {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Something wrong!!");
                }

            }
        }

        @Override
        public void run() {
            if (socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Connection "+socket.getRemoteSocketAddress()+" run!");
                String userName = null;
                Connection connection;
                try {
                    connection = new Connection(socket);
                    ConsoleHelper.writeMessage("Connection active.");
                    userName = serverHandshake(connection);
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                    notifyUsers(connection, userName);
                    serverMainLoop(connection, userName);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }


        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ConsoleHelper consoleHelper = new ConsoleHelper();
        try {
            try {
                serverSocket = new ServerSocket(ConsoleHelper.readInt());
                System.out.println("Server started.");
                while (true) {
                    new Handler(serverSocket.accept()).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
