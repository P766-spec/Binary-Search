package com.company;
// https://leetcode.com/problems/search-a-2d-matrix/

import java.util.*;
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }
    // brute force
//    static boolean searchMatrix(int[][] matrix, int target){
//        int n = matrix.length;
//        int m = matrix[0].length;
//        for(int i =0; i<n; i++){
//            for(int j= 0; j<m; j++){
//                if(matrix[i][j] == target){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//  Optimized solution --> Binary Search
      static boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m * n  -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if(mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid  + 1;
            else
                right = mid - 1;

        }
        return false;
      }

}
