package stack;

import linkedlist.SingleLinkedList;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName: LinkedQueue
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/21 16:20
 */
public class LinkedQueue {
    public SingleLinkedList singleLinkedList=new SingleLinkedList();

    public void add(int data){
        singleLinkedList.addLast(data);
    }

    public int  pop(){
        int data=singleLinkedList.getFirstData();
        singleLinkedList.deleteIndex(0);
        return data;
    }

    public static void main(String[] args){
        LinkedQueue linkedQueue=new LinkedQueue();
        linkedQueue.add(1);
        linkedQueue.add(2);
        linkedQueue.add(3);
        System.out.println(linkedQueue.pop());
        System.out.println(linkedQueue.pop());
        System.out.println(linkedQueue.pop());
        Queue<Integer> queue=new ArrayBlockingQueue<>(10);
    }
}
