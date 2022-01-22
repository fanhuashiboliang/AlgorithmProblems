package com.atguigu.algorithmproblems.binarysearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * @author denghp
 * @create 2021-11-21 16:46
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 11;

        boolean bool = searchMatrix(matrix,target);
        System.out.println(bool);
        System.out.println("---------------");
        System.out.println(searchMatrix1(matrix, 11));
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        //定义m和n
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        //定义左右指针，二分查找
        int left = 0;
        int right = m * n - 1;

        while (left <= right){
            int midIndex = (left + right) / 2;
            int midElement = matrix[midIndex/n][midIndex%n];
            if(midElement < target)
                left = midIndex + 1;
            else if(midElement > target)
                right = midIndex - 1;
            else
                return true;
        }

        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target){
        int m = matrix.length;
        if(m==0) {
            return false;
        }
        int n = matrix[0].length;
        int start = 0;
        int end = m*n-1;


        while (start<=end){
            int mid = (start+end)/2;
            int matrixMid = matrix[mid/n][mid%n];
            if(target<matrixMid){
                end = mid-1;
            }else if(target>matrixMid){
                start = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

}
