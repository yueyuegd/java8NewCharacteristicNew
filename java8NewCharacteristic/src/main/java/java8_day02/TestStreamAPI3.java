package java8_day02;


import common.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作：
 * 映射：
 * 1.map-接收Lambda，将其元素转换成其他形式或提取信息，接收一个函数作为参数，
 * 该函数会应用到每个元素上，并将其映射成一个新的元素。
 * 2.flatMap-接收一个函数作为参数，将流中的每个值换成另一个流，然后把所有的流连接成一个流
 */
public class TestStreamAPI3 {

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
        List<String> list = Arrays.asList(
                "aaa", "bbb", "ccc", "ddd", "eee"
        );

        list.stream().map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        employees.stream().map(Employee::getName)
                .forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI3::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
    }


    public static Stream<Character> filterCharacter(String string) {
        List<Character> list = new ArrayList<>();
        for (Character ch : string.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
}
