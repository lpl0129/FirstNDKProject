package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        //字符串转byte数组
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        List<Node> nodes = getNodes(bytes);
        Node node = getRootNode(nodes);

    }

    private List<Node> getNodes(byte[] bytes) {


        List<Node> nodes = new ArrayList<>();

        //使用map统计每个字符出现的次数
        Map<Byte, Integer> map = new HashMap<>();

        for (byte b : bytes) {

            Integer integer = map.get(b);
            //说明该字符第一次出现
            if (integer == null) {

                map.put(b, 1);
            } else {
                //字符不是第一次出现，出现次数+1
                map.put(b, ++integer);
            }
            // 将统计好的数据转为Node的集合

            for (Map.Entry<Byte, Integer> entry : map.entrySet()) {

                Node node = new Node(entry.getKey(), entry.getValue());
            }


        }


        return nodes;
    }

    private Node getRootNode(List<Node> nodes) {

        while (nodes.size() > 1) {
            //不断循环，生成二叉树
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node root = new Node(null, left.data + right.data);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(root);


        }
//最后集合只有一个元素，即跟节点
        return nodes.get(0);
    }


}
