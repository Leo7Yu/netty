package cn.leo.tutorial.eventbus;

import com.google.common.eventbus.Subscribe;
import java.util.List;
import lombok.Getter;

/**
 * @author leo 2021/3/9 上午11:44
 **/
@Getter
public class EventListenerB {

    @Subscribe
    public void listen2(TestEvent testEvent) throws InterruptedException {
        List<Integer> records = testEvent.getRecords();
        records.add(testEvent.getMessage() + 3);
        System.out.println("b");
        Thread.sleep(1000);
    }
}
