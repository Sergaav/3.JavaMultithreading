package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

   Thread target;

    public LoggingStateThread(Thread target) {
        this.target=target;

    }

    @Override
    public void run() {
        State mark=State.NEW;
        System.out.println(mark);
        while (target.getState()!= State.TERMINATED){
            if (target.getState() != mark){
                mark=target.getState();
                System.out.println(mark);
            }
        }
        System.out.println(target.getState());
        interrupt();
    }
}
