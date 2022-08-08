package testLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            Future<?> a = executor.submit(worker);
            futureList.add(a);
        }
        //终止线程池,showdown后线程池不再接收任务，后续再提交任务会被拒绝
        /*executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("runable线程池里所有线程执行完了");*/
        List<Future<String>> futureList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Callable worker = new MyCallable();
            //执行Runnable
            Future<String> b = executor.submit(worker);
            futureList2.add(b);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("callable线程池里所有线程执行完了");
    }
}
