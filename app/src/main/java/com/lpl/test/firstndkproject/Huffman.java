package com.lpl.test.firstndkproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Huffman {
    String str = "can you can a can more";

    public void sortHuffmanCode(String str) {
        byte[] bytes = str.getBytes();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            if (map.get(b) == null) {
                map.put(b, 1);
            } else {
                int i = map.get(b);
                i++;
                map.put(b, i);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + "----" + entry.getValue());

        }

    }

    private void sring2Byte(String str) {
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }



    class Node{



    }

}
