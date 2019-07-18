package com.lpl.test.firstndkproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtil {


    //返回数组中两个数的和等于target的数的索引，nums为有序数组
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] index = null;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int j = 0; j < nums.length; j++) {

            int temp = target - nums[j];
            //有值，且不是自己 例如 6=3+3，nums[0]=3, map.get(3)=0,要排除
            if (map.get(temp) != null && map.get(temp) != j) {
                index = new int[]{j, map.get(temp)};
                j = nums.length;
            }

        }

        return index;

    }

    //找出数组中三个数的和等于0的所有的数组
   /* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
   使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]
 */
    //nums有序
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //nums为空、长度小于3、最小值大于0、最大值小于0这些不存在结果的，直接返回
        if (nums == null || nums.length < 3 || nums[0] > 0 && nums[nums.length - 1] < 0) {
            //不存在符合条件的数，直接return
            return listList;
        }

        //判断数组中的所有数据都为0的特殊情况
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            listList.add(Arrays.asList(0, 0, 0));
            return listList;
        }
        //将集合中的数 转存在map中 数作为key,索引为value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int temIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (i == temIndex && nums[j] == nums[j - 1]) {
                    continue;
                }
                temIndex = i;
                int sum = temp + nums[j];
                Integer index = map.get(-sum);
                if (index != null && index != j && index != i && index > j) {
                    //当index小于j时，说明以查找过，则不再使用
                    listList.add(Arrays.asList(temp, nums[j], -sum));
                }
            }

        }


        return listList;
    }

   /* 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
   找出 nums 中的三个整数，使得它们的和与 target 最接近。
   返回这三个数的和。假定每组输入只存在唯一答案。

    例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

    与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/


    public int threeSumClosest(int[] nums, int target) {
        //当前和target最小的差值
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                for (int p = j + 1; p < nums.length; p++) {
                    int temp = nums[i] + nums[j] + nums[p];
                    if (Math.abs(target - temp) < min) {
                        min = Math.abs(target - temp);
                        sum = temp;
                    }


                }
            }

        }

        return sum;

    }




}
