package stack;

import linkedlist.SingleLinkedList;


/**
 * @ClassName: LinkedStack
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/21 15:32
 */
public class LinkedStack {
    private SingleLinkedList singleLinkedList=new SingleLinkedList();


    public void push(int data){
        singleLinkedList.addFirst(data);
    }

    public  int  pop(){
         int data=singleLinkedList.getFirstData();
         singleLinkedList.deleteIndex(0);
         return data;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack=new LinkedStack();
        linkedStack.push(3);
        linkedStack.push(2);
        linkedStack.push(1);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }


}
