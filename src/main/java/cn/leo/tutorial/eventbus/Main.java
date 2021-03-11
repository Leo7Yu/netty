package cn.leo.tutorial.eventbus;

import com.google.common.collect.Range;
import com.google.common.eventbus.AsyncEventBus;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo 2021/3/9 上午11:53
 **/
public class Main {

    /**
     * 1.同步执行，事件发送方在发出事件之后，会等待所有的事件消费方执行完毕后，才会回来继续执行自己后面的代码。
     * <p>
     * 2.事件发送方和事件消费方会在同一个线程中执行，消费方的执行线程取决于发送方。
     * <p>
     * 3.同一个事件的多个订阅者，在接收到事件的顺序上面有不同。谁先注册到EventBus的，谁先执行，如果是在同一个类中的两个订阅者一起被注册到EventBus的情况，收到事件的顺序跟方法名有关。
     *
     * @param args
     */
    public static void main(String[] args) {
        EventListenerA a = new EventListenerA();
        EventListenerB b = new EventListenerB();
        TestEvent testEvent = new TestEvent(1, new CopyOnWriteArrayList<>());

//        EventBus eventBus = new EventBus("test");
//        eventBus.register(a);
//        eventBus.register(b);
//        eventBus.post(testEvent);
//        System.out.println("end" + testEvent.getRecords());

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        AsyncEventBus asyncEventBus= new AsyncEventBus("asyncTest",fixedThreadPool);
        asyncEventBus.register(a);
        asyncEventBus.register(b);
        asyncEventBus.post(testEvent);
        System.out.println("end" + testEvent.getRecords());
    }
}
