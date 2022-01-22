package com.atguigu.algorithmproblems.binarysearch;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author denghp
 * @create 2021-11-22 6:27
 */
public class FindDuplicate {

        public static void main(String[] args) {
                int[] nums1 = {1, 3, 4, 2, 2};
                int[] nums2 = {3, 1, 3, 4, 2};
                int[] nums3 = {1, 1};
                int[] nums4 = {1, 1, 2};
                int[] nums5 = {2, 1, 5, 2, 6, 2, 2, 2};

                FindDuplicate findDuplicate = new FindDuplicate();

                System.out.println(findDuplicate.findDuplicate(nums1));
                System.out.println(findDuplicate.findDuplicate(nums2));
                System.out.println(findDuplicate.findDuplicate(nums3));
                System.out.println(findDuplicate.findDuplicate(nums4));
                System.out.println(findDuplicate.findDuplicate(nums5));
        }

        //1、保存元素法
        public int findDuplicate1(int[] nums) {
                HashMap<Integer, Integer> countMap = new HashMap<>();
                //遍历所有元素，一次统计个数，保存到hashMap
                for (Integer num : nums) {
                        if (!countMap.containsKey(num))
                                countMap.put(num, 1);
                        else
                                return num;
                }
                return -1;
        }

        public int findDuplicate2(int[] nums) {
                HashSet<Integer> set = new HashSet<>();

                for (Integer num : nums) {
                        if (!set.contains(num))
                                set.add(num);
                        else
                                return num;
                }
                return -1;
        }

        //2、二分查找
        public int findDuplicate(int[] nums) {
                int n = nums.length;

                //定义双指针
                int left = 1;
                int right = n - 1;

                while (left <= right) {
                        int i = (left + right) / 2;

                        //对当前i计算count(i)
                        int count = 0;
                        //遍历数组，计算count值
                        for (int j = 0; j < n; j++) {
                                if (nums[j] <= i)
                                        count++;
                        }

                        //根据count值判断继续查询哪一部分
                        if (count <= i)
                                left = i + 1;
                        else
                                right = i;

                        //如果左右指针相遇，则找到了target
                        if (left == right)
                                return left;
                }
                return -1;
        }
}
