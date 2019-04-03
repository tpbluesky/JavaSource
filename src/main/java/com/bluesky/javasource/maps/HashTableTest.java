package com.bluesky.javasource.maps;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.Hashtable;

@Slf4j
public class HashTableTest {

    @Test
    public void simpleUseTest() {
        Hashtable<Integer, Integer> ht = new Hashtable(11);
        ht.put(1, 1);
        ht.put(3, 3);
        ht.put(2, 2);
        log.info("contains key: {}", ht.containsKey(1)); // true
        log.info("contains value: {}", ht.containsValue(3)); //false
        log.info("get or default: {}", ht.getOrDefault(1, 0));
        Enumeration<Integer> keys = ht.keys();
        while (keys.hasMoreElements()) { // 可以看出是无序的,和插入顺序无关
            log.info("keys: {}", keys.nextElement());
        }
        // 类似的可以访问其他视图
        Set<Map.Entry<Integer, Integer>> entries = ht.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            log.info("entries: {}", entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 测试迭代视图时，修改哈希表会出现什么问题
     */
    @Test
    public void testModifyWhenIterator() {
        Hashtable<Integer, Integer> ht = new Hashtable(11);
        ht.put(1, 1);
        ht.put(3, 3);
        ht.put(2, 2);
        Set<Integer> integers = ht.keySet();
        for (Integer integer : integers) {
            log.info("key: {}", integer);
            ht.put(new Random().nextInt(10), new Random().nextInt(10));
        }
    }

}
