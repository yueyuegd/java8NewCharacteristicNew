package java8_day02;


import common.Employee;
import common.Employee.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 终止操作
 */
public class TestStreamAPI5 {

    /**
     * 查找与匹配：
     * 1.allMatch-检查是否匹配所有的元素
     * 2.anyMatch-检查是否至少匹配一个元素
     * 3.noneMatch-检查是否没有匹配所有元素
     * 4.findFirst-返回第一个元素
     * 5.findAny-返回当前流中的任意元素
     * 6.count-返回流中元素的总个数
     * 7.max-返回流中最大值
     * 8.min-返回流中最小值
     */

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, Status.FREE, 9999.99),
            new Employee("李四", 58, Status.BUSY, 5555.55),
            new Employee("王五", 26, Status.VOCATION, 3333.33),
            new Employee("赵六", 36, Status.FREE, 6666.66),
            new Employee("田七", 12, Status.BUSY, 8888.88)
    );

    @Test
    public void test1() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b3);

        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.parallelStream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op2.get());

    }
}
