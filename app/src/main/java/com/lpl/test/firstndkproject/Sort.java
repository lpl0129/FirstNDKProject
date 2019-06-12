package com.lpl.test.firstndkproject;

public class Sort {


    //冒泡排序
    public static int[] bobbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        return arr;
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

            arr[hig] = arr[low];

        }

        arr[low] = temp;

        return low;

    }

    //快速排序调度
    public static int[] quick(int array[], int start, int end) {
        int par = quickSort(array, start, end);
        if (par > start + 1) {
            quick(array, 0, par);
        }
        if (par < end - 1) {
            quick(array, par + 1, array.length - 1);
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
}
