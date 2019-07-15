package com.lpl.test.firstndkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        TextView tv2 = (TextView) findViewById(R.id.sample_text_2);
        tv2.setText(stringFormJMIMtest());

        int[] arr = new int[]{170, 168, 167, 169, 166};

        //   Sort.bobbleSort(arr);
        // System.out.println("冒泡排序====" + Arrays.toString(Sort.bobbleSort(arr)));
        //  System.out.println("快速排序====" + Arrays.toString(Sort.quick(arr, 0, arr.length-1)));
        // System.out.println("插入排序====" + Arrays.toString(Sort.insertionSort(arr)));

        HuffmanCode huffmanCode = new HuffmanCode();
        //   huffmanCode.string2Sort(huffmanCode.str);
        //   System.out.println(Sort.binarySearch(Sort.quick(arr, 0, arr.length - 1), 168, 0, 4));

//        Huffman huffman = new Huffman();
//        huffman.sortHuffmanCode(huffman.str);

        //    System.out.println(Arrays.toString(Sort.quick(arr,0,arr.length-1)));


        //测试两个数的和==target 算法
       /* int[] ind = TestUtil.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ind));*/
       //测试三个数的和等0算法
      //  int[] ind = TestUtil.threeSum(new int[]{3, 2, 4});
      //  System.out.println(TestUtil.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());

        TestUtil.letterCombinations("234");

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    /**
     * 写下的一地个本地方法定义
     */
    public native String stringFormJMIMtest();
}
