package java8_day04;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * java8提供的新时间工具
 */
public class TestNewDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        Callable<LocalDateTime> task = () -> LocalDateTime.parse("20181010123900", formatter);
                /*new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181010", formatter);
            }
        };*/
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDateTime>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDateTime> future : results) {
            System.out.println(future.get());
        }
    }
}
