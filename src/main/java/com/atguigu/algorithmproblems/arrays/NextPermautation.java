package com.atguigu.algorithmproblems.arrays;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author denghp
 * @create 2021-11-18 7:13
 */
class NextPermutation {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 1, 5};
        int[] nums4 = {1,};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums1);
        nextPermutation.nextPermutation(nums2);
        nextPermutation.nextPermutation(nums3);
        nextPermutation.nextPermutation(nums4);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println("......................................................");
        nextPermutation.nextPermutation1(nums1);
        nextPermutation.nextPermutation1(nums2);
        nextPermutation.nextPermutation1(nums3);
        nextPermutation.nextPermutation1(nums4);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1;
        //1、从后往前，找到第一对升序排列的两个数
        while (i > 0 && nums[i - 1] >= nums[i]) i--;
//        //2、如果没有找到升序排列的两个数，那么已经是最大的排序，直接返回升序序列
//        if(i <= 0){
//            reverse(nums,0,n-1);
//            return;
//        }

        //3、确定了要替换的数a[i-1],寻找替换它的数
        if (i > 0) {
            int j = i + 1;
            while (j < n && nums[j] > nums[i - 1]) j++;

            //4、交换找到的a[j-1]和a[i-1]
            swap(nums, i - 1, j - 1);
        }

        //5、a[i]之后的子序列替换成升序排列的最小情况，定义双指针头尾调换
        reverse(nums, i, n - 1);
    }

    //定义数组元素交换的方法
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //定义一个反转数组的方法
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation1(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if (k < 0) {
            Arrays.sort(nums);
            return;
        }

        int j = k + 2;
        while (j < nums.length && nums[j] > nums[k]) {
            j++;
        }
        swap1(nums, k, j - 1);

        int start = k + 1;
        int end = nums.length - 1;
        reverse1(nums, start, end);
    }

    public void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            swap1(nums, start, end);
            start++;
            end--;
        }
    }
}
