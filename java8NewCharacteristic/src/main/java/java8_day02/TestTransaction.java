package java8_day02;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestTransaction {

    List<Transaction> transactions;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


    }

    /**
     * 1.找出2011年发生的所有交易，并按照交易额排序（从低到高）
     */
    @Test
    public void test1() {
        transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);
    }

    /**
     * 2.交易员都在哪些不同的城市工作过
     */
    @Test
    public void test2() {
        transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 3.查找所有来自剑桥的交易员，并按照姓名序排序
     */
    @Test
    public void test3() {
        transactions.stream()
                .filter((t) -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);

    }

    /**
     * 4.返回所有交易员的姓名字符串，按字母顺序排序
     */
    @Test
    public void test4() {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .distinct()
                .forEach(System.out::println);

        String str = transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println(str);

    }

    /**
     * 5.有没有交易员是在米兰工作
     */
    @Test
    public void test5() {
        Boolean flag = transactions.stream()
                .anyMatch((t) -> t.getTrader().getCity()
                        .equalsIgnoreCase("Milan"));
        System.out.println(flag);
    }

    /**
     * 6.打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test6() {
        int sum = transactions.stream()
                .filter((t) -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(sum);
    }
}
