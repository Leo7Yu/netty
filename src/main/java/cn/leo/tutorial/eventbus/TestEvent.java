package cn.leo.tutorial.eventbus;

import java.util.List;
import lombok.Getter;

/**
 * @author leo 2021/3/9 上午11:34
 **/
@Getter
public class TestEvent {

    private final int message;

    private final List<Integer> records;

    public TestEvent(int message, List<Integer> records) {
        this.message = message;
        this.records = records;
    }
}
