package com.atguigu.algorithmproblems.arrays;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两
 * 个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author denghp
 * @create 2021-11-15 18:51
 */
public class TwoSum {
    public static void main(String[] args) {
        //定义输入数据
        int[] input1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] input2 = {3, 2, 4};
        int target2 = 6;

        int[] input3 = {3, 3};
        int target3 = 6;

        //创建对象，调用方法进行计算
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum2(input3, target3);

        //打印输出结果
        for (int index : output) {
            System.out.print(index + "\t");
        }

    }

    //1、暴力法，找到所有的两数组合
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;

        //可以先定一个数字，然后依次遍历另一个数字
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                //判断当前两数组合，和是否为target
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("无解");
    }

    //2、使用哈希表保存数据信息，访问两次哈希表
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;

        //创建一个哈希表，key1是数组中的元素，value是元素的索引位置
        HashMap<Integer, Integer> map = new HashMap<>();

        //遍历数组，将数据信息全部保存在哈希表
        /*for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }*/

        //遍历数组，挨个查找每个数对应的“那个数”是否在map中
        for (int i = 0; i < n; i++) {
            int thatNum = target - nums[i];

            //如果存在，并且索引位置不是i，直接返回结果
            if (map.containsKey(thatNum) && i != map.get(thatNum)) {
                return new int[]{i, map.get(thatNum)};
            }

            //如果没找到，就把自己的信息填入表中，等待“那个数”
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("无解！");

    }
}
