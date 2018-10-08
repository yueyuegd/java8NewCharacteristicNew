package java8_day02;

import common.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI6 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, Employee.Status.FREE, 9999.99),
            new Employee("李四", 58, Employee.Status.BUSY, 5555.55),
            new Employee("王五", 26, Employee.Status.VOCATION, 3333.33),
            new Employee("赵六", 36, Employee.Status.FREE, 6666.66),
            new Employee("田七", 12, Employee.Status.BUSY, 8888.88)
    );

    /**
     * 归约：
     * reduce(T identity, BinaryOperator)/reduce(BinaryOperator)-
     * 可以将流中元素反复结合起来，得到一个值
     */

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) ->
                x + y);
        System.out.println(sum);

        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

    /**
     * 收集：
     * collect-将流转化为其他形式，接收一个Collector接口的实现，用于
     * 给Stream中元素做汇总的方法
     *
     */

    @Test
    public void test2() {
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("--------------------");
        Set<String> namesSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        namesSet.forEach(System.out::println);

        System.out.println("---------------------");
        HashSet hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

    }

    @Test
    public void test3() {
        //总数
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("--------------------");
        //平均值
        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
        System.out.println("---------------------");
        //总和
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        //最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy(
                        (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())
                ));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compareTo
                ));
        System.out.println(min.get());
    }

    //分组
    @Test
    public void test4() {
        Map<Employee.Status, List<Employee>> map =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test5() {
        Map<Employee.Status, Map<String, List<Employee>>> map =
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                         Collectors.groupingBy((e) -> {
                                     if (((Employee) e).getAge() <= 35) {
                                         return "青年";
                                     } else if (((Employee) e).getAge() <= 50) {
                                         return "中年";
                                     } else {
                                         return "老年";
                                     }
                                 }
                                     )));
        System.out.println(map);
    }

    @Test
    public void test6() {
        Map<Boolean, List<Employee>> map =
                employees.stream()
                .collect(Collectors.partitioningBy(
                        (e) -> e.getSalary() > 8000));
        System.out.println(map);
    }

    @Test
    public void test7() {
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }

    @Test
    public void test8() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }
}
