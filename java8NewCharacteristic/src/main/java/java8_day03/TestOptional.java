package java8_day03;


import common.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * 容器类Optional的常用方法
 */
public class TestOptional {

    @Test
    public void test1() {
        Optional<Employee> op1 = Optional.of(new Employee());
        Employee emp = op1.get();
        System.out.println(emp);
    }

    //例题：获得男人的女神的名字
    //因为直接获取的话很容易出现空指针的异常，因为可能Man
    //的对象中godness为null,以前的做法是多次判断
    @Test
    public void test2() {
        Man man = new Man();
        System.out.println(getGodnessName(man));
    }

    public String getGodnessName(Man man) {
        if (man != null) {
            Godness gn = man.getGodness();
            if (gn != null) {
                return gn.getName();
            }
        }
        return "默认女神";
    }

    //新做法，使用Optional容器
    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("默认女神"))
                .getName();
    }

    @Test
    public void test3() {
        Optional<NewMan> op = Optional.ofNullable(null);
        String str = getGodnessName2(op);
        System.out.println(str);
    }
}
