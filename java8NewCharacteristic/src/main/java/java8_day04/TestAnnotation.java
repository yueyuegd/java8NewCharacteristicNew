package java8_day04;


import sun.applet.Main;

import java.util.Arrays;

/**
 * 重复注解和类型注解
 */
public class TestAnnotation {

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public static void show() {

    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public static void main(String[] args) {
        Class<Main> clazz = Main.class;
        MyAnnotation[] myAnnotations = clazz.getAnnotationsByType(MyAnnotation.class);
        Arrays.stream(myAnnotations).forEach(System.out::println);
    }
}
