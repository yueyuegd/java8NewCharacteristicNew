package java8_day01;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8中内置的四大核心函数式接口
 *
 *
 * Consumer<T>:消费型接口
 * void accept(T t);
 *
 * Supplier<T>:供给型接口
 * T get();
 *
 * Function<T, R>:函数型接口
 * R apply(T t);
 *
 * Predicate<T>:断言型接口
 * boolean test(T t);
 */
public class TestLambda3 {

    //Consumer<T> 消费型接口
    @Test
    public void test1() {
        happy(10000,
                (x) -> System.out.println("消费了 " + x + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //Suppler<T>:供给型接口
    @Test
    public void test2() {
        List<Integer> list = getNumberList(10, () -> (int)(Math.random() * 100));
        for (Integer num : list) {
            System.out.println(num);
        }
    }
    //产生指定个数的整数并放入集合中
    public List<Integer> getNumberList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R>:函数式接口
    @Test
    public void test3() {

    }

    //Predicate<T>:断言型接口
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> filterList = filterStr(list, (s) -> s.length() > 3);
        for (String str : filterList) {
            System.out.println(str);
        }

    }
    //需求：将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}
