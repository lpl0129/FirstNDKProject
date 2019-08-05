package com.lpl.test.firstndkproject;

import android.util.Log;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }


        //需要删除的索引位置
        int index = length - n;
        //记录当前节点索引
        int pos = 0;
        //当前节点
        temp = head;
        //记录当前节点的上一个节点
        ListNode previous = null;
        while (pos < index) {
            previous = temp;
            temp = temp.next;
            pos++;
        }

        if (previous == null) {
            //说明删除的是头结点，则将头结点的下一个节点做为头节点

            return head.next;
        }

        previous.next = temp.next;


        return head;
    }


    public boolean isValid(String s) {

        //分析，只存在三种正确的方式，中心对称字符是一对括号，一种相邻两个字符是一对括号
        //{[()]} 、{}[]()、{[]([])}
        boolean res = false;
        if (s==null||s.length() % 2 > 0) {
            //字符串长度一点是2的整数倍
            return res;
        }

        char[] chars = s.toCharArray();

        //找到中心位置
        int axle = s.length() / 2;
        int stepSize = 0;
        int left = axle - 1;


        res = true;
        while (res && left - stepSize >= 0) {
            //默认结果设置为true，循环遍历 以中心对称的两个字符，直到left=0;
            res = comparison(chars[left - stepSize], chars[axle + stepSize]);
            stepSize++;
        }
        if (res) {
            //如果为true ，则不用在遍历其他情况，因为其他情况一定为false
            return res;
        }

        left = 0;
        stepSize = 0;
        axle = 1;
        res = true;
        while (res && axle + stepSize < s.length()) {
            //默认结果设置为true，循环遍历 相邻的两个字符，直到left=0;
            res = comparison(chars[left], chars[axle]);
            left += 2;
            axle += 2;
        }
        if (res) {
            //如果为true ，则不用在遍历其他情况，因为其他情况一定为false
            return res;
        }

        //不规则情况 {[]}()、{()[]}
        //"[({(())}[()])]"
        left = 0;
        stepSize = 0;
        axle = left + 1;//1 = 2^stepSize
        while (axle < s.length()) {
            //"(([])){}"
            //从头开始找 对应的右括号一定出现在 奇数位
            if (comparison(chars[left], chars[axle]) && (axle - left - 1) % 2 == 0) {
                if (axle == s.length() - 1) {
                    //已经是最后一位
                    return res = isValid(s.substring(++left, axle));
                } else {
                    res = isValid(s.substring(left+1, axle)) && isValid(s.substring(axle + 1));
                    if (res) {
                        return res;
                    } else {
                        axle += 2;
                    }
                }
            } else if (axle < s.length()) {
                axle += 2;
            } else {
                return false;
            }

        }


        return res;
    }


    private boolean comparison(char left, char right) {

        boolean res = false;

        if (left == '(' && right == ')') {
            res = true;
        } else if (left == '[' && right == ']') {
            res = true;
        } else if (left == '{' && right == '}') {
            res = true;
        }


        return res;
    }



  /*  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {




    }
*/



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
