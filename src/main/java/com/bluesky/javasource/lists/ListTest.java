package com.bluesky.javasource.lists;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

@Slf4j
public class ListTest {

    /**
     * 两个空容量的列表虽然内部使用的数组是同一个静态常量，但是两个List本身是不同的对象
     */
    @Test
    public void emptyListTest() {
        ArrayList<Integer> list1 = new ArrayList<>(0);
        ArrayList<Integer> list2 = new ArrayList<>(0);
        log.info("{}", list1.equals(list2)); // true
        log.info("{}", list1 == list2); //false
    }

    /**
     * 测试迭代器的使用
     */
    @Test
    public void listIteratorTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.forEach(System.out::println);
        ListIterator<Integer> iterator = list.listIterator();
//        list.add(6);
        // fail-fast , 抛出java.util.ConcurrentModificationException
//        iterator.forEachRemaining(System.out::println);

        /* method one
        iterator.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/

       /* method two
        list.forEach((x) -> {
            System.out.println(x);
        });*/

//        method three
        iterator.forEachRemaining(System.out::println);
    }

    /**
     * 测试retain方法
     */
    @Test
    public void retainTest() {
        List list1 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        List list2 = new ArrayList(Arrays.asList(1, 3, 6, 7, 8));
        boolean b = list1.retainAll(list2);

        // retain: true, result: [1, 3, null, null, null]
        log.info("retain: {}, result: {}",
                b, Arrays.toString(list1.toArray(new Integer[list2.size()])));
    }

}
