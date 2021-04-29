package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] array={6,5,8,9,9,1,0,3,10,9};
        System.out.println(Arrays.toString(mpSort(array)));
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] mpSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, array);
        }
        return array;
    }

    public static  void swap(int i,int minIndex,int[] array){
        int tmp=array[minIndex];
        array[minIndex]=array[i];
        array[i]=tmp;
    }
}
