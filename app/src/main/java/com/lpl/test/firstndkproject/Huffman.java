package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman {
    String str = "can can can ccc cnan";

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


    //用于零时存储路径
    private StringBuilder sb = new StringBuilder();
    //存储Huffman编码表
    private Map<Byte, String> huffmanCodeMap = new HashMap<>();

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

}
