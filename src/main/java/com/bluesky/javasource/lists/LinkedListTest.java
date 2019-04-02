package com.bluesky.javasource.lists;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
public class LinkedListTest {

    /**
     * 虽然说把LinkedList当成链表，栈，队列有很多方法的效果是一致的，但尽量使用相应数据结构对应的函数，
     * 这种做法使代码更具有可读性
     */
    @Test
    public void simpleUseTest() {
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(0, 1, 2, 3, 4, 5));

        //把LinkedList当作链表使用
        linkedList.add(6);
        linkedList.get(4); // 注意：这里的4是指列表中第四个元素
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.remove(3);
        // ...

        // 把LinkedList当作栈。链表头是栈顶
        linkedList.push(5); // 栈顶添加
        linkedList.pop(); // 栈顶删除

        //把LinkedList当作单向队列
        linkedList.offer(1); //向队尾add
        linkedList.peek(); // 获取队首元素,队列为空返回null
        linkedList.element(); // 获取队首元素,队列为空抛出异常
        linkedList.poll(); // 获取队首元素并删除,队列为空返回null
        linkedList.remove(); // 获取队首元素并删除,队列为空抛出异常

        //把LinkedList当作双向队列
        linkedList.offerLast(1); // 向队尾add
        linkedList.offerFirst(1); // 向队头add
        linkedList.peekFirst();// 在队头获取
        linkedList.peekLast();// 在队尾获取
        linkedList.pollFirst();// 在队头获取并删除
        linkedList.pollLast(); // 在队尾获取并删除
    }

    @Test
    public void removeTest() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 1, 2));
        list.remove(new Integer(1));    // 结果表明只会删除第一次出现的元素
        log.info("list:{}", Arrays.toString(list.toArray(new Integer[list.size()])));
    }
}
