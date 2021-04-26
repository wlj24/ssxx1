package stack;

/**
 * @ClassName: ArrayQueue
 * @Description:
 * @Author: wlj
 * @Date: 2021/4/21 15:54
 */
public class ArrayQueue {
    int[] array=null;
    private int elementCount=0;
    private int size;
    public ArrayQueue(int size){
        array=new int[size];
        this.size=size;
    }

    public void push(int data){
        array[elementCount]=data;
        elementCount++;
    }

    public int pop(){
        int data=array[0];
        for(int i=1;i<=elementCount;i++){
            array[i-1]=array[i];
        }
        elementCount--;
        return data;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(10);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
    }




}
