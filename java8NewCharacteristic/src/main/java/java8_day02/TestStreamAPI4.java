package java8_day02;


import common.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 中间操作：
 * 排序：
 * 1.sorted()-自然排序
 * 2.sorted(Comparator com)-定制排序
 */
public class TestStreamAPI4 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 58, 5555.55),
            new Employee("王五", 26, 3333.33),
            new Employee("赵六", 36, 6666.66),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88)
    );


    @Test
    public void test1() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().sorted()
                .forEach(System.out::println);

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}
