package cn.leo.tutorial.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo 2021/3/12 上午11:10
 **/
public class ThenAcceptMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // 创建异步执行任务:
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture
            .supplyAsync(() -> queryCode("中国石油"), fixedThreadPool);
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync(ThenAcceptMain::fetchPrice);

        ThenAcceptMain instance = new ThenAcceptMain();
        // 如果执行成功:
        cfFetch.thenAccept(instance::processResult);
        // 如果执行异常:
        cfFetch.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        double price = Math.random();
        if (price < 0.3) {
            throw new RuntimeException("fetch price failed");
        }
        return 5 + price * 20;
    }

    private void processResult(Double result) {
        System.out.println("price: " + result);
    }
}
