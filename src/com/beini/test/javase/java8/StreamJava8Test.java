package com.beini.test.javase.java8;


import com.beini.utils.BLog;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Clock;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by beini on 2017/4/18.
 * java8 集合流式操作
 */
public class StreamJava8Test {

    public static void main(String[] args) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 22, 33, 4, 6, 55);
        long l = list.stream().filter(num -> num > 22).count();
        BLog.d("          l=" + l);
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
//        int i = integerStream.mapToInt(num -> num * 2).sum();

    }

    public void TestParameter() throws NoSuchMethodException {
        Method method = StreamJava8Test.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }

    /**
     * collect() ：返回一个新的集合
     */
    public static void collectTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List _list = list.stream().filter((param) -> param % 2 == 0).collect(Collectors.toList());
        _list.forEach(System.out::println);

    }

    public void testDate() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }

    public void testOoptional() {
        Optional<String> fullName = Optional.ofNullable("22222");
//        System.out.println("Full Name is set? " + fullName.isPresent());
//        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
//        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        BLog.d(fullName.orElse("111111111"));
    }

    /**
     * 串行和并行的流,
     * 通过 stream.parallel() 返回并行的流。
     * 相比较串行的流，并行的流可以很大程度上提高程序的执行效率。
     * 通过 stream.sequential() 返回串行的流
     */

    public static void testStream() {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start1 = System.currentTimeMillis();
//        for (Integer integer : list) {
//           System.out.println(" integer= "+integer);
//        }
//        list.stream().forEach(System.out::println);
//        list.stream().parallel().forEach(System.out::println);//并行
        list.stream().sequential().forEach(System.out::println);//按顺序
        long end1 = System.currentTimeMillis();
        System.out.println("   end1-start1=" + (end1 - start1));
    }

    /**
     * min()，max()  找到最大值最小值
     */
    public static void minAndMax() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.stream().min((param1, param2) -> param1 > param2 ? 1 : -1).get());
        System.out.println(list.stream().max((param1, param2) -> param1 > param2 ? 1 : -1).get());
    }


    /**
     * reduce() ：把Stream 元素组合起来。
     */
    public static void reduceTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.stream().reduce((param1, param2) -> param1 + param2).get());
    }

    /**
     * distinct() 去除重复元素
     */
    public static void distinctTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(0);
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * map() 元素映射
     */
    public static void mapTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(0);
        list.stream().map(param -> param == 1 ? true : false)
                .forEach(System.out::println);

    }

    /**
     * sorted() 对元素进行排序
     */
    public static void sortedTest() {
        List<Integer> list = new ArrayList();
        list.add(33);
        list.add(3);
        list.add(21);
        list.add(1);
        list.add(6);
        System.out.println("     list.stream().count()=" + list.stream().count());
//        list.stream().sorted().forEach(System.out::println);

        list.stream().sorted((param1, param2) -> (param1 < param2 ? 1 : -1))
                .forEach(System.out::println);
    }

    /**
     * filter() 对元素进行过滤
     */
    public void filterTest() {
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 5; ++i) {
            list.add(i);
        }
        list.stream().filter(param -> param % 2 == 1)
                .forEach(System.out::println);
        list.stream().filter(param -> param == 1).forEach(

                System.out::println
        );

    }
}
