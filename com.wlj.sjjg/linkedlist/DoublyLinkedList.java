package linkedlist;

/**
 * @ClassName: DoublyLinkedList
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/19 14:42
 */
public class DoublyLinkedList {
    private Node head;
    private Node last;
    private int size;

    public void addLast(Object data) {
        if (head == null) {
            head = new Node(data);
            last = head;
        } else {
            Node node = new Node(data);
            node.pre = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(Object data) {
        if (head == null) {
            head = new Node(data);
            last = head;
        } else {
            Node node = new Node(data);
            node.next=head;
            head.pre=node;
            head=node;
        }
        size++;
    }

    public void deleteFirst() {
        if (head != null) {
            Node node = head.next;
            node.pre=null;
            head = node;
        }
    }


    public void deleteLast() {
        if (last != null) {
            Node node=last.pre;
            node.next=null;
            last=node;
        }
    }
    public void deleteIndex(int index ){
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("");
        }
        if (index == 0) {
            deleteFirst();
        } else if (index == size - 1) {
            deleteLast();
        } else {
            Node node = head;
            for (int i = 0; i < index ; i++) {
                node = head.next;
            }

            Node pre=node.pre;
            Node next=node.next;
            pre.next=next;
            next.pre=pre;

        }
    }

    public void addIndex(int index, int data) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("");
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = head.next;
            }
            newNode.pre = node;
            node.next.pre = newNode;
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public void printAsc() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void printDsc() {
        Node node = last;
        while (node != null) {
            System.out.println(node.data);
            node = node.pre;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addFirst(-1);
        doublyLinkedList.addIndex(1,0);
        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteLast();
        doublyLinkedList.deleteIndex(1);
        doublyLinkedList.printAsc();
        doublyLinkedList.printDsc();
    }



    static class Node{
      public Node next;
      public Node pre;
      public Object data;
      public Node(Object data){
          this.data=data;
      }
    }
}


