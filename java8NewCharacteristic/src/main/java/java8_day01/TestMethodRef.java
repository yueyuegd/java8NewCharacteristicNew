package java8_day01;


import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现，我们可以使用"方法引用"
 * （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 注意：
 * 1.Lambda体中调用方法的参数列表和返回值类型要和函数值
 * 接口中的抽象方法中的参数列表和返回类型一致
 * 2.若Lambda参数列表中的第一个参数是实例方法的调用者，第二个参数是
 * 实例方法的参数时可以使用类::实例方法
 *
 * 二、构造器引用
 * 格式：
 * 类名::new
 * 注意：需要调用的构造器的参数列表需要与函数式接口的参数列表保持一致
 *
 * 三、数组引用
 * Type[]::new;
 */
public class TestMethodRef {

    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream stream = System.out;
        Consumer<String> con1 = stream::println;
        con1.accept("zhangyue");
    }
}
