package com.lpl.test.firstndkproject;

import android.support.annotation.NonNull;

public class Node implements Comparable<Node> {
    //权
    public int whigth;
    //数据
    public Byte data;
    public Node left;
    public Node right;

    public Node(Byte data, int whigth) {
        this.data = data;
        this.whigth = whigth;

    }

    @Override
    public int compareTo(@NonNull Node node) {
        return node.whigth - this.whigth;
    }
}
