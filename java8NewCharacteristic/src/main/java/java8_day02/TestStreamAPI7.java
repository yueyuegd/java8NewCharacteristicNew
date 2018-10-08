package java8_day02;

import common.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPI7 {

    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的
     * 列表，给定【1，2，3，4，5】，应该返回【1，4，9，16，25】
     */

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> newList = list.stream()
                .map((x) -> x * x)
        .collect(Collectors.toList());
        //newList.forEach(System.out::print);
        System.out.println(newList);
    }

    /**
     * 2.怎样使用map和reduce方法
     * 数一数流中有多少个Employee呢
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, Employee.Status.FREE, 9999.99),
            new Employee("李四", 58, Employee.Status.BUSY, 5555.55),
            new Employee("王五", 26, Employee.Status.VOCATION, 3333.33),
            new Employee("赵六", 36, Employee.Status.FREE, 6666.66),
            new Employee("田七", 12, Employee.Status.BUSY, 8888.88)
    );

    @Test
    public void test2() {
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }
}
