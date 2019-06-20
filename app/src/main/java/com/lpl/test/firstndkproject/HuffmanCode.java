package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HuffmanCode {

    //带编码的字符串
    String str = "can you can a can more";

    public void string2Sort(String str) {

        //字符串装换为 char 数组
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars) + "     " + chars.length);
        //定义统计每个字符出现的map   以字符为 key 次数为value
        Map<Integer, Integer> map = new HashMap();

        for (char c : chars) {
            //将char 转为ASCII吗
            int ascii = (int) c;
            Integer i = map.get(ascii);
            if (i == null) {
                i = 1;
                map.put(ascii, i);
            } else {
                i++;
                map.put(ascii, i);
            }

        }

        System.out.println(map);
        //将map  转换为 数组
        Node[] nodes = new Node[map.entrySet().size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Node node = new Node();
            node.asc = entry.getKey();
            node.value = entry.getValue();
            nodes[i] = node;
            i++;
        }
        //根据出现的次数 排序
        // System.out.println(Arrays.toString(bobbleSort(nodes)));

        huffmanTree(bobbleSort(nodes));


        byte[] bytes = str.getBytes();
        StringBuilder sb3 = new StringBuilder();
        for (byte b : bytes) {
            sb3.append(newmap.get(Integer.valueOf(b)));
        }

        System.out.println(bytes.length);
        System.out.println(sb3.toString());
        String string = sb3.toString();
        int bLength = 0;
        if (string.length() % 8 == 0) {
            bLength = string.length() / 8;
        } else {
            bLength = string.length() / 8 + 1;
        }
        //存放编码收的byte
        byte[] b2 = new byte[bLength];

        for (int j = 0; j < string.length(); j += 8) {
            String num;
            if (j + 8 > string.length()) {
                num = string.substring(j);
            } else {
                num = string.substring(j, j + 8);
            }
            byte b = (byte) Integer.parseInt(num, 2);
            b2[j / 8] = b;

        }
        System.out.println(Arrays.toString(b2)+"------shdahdfkah");

    }


    private Node[] bobbleSort(Node[] nodes) {

        for (int i = 0; i < nodes.length - 1; i++) {

            for (int j = 0; j < nodes.length - 1 - i; j++) {
                if (nodes[j].value > nodes[j + 1].value) {
                    Node temp = nodes[j];
                    nodes[j] = nodes[j + 1];
                    nodes[j + 1] = temp;
                }

            }

        }
        return nodes;
    }


    //使用排序好的数据 生成Huffman树
    private Node[] huffmanTree(Node[] nodes) {
        System.out.println(Arrays.toString(nodes));
        if (nodes.length < 2) {
            getHuffmanCodeForm(nodes[0]);
            System.out.println(newmap);
            return nodes;
        }

        Node n1 = nodes[0];

        Node n2 = nodes[1];

        Node n3 = new Node();
        n3.value = n1.value + n2.value;
        n3.left = n1;
        n3.right = n2;

        Node[] newNodes = new Node[nodes.length - 1];
        for (int i = 2; i < nodes.length; i++) {
            newNodes[i - 2] = nodes[i];
        }
        newNodes[newNodes.length - 1] = n3;
        System.out.println(n1.toString() + "     " + n2.toString());
        System.out.println("-----------------------------------");
        huffmanTree(bobbleSort(newNodes));

        return newNodes;
    }


    /**
     * 获取Huffman编码表
     *
     * @param map
     * @param node
     * @return
     */
    Map<Integer, String> newmap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    //获取Huffman编码对照表
    private Map<Integer, String> getHuffmanCodeForm(Node node) {

        if (node == null) {
            return null;
        }
        getCode(node.left, "0", sb);
        getCode(node.right, "1", sb);
        return newmap;
    }

    private void getCode(Node node, String s, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(s);
        // System.out.println(node == null);
        if (node.asc == null) {
            getCode(node.left, "0", sb2);
            getCode(node.right, "1", sb2);
        } else {
            newmap.put(node.asc, sb2.toString());
        }


    }

    class Node {

        Integer asc;
        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "asc=" + asc +
                    ", value=" + value +
                    '}';
        }


        public void getNode() {
            System.out.println("value====" + value + "  ascii " + asc);
            if (left != null) {
                left.getNode();
                //System.out.println("left====" + left.value);
            }
            if (right != null) {
                right.getNode();
                // System.out.println("right====" + right.value);
            }
        }
    }


}
