package com.lpl.test.firstndkproject;

import java.util.Arrays;

public class Sort {


    //冒泡排序
    public static void bobbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("第" + (i + 1) + "轮排序第" + (j + 1) + "次" + Arrays.toString(arr));
            }


            System.out.println("第" + (i + 1) + "轮排序的结果" + Arrays.toString(arr));
        }

        //  return arr;
    }

    //快速排序
    public static int quickSort(int[] arr, int low, int hig) {

        int temp = arr[low];

            while (low < hig) {

            while (low < hig && arr[hig] > temp) {

                hig--;

            }

            arr[low] = arr[hig];

            while (low < hig && arr[low] < temp) {

                low++;
            }
            System.out.println("快速排序前===" + Arrays.toString(arr));
            arr[hig] = arr[low];
            System.out.println("快速排序hou===" + Arrays.toString(arr));
        }

        arr[low] = temp;
        System.out.println("快速排序后===" + Arrays.toString(arr));
        return low;

    }

    //快速排序调度
    public static int[] quick(int array[], int start, int end) {
        int par = quickSort(array, start, end);
        if (par > start + 1) {
            quick(array, start, par);
        }
        if (par < end - 1) {
            quick(array, par + 1, end);
        }

        return array;
    }

    //插入排序
    public static int[] insertionSort(int[] arr) {


        int size = arr.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {

                arr[j] = arr[j - 1];

            }

            arr[j] = temp;

        }


        return arr;
    }

    /**
     * @param arr  要求是有序的数组
     * @param key  要查找的值
     * @param low  开始位置
     * @param high 结束为止
     * @return
     */

    public static int binarySearch(int[] arr, int key, int low, int high) {

        //如果需要查找的值小于最小值、大于最大值、或者开始为止大于结束位置时，说明数组中不存在查找的值，返回-1
        if (arr[low] > key || arr[high] < key || low > high) {
            return -1;

        }
        //取中间位置
        int mind = (low + high) / 2;
        //如果中间位置的上值大于key，则在左子集中找
        if (arr[mind] > key) {

            return binarySearch(arr, key, low, mind - 1);
        } else if (arr[mind] < key) {
            //中间值小于key 在右子集中找
            return binarySearch(arr, key, mind + 1, high);
        } else {
            //否则说明当前值等于key
            return mind;
        }


    }


}
