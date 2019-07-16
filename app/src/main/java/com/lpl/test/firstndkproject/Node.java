package com.lpl.test.firstndkproject;

import android.support.annotation.NonNull;

public class Node implements Comparable<Node> {
    //权
    public int weight;
    //数据
    public Byte data;
    public Node left;
    public Node right;

    public Node(Byte data, int whigth) {
        this.data = data;
        this.weight = whigth;

    }

    @Override
    public int compareTo(@NonNull Node node) {
        return this.weight-node.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }
}
