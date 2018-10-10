package java8_day04;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {

    //1.LocalDate,LocalTime,LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2018, 10, 10, 13, 57, 01);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //2.Instant:时间戳，以Unix元年（1970年1月1日00：00：00到某个时间之间的毫秒值）
    @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant);//默认获取UTC时区

        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochSecond(60);
        System.out.println(instant1);
    }

    //3.Duration：计算两个时间之间的间隔
    //Period:计算两个日期之间的间隔
    @Test
    public void test3() {

        Instant instant1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());


        System.out.println("----------------------------");
        LocalTime time1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime time2 = LocalTime.now();
        Duration duration1 = Duration.between(time1, time2);
        System.out.println(duration1.toMillis());
    }

    @Test
    public void test4() {
        LocalDate localDate1 = LocalDate.of(2015,1,1);
        LocalDate now = LocalDate.now();
        Period period = Period.between(localDate1, now);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
