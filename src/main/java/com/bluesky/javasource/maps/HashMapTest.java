package com.bluesky.javasource.maps;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.bluesky.javasource.maps.HashMap.MAXIMUM_CAPACITY;

@Slf4j
public class HashMapTest {

    @Test
    public void simpleUseTest() {

    }


    /**
     * 测试HashMap中的comparableClassFor方法
     */
    @Test
    public void comparableClassForTest() {
        // null, 不是Comparable的子类
        System.out.println(HashMap.comparableClassFor(new A()));
        // null,是和Object比较,泛有指定则为Object
        System.out.println(HashMap.comparableClassFor(new B()));
        // null,是和Object比较
        System.out.println(HashMap.comparableClassFor(new C()));
        // class com.bluesky.javasource.maps.HashMapTest$D ,满足条件
        System.out.println(HashMap.comparableClassFor(new D()));
        // Comparable父类的接口，不是子类直接接口
        System.out.println(HashMap.comparableClassFor(new E()));
    }

    static class A {
    }

    static class B implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class C implements Comparable<Object> {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class D implements Comparable<D> {
        @Override
        public int compareTo(D o) {
            return 0;
        }
    }

    static class E extends C {
    }

}
