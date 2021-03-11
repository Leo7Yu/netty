package cn.leo.tutorial.localdate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author leo 2021/3/10 上午11:11
 **/
public class LocalDateMain {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = localDate.withDayOfMonth(2);
        System.out.println(localDate);
        localDate = localDate.plusMonths(1);
        System.out.println(localDate);
        long timestamp = localDate.atStartOfDay().toEpochSecond(ZoneOffset.of("+8")) * 1000;
        System.out.println(timestamp);
        timestamp = localDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(timestamp);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDate.atStartOfDay()));

    }
}
