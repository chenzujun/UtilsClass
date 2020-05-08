package com.grammar.collection.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: mustang
 * @create: 2018-04-25
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        System.out.println("开始===size="+queue.size());

        //返回第一个元素，并在队列中删除
        System.out.println("poll="+queue.poll()+" | size="+queue.size());

        //返回第一个元素或异常
        System.out.println("element="+queue.element()+" | size="+queue.size());

        //返回第一个元素或null： if this queue is empty
        System.out.println("peek="+queue.peek()+" | size="+queue.size());
        for(String q : queue){
            System.out.println(q);
        }
    }
}
