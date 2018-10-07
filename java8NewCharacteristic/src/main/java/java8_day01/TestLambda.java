package java8_day01;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、lambda表达式的基础语法：java8中引入了一种新的操作符"->"，该操作符称为箭头操作符或者是Lambda操作符，
 * 箭头操作符将lambda表达式拆分成两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式所需执行的功能，即Lambda体
 *
 * 语法格式一：无参数，无返回值
 * 实例：() -> System.out.println("Hello Lambda");
 *
 * 语法格式二：有一个参数，无返回值
 * 实例：(x) -> System.out.println(x)
 *
 * 语法格式三：有一个参数 的时候小括号也可以不写
 * 实例：x -> System.out.println(x)
 *
 * 语法格式四：有两个或者是两个以上参数，
 *           有返回值并且Lambda体中有多条语句
 *  实例：
 *  (x, y) ->
 *         {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 *
 * 语法格式五：有两个或者是两个以上参数，
 *  *        有返回值并且Lambda体中只有一条语句的话return语句和大括号都可以省略
 *  实例：(x, y) ->
 *                 Integer.compare(x, y);
 *
 *  语法格式六： 若Lambda表达式的参数列表的数据类型可以省略不写，
 *  因为JVM可以通过上下文推断出数据类型，即"类型推断"
 *
 *
 *  二、Lambda表达式需要"函数式接口"的支持
 *  函数式接口：接口中只有一个抽象方法，可是使用@FunctionalInterface修饰可以检查接口是否是函数式接口
 *
 */
public class TestLambda {

    @Test
    public void test1() {
        /*Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello World!");
            }
        };*/
        Runnable r = () -> System.out.println("Hello Lambda");
        r.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("zhangyue");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) ->
        {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) ->
                Integer.compare(x, y);
    }
}
