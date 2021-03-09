package cn.leo.tutorial.eventbus;

import com.google.common.eventbus.Subscribe;
import java.util.List;
import lombok.Getter;

/**
 * @author leo 2021/3/9 上午11:44
 **/
@Getter
public class EventListenerA {

    @Subscribe
    public void listen2(TestEvent testEvent) throws InterruptedException {
        List<Integer> records = testEvent.getRecords();
        records.add(testEvent.getMessage() + 1);
        System.out.println("a1");
        Thread.sleep(2000);
    }

    @Subscribe
    public void listen3(TestEvent testEvent) throws InterruptedException {
        List<Integer> records = testEvent.getRecords();
        records.add(testEvent.getMessage() + 2);
        System.out.println("a2");
        Thread.sleep(2000);
    }
}
