package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtil2 {

    private Node root = new Node("");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        char[] chars = digits.toCharArray();
        List<List<String>> lists = new ArrayList<>();
        for (char c : chars) {
            lists.add(char2String(c));
        }


        //生成树
        tree(root, lists, 0);

        return ergodicTree(root);
    }

    //用于临时存储路径
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();

    /**
     * 遍历树
     *
     * @param tree
     * @return
     */
    private List<String> ergodicTree(Node tree) {

        getCode(tree, tree.c, sb);
        return res;
    }

    private void getCode(Node node, String str, StringBuilder sb) {

        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(str);

        if (node.nodes.size() > 0) {
            for (Node n : node.nodes) {
                getCode(n, n.c, stringBuilder);
            }
        } else {
            res.add(stringBuilder.toString());
        }

    }

    private void tree(Node node, List<List<String>> lls, int index) {

        List<String> cl = lls.get(index);
        for (String c : cl) {
            node.nodes.add(new Node(c));
        }
        index++;
        if (index < lls.size()) {
            for (Node n : node.nodes) {
                tree(n, lls, index);
            }
        }


    }


    private static List<String> char2String(char c) {
        List<String> characters = null;
        switch (c) {
            case '1':
                characters = Arrays.asList("");
                break;
            case '2':
                characters = Arrays.asList("a", "b", "c");
                break;
            case '3':
                characters = Arrays.asList("d", "e", "f");
                break;
            case '4':
                characters = Arrays.asList("g", "h", "i");
                break;
            case '5':
                characters = Arrays.asList("j", "k", "l");
                break;
            case '6':
                characters = Arrays.asList("m", "n", "o");
                break;
            case '7':
                characters = Arrays.asList("p", "q", "r", "s");
                break;
            case '8':
                characters = Arrays.asList("t", "u", "v");
                break;
            case '9':
                characters = Arrays.asList("w", "x", "y", "z");
                break;


        }
        return characters;
    }

    private class Node {

        String c;
        List<Node> nodes;

        public Node(String c) {
            this.c = c;
            nodes = new ArrayList<>();
        }

    }
}
