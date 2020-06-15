package testone;

import java.util.concurrent.locks.Lock;

public class VolatileTest {
    public static volatile int race = 0;

    public static void incr(){
        race++;
        System.out.println(race);
    }
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i <THREADS_COUNT ; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <10000 ; j++) {
                        incr();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有的线程全部结束
        while(Thread.activeCount()>2)
            Thread.yield();
        System.out.println("结果最终:" + race);
    }
}
