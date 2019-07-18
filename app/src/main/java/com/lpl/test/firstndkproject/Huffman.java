package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman {
    String str = "can can can ccc cnan b";

    public byte[] HuffmanZip(String str) {
        //字符串转byte数组
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes) + "     " + bytes.length);
        //统计每个字符出现的次数，并创建节点对象的集合
        List<Node> nodes = getNodes(bytes);
        //生成Huffman树
        Node rootNode = getRootNode(nodes);

        //生成Huffman编码表
        Map<Byte, String> map = getHuffmanCode(rootNode);

        //编码
        byte[] zipBytes = zip(bytes, map);

        return zipBytes;
    }

    //统计每个字符出现的次数
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
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }

    private Node getRootNode(List<Node> nodes) {

        while (nodes.size() > 1) {
            //不断循环，生成二叉树
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node root = new Node(null, left.weight + right.weight);
            root.left = left;
            root.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(root);
        }
        //最后集合只有一个元素，即跟节点
        return nodes.get(0);
    }


    //用于临时存储路径
    private StringBuilder sb = new StringBuilder();
    //存储Huffman编码表
    public Map<Byte, String> huffmanCodeMap = new HashMap<>();

    /**
     * 通过赫夫曼 树得到赫夫曼编码表
     *
     * @param tree
     * @return
     */
    private Map<Byte, String> getHuffmanCode(Node tree) {
        if (tree == null) {

            return null;

        }
        getCode(tree.left, "0", sb);
        getCode(tree.right, "1", sb);
        return huffmanCodeMap;
    }

    private void getCode(Node node, String str, StringBuilder sb) {

        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(str);
        if (node.data == null) {
            //说明该节点不是叶节点
            getCode(node.left, "0", stringBuilder);
            getCode(node.right, "1", stringBuilder);
        } else {
            huffmanCodeMap.put(node.data, stringBuilder.toString());

        }
    }

    /**
     * 使用Huffman编码表，对字符数组进行编码
     *
     * @param bytes
     * @param codes
     * @return
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> codes) {


        StringBuilder builder = new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制字符串
        for (byte b : bytes) {
            builder.append(codes.get(b));
        }
        System.out.println("转前的字符串  " + builder.toString());
        int size = 0;
        if (builder.length() % 8 == 0) {
            size = builder.length() / 8;
        } else {
            size = builder.length() / 8 + 1;
        }
        //用于存储压缩后的byte
        byte[] newCodes = new byte[size];
        int index = 0;
        for (int i = 0; i < builder.length(); i += 8) {
            String str;
            if (i + 8 > builder.length()) {
                str = builder.substring(i);
            } else {
                str = builder.substring(i, i + 8);
            }

            byte b = (byte) Integer.parseInt(str, 2);
            newCodes[index] = b;
            index++;
        }

        return newCodes;
    }


    /**
     * 解码
     *
     * @param huffmanCodeMap 编码表
     * @param bytes          编码后的byte集合
     * @return
     */
    public byte[] decode(Map<Byte, String> huffmanCodeMap, byte[] bytes) {
        List<Byte> list = new ArrayList<>();

        //把byte集合装成二进制字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = (i == bytes.length - 1);
            sb.append(byte2BitStr(!flag, b));
        }
        System.out.println("转后的字符串  " + sb.toString());
        //把字符串按照指定的Huffman编码表进行解码
        //把Huffman编码表的键值对进行调换
        Map<String, Byte> newMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        //处理字符串
        for (int i = 0; i < sb.length(); ) {

            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //从i开始不端的截取字符串去map中取值
                String key = sb.substring(i, i + count);
                b = newMap.get(key);
                System.out.println("b====="+b);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            i += count;
            list.add(b);
        }

        byte[] newB = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newB[i] = list.get(i);
        }
        return newB;
    }

    private String byte2BitStr(boolean flag, byte b) {

        int temp = b;
        System.out.println("------sss 1 ---" +b);
        //是否需要位或
        if (flag) {
            temp |= 256;
        }
        System.out.println("------sss 2 ---" +temp);
        String str = Integer.toBinaryString(temp);
        System.out.println("------sss 3 ---" +str);
        if (flag) {
            System.out.println("------sss 4 ---" + str.substring(str.length() - 8));
            return str.substring(str.length() - 8);
        } else {
            System.out.println("------sss 5 ---" + str);
            return str;
        }

    }
}
