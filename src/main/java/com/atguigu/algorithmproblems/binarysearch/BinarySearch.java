package com.atguigu.algorithmproblems.binarysearch;

/**
 * @author denghp
 * @create 2021-11-21 16:12
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {2,3,4,6,7,9,11};
        int[] b = {11,9,7,6,5,4,3};
        int keyIndexA = binarySearch(a,11,0,a.length-1);
        int keyIndexB = binarySearch(a, 6);
        System.out.println(keyIndexA);
        System.out.println(keyIndexB);
        System.out.println("-------------------");
        System.out.println(binarySearch1(a, 6));
        System.out.println(binarySearch1(a, 11, 0, a.length - 1));

    }

    //二分查找，前提：数组有序(从大到小排列)
    public static int binarySearch(int[] a, int key){
        //双指针法，定义查找的范围
        int low = 0,high = a.length-1;

        //排除特殊情况，加快运行速度
        if(key<a[low] || key>a[high]){
            return -1;
        }

        //只要两个指针不相遇，那么就一直选取中间位置进行判断
        while (low <= high){
            int mid = (low + high) / 2;
            if(a[mid]< key){
                low = mid+1;
            }else if (a[mid] > key){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //递归实现
    public static int binarySearch(int[] nums, int key ,int fromIndex, int toIndex){
        //排除特殊情况
        if(key < nums[fromIndex] || key> nums[toIndex] || fromIndex>toIndex)
            return -1;

        int mid = (fromIndex + toIndex) / 2;

        if(nums[mid] < key)
            return binarySearch(nums,key,mid+1,toIndex);
        else if (nums[mid] > key)
            return binarySearch(nums,key,fromIndex,mid-1);
        else
            return mid;
    }

    public static int binarySearch1(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        if (key < a[low] || key > a[high]) {
            return -1;
        }
        if(low<=high){
            int mid = (low+high)/2;
            if(key>a[mid]){
                low = mid+1;
            }else if(key<a[mid]){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int binarySearch1(int[]a, int key, int low, int high){
        if(key<a[low] || key>a[high] || low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(a[mid]>key){
            return binarySearch1(a,key,low,mid-1);
        }else if(a[mid] < key){
            return binarySearch1(a,key,mid+1,high);
        }else{
            return mid;
        }
    }
}
