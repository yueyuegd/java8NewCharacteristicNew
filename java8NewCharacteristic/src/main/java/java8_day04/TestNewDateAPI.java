package java8_day04;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestNewDateAPI {
    //TemporalAdjuster:时间校正器
    @Test
    public void test1() {
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println(time1);
        LocalDateTime time2 = time1.withDayOfMonth(10);
        System.out.println(time2);
        LocalDateTime time3 = time1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(time3);

        //自定义：下一个工作日
        LocalDateTime nextDate = time1.with((l) -> {
            LocalDateTime time4 = (LocalDateTime) l;
            DayOfWeek dow = time4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return time4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return time4.plusDays(2);
            } else {
                return time4.plusDays(1);
            }
        });
        System.out.println(nextDate);
    }

    //格式化时间/日期
    @Test
    public void test2() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime time = LocalDateTime.now();
        String strDate = formatter.format(time);
        System.out.println(strDate);

        System.out.println("--------------------------------");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate1 = formatter1.format(time);
        System.out.println(strDate1);

        LocalDateTime time2 = LocalDateTime.parse(strDate1, formatter1);
        System.out.println(time2);
    }

    //时区的处理  ZoneDate,ZoneTime,ZoneDateTime
    @Test
    public void test3() {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.forEach(System.out::println);
    }

    //Asia/Shanghai
}
