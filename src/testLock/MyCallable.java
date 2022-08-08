package testLock;

import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        System.out.println("callable线程" + Thread.currentThread().getName() + " 开始. 时间 = " + new Date());
        processCommand();
        System.out.println("callable线程" + Thread.currentThread().getName() + " 结束. 时间 = " + new Date());
        return "执行成功";
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}