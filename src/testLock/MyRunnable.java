package testLock;

import java.util.Date;

public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println("runable线程" +Thread.currentThread().getName() + " 开始. 时间 = " + new Date());
        processCommand();
        System.out.println("runable线程" +Thread.currentThread().getName() + " 结束. 时间 = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
