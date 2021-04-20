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

     public Node reverse3(){
         Node pre=null;
         Node node=first;
         while (node != null) {
          Node next=node.next;
          node.next=pre;
          pre=node;
          node=next;
         }
         return pre;
     }

     //头插
     public void addFirst(int  data) {
         if (first == null) {
             first = new Node(data);
         } else {
             Node newNode = new Node(data, first);
             first = newNode;
         }
         size++;
     }

     //尾插
     public void addLast(int  data) {
         if (first == null) {
             first = new Node(data);
         } else {
             Node newNode = new Node(data);
             Node node = first;
             while (node.getNext() != null) {
                 node = node.getNext();
             }
             node.setNext(newNode);
          //   newNode.setNext(first);
         }
         size++;
     }

     public void addIndex(int  o,int index){
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

    public Node revese(){
        Node node = first;
        Node pre = null;
        while (node != null) {
            Node tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

    //迭代反转
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

    //递归反转
    public Node reverse1(Node node){
        if (node.getNext()==null){
            return node;
        }
        Node p=reverse1(node.getNext());
        node.next.next=node;
        node.next=null;
        return p;
    }

   //判断链表是否有环
    public boolean hasCircle(Node first) {
         if (first==null || first.next==null){
             return false;
         }
         Node fast=first;
         Node low=first;
         while (fast!=null && fast.next!=null){
             fast=fast.next.next;
             low=low.next;
             if (fast==low){
                 return true;
             }
         }
       return false;
    }

    //判断链表是否有环
    public boolean hasCycle(Node first) {
        if (first == null || first.next == null) {
            return false;
        }
        Node fast = first;
        Node low = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (low.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    //求链表中间节点
    public Node getMid(Node first) {
        if (first == null) {
            return first;
        }
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    public static  Node deleteK(Node first, int k) {
        Node fast = first;
        if (fast == null) {
            return fast;
        }
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        Node slow=first;
        Node pre=null;
        while (fast!=null && fast.next!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=pre.next.next;
        return first;
    }

    public static Node order(Node list1, Node list2) {
            if (list1 ==null){
                return list2;
            }
            if (list2 ==null){
                return list1;
            }
        if (list1.getData() < list2.getData()) {
            list1.next=order(list1.next,list2);
            return list1;
        }else {
            list2.next=order(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();
//        singleLinkedList.addFirst(3);
////        singleLinkedList.addFirst(2);
//        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        SingleLinkedList singleLinkedList1=new SingleLinkedList();
        singleLinkedList1.addLast(1);
        singleLinkedList1.addLast(2);
        singleLinkedList1.addLast(3);
        Node node= order(singleLinkedList.first,singleLinkedList1.first);

 //       singleLinkedList.addLast(5);
//        singleLinkedList.addIndex(2,1);
//        singleLinkedList.addIndex(2,1);
//        singleLinkedList.addIndex(10,3);
 //       singleLinkedList.deleteIndex(3);
     //   singleLinkedList.reverse3();
     //   singleLinkedList.first= singleLinkedList.reverse3();
        System.out.println(singleLinkedList.hasCircle(singleLinkedList.first));
        Object o= singleLinkedList.getMid(singleLinkedList.first).getData();
        System.out.println(o);
        deleteK(singleLinkedList.first,0);
        singleLinkedList.print();
    }


}


class Node{
    private int  data;
    public Node next;

    public Node(int  data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int  data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
