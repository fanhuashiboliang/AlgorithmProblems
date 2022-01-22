package com.atguigu.algorithmproblems.arrays;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使 得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例: 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @author denghp
 * @create 2021-11-16 7:34
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] inputList = {-1, 0, 1, 2, -1, -4};

        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum3(inputList));

    }

    //1、 暴力法，遍历所有三数可能的组合
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        //定义输出列表
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        //三重for循环
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    //判断当前三个数和是否为0，如果是，添加一组解到resultList
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return resultList;
    }

    //1-1 暴力解法优化
    public List<List<Integer>> threeSum1_1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int thatNum = 0 - nums[i];
            if (map.containsKey(thatNum) && !set.contains(nums[i])) {
                ArrayList<Integer> tempList = new ArrayList<>(map.get(thatNum));
                tempList.add(nums[i]);
                result.add(tempList);
                set.add(nums[i]);
            }
            for (int j = 0; j < i; j++) {
                int twoSum = nums[i] + nums[j];
                if (!map.containsKey(twoSum) && !(set1.contains(nums[i]) || set1.contains(nums[j]))) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    map.put(twoSum, tempList);
                    set1.add(-twoSum);
                }
            }
        }
        return result;
    }

    //2、使用哈希表进行优化
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        //定义输出列表
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        //定义一个哈希表，应该保存数据元素的信息，已经对应匹配的另两个数的信息
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        //遍历数组，寻找每个数队友的thatNum是否在map中
        for (int i = 0; i < n; i++) {
            int thatNum = -nums[i];

            //如果存在，那么就添加一组解
            if (hashMap.containsKey(thatNum)) {
                ArrayList<Integer> tempList = new ArrayList<>(hashMap.get(thatNum));
                //添加当前数进入数组
                tempList.add(nums[i]);
                resultList.add(tempList);
            }

            //如果不存在，就遍历之前的所有元素，与当前数据构成二元组进行保存
            for (int j = 0; j < i; j++) {
                int newKey = nums[i] + nums[j];
                if (!hashMap.containsKey(newKey)) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    hashMap.put(newKey, tempList);
                }
            }
        }
        return resultList;
    }

    //3、双指针法  固定一个数，设置其左指针指向这个固定数后的第一个位置，设置右指针指向数组最后一个数的位置
    //固定数和左指针对应的数和右指针对应的输之和，如果大于0，右指针左移，使其和慢慢变小
    //其和如果小于0，向右移动左指针，使其和慢慢变大
    //如果两指针相遇，或者错过，其和还不为0，则固定数加1，没有找到对应的数组；如果固定数已经大于0，则结束
    //如果前一个固定数和当前固定数相同，则跳过
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();

        int num = 0;
        int L = 0;
        int R = 0;

        for (int i = 0; i < n; i++) {
            num = nums[i];
            L = i + 1;
            R = n - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == num) {
                continue;
            }

            while (L < R) {
                int sum = num + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(num, nums[L], nums[R]));
                    L++;
                    R--;
                    while (L < R && nums[L - 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R + 1] == nums[R]) {
                        R--;
                    }
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return result;
    }

}
