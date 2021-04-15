package linkedlist;

/**
 * @ClassName: SingleLinkedList
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/15 10:38
 */
public class SingleLinkedList {
     private Node first;
     private int size;

     //头插
     public void addFirst(Object data){
         if (first==null){
             first=new Node(data);
         }else {
             Node newNode=new Node(data,first);
             first=newNode;
         }
         size++;
     }

     //尾插
     public void addLast(Object data){
         if (first==null){
             first=new Node(data);
         }else {
             Node newNode=new Node(data);
             Node node = first;
             while (node.getNext() != null) {
                 node=node.getNext();
             }
             node.setNext(newNode);

         }
         size++;
     }

     public void addIndex(Object o,int index){
         if (index > size || index < 0) {
             throw new IndexOutOfBoundsException("数组越界");
         }
         if (index == 0) {
             addFirst(o);
         } else if (index == size) {
             addLast(o);
         } else {
             Node node = first;
             for (int i = 1; i < index ; i++) {
                 node = node.getNext();
             }
             Node newNode = new Node(o, node.getNext());
             node.setNext(newNode);
         }
         size++;
     }

     public void deleteIndex(int index){
         if (index >= size || index < 0) {
             throw new IndexOutOfBoundsException("数组越界");
         }
         if (index == 0) {
             if (first == null) {
                 throw new IndexOutOfBoundsException("数组越界");
             } else {
                 first = first.getNext();
             }
         } else {
             Node node = first;
             for (int i = 1; i < index ; i++) {
                 node = node.getNext();
             }
             node.setNext(node.getNext().getNext());
         }
         size--;
     }

    private void print() {
        Node node = first;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    //迭代
    public Node reverse(){
        Node node = first;
        Node pre=null;
        while (node != null) {
             Node tmp=node.getNext();
             node.setNext(pre);
             pre=node;
             node=tmp;
        }
        return pre;
    }

    //递归
    public Node reverse1(Node node){
        if (node.getNext()==null){
            return node;
        }
        Node p=reverse1(node.getNext());
        node.next.next=node;
        node.next=null;
        return p;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addFirst(3);
//        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addIndex(2,1);
        singleLinkedList.addIndex(2,1);
        singleLinkedList.addIndex(10,3);
        singleLinkedList.deleteIndex(3);
        singleLinkedList.first= singleLinkedList.reverse1(singleLinkedList.first);
        singleLinkedList.print();
    }


}


class Node{
    private Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
