package java8_day02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作（终端操作）
 */

public class TestStreamAPI1 {

    //创建Stream
    public void test1() {
        //1.可以通过Collection系列集合提供的stream()或者是parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        //3.通过Stream中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.forEach(System.out::println);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random()).forEach(System.out::println);

    }
}
