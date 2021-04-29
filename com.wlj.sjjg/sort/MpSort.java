package sort;

import java.util.Arrays;

public class MpSort {

    public static void main(String[] args) {
        int[] array = {6,4,7,8,1,4,2};
      //  mpSort(array);
      //  selectSort(array);
        System.out.println(Arrays.toString(insertSort(array)));
    }
    //冒泡排序
    public static int[] mpSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flag == true) {
                break;
            }
        }
        return array;
    }

    //选择排序
    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return array;
    }

    public static void swap(int[] array, int minIndex, int i) {
        int tmp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = tmp;
    }

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
         insertRight(array,i);
        }
        return array;
    }

    public static void insertRight(int[] array, int i) {
        int inserted = array[i];
        int j = i - 1;
        for (; j >= 0 && array[j] > inserted; j--) {
            array[j + 1] = array[j];
        }
        array[j + 1] = inserted;
    }


}
