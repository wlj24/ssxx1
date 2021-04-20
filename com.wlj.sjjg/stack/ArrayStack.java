package stack;

import java.util.Stack;

/**
 * @ClassName: ArrayStack
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/16 10:19
 */
public class ArrayStack {
    private Object[] array;
    private int size;
    private int elementCount;
    Stack<String> stack=new Stack<>();

    public ArrayStack(int size){
     this.array=new Object[size];
     this.elementCount=0;
     this.size=size;
    }

    public boolean push(Object a) {

      array[size-1-elementCount]=a;
      elementCount++;
      return true;
    }
    public Object pop(){
        Object e= array[size-elementCount];
        elementCount--;
        return e;
    }
    public void print(){
        for (int i=size-1;i>size-1-elementCount;i--){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.print();
    }
}
