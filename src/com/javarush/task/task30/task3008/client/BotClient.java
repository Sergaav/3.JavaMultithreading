package com.javarush.task.task30.task3008.client;



import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client{
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+ (int) (Math.random()*100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String [] temp= message.split(": ");
            Calendar calendar = new GregorianCalendar();
            Date date = calendar.getTime();
            if (temp.length != 2) return;

            switch (temp[1].trim()) {
                case ("дата"): BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("d.MM.YYYY").format(date));
                break;

                case ("день") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("d").format(date));
                break;

                case ("месяц") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("MMMM").format(date));
                    break;
                case ("год") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("YYYY").format(date));
                    break;

                case ("время") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("H:mm:ss").format(date));
                    break;

                case ("час") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("H").format(date));
                    break;

                case ("минуты") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("m").format(date));
                    break;

                case ("секунды") : BotClient.this.sendTextMessage("Информация для "+temp[0]+": "+ new SimpleDateFormat("s").format(date));
                    break;
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }


    }
}
