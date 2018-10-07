package java8_day02;


import common.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作：
 * 筛选与切片：
 * 1.filter-接收Lambda，从中排除某些元素
 * 2.limit-截断流，使其元素不超过给定数量
 * 3.skip(n)-跳过元素，返回一个扔掉了前n个元素的流，
 * 若流中元素不足n个，则返回一个空流，与limit(n)互补
 * 4.distinct-筛选，通过流所生成元素的hashCode()和equals()去除重复元素
 */
public class TestStreamAPI2 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 58, 5555.55),
            new Employee("王五", 26, 3333.33),
            new Employee("赵六", 36, 6666.66),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88)
    );

    //内部迭代：迭代操作由StreamAPI完成
    @Test
    public void test1() {
        //中间操作：不会执行操作
        Stream<Employee> s = employees.stream().filter(
                (e) -> e.getAge() > 35
        );
        //终止操作：一次性执行完全部内容，即"惰性求值"
        s.forEach(System.out::println);
    }

    @Test
    public void test2() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2).forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        employees.stream()
                 .distinct()
                 .forEach(System.out::println);
    }
}
