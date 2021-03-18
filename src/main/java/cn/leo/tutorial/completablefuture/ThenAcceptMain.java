package cn.leo.tutorial.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author leo 2021/3/12 上午11:10
 **/
public class ThenAcceptMain {

    public static void main(String[] args) throws InterruptedException {
        ThenAcceptMain instance = new ThenAcceptMain();

        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(ThenAcceptMain::fetchPrice);
        // 如果执行成功:
        cf.thenAccept(instance::processResult);
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
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
