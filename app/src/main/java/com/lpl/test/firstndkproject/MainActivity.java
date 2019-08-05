package com.lpl.test.firstndkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        //TestUtil.letterCombinations("234");

        //Huffman编码测试
     /* Huffman hf = new Huffman();
        byte[] fub = hf.HuffmanZip(hf.str);
        System.out.println(fub.length+"   ------压缩后的长度----------");

        System.out.println(new String(hf.decode(hf.huffmanCodeMap,fub))+"   -------解码后的长度---------");*/

     /*   TestUtil2 tu2 = new TestUtil2();
        List<String> ls = tu2.letterCombinations("");
        System.out.println(ls.toString() + "   ----------------");*/
//"{}{{}}"
       /* Solution solution = new Solution();
        System.out.println(solution.isValid("{}{{}}") + "    对比结果");
        System.out.println(solution.isValid("[({(())}[()])]") + "    对比结果");*/

       //面试前测试下 冒泡排序

        int[] marr= new int[] {4,8,6,1,3,2,5};
        int[] res=MianshiTest.bubbleSort3(marr);
        System.out.println(Arrays.toString(res)+"   冒泡排序");

        int[] marr1= new int[] {4,8,6,1,3,2,5};
        int[] res1=MianshiTest.quick3(marr1,0,marr1.length-1);
        System.out.println(Arrays.toString(res1)+"   快速排序");

        int[] marr2= new int[] {4,8,6,1,3,2,5};
        int[] res2=MianshiTest.inSort3(marr2);
        System.out.println(Arrays.toString(res2)+"   插入排序");

        System.out.println( MianshiTest._2f(res,9,0,res.length-1)+"  二分查找");
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
