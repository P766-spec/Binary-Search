package com.company;
// https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1

import java.util.*;
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {

        int size = 6;
        int[] a = {5,8,3,7,9,1};
        System.out.println(longestSubsequence(size, a));

    }
    static int longestSubsequence(int size, int[] a){
        int[] result = new int[size];
        int len = 1;
        result[0] = a[0];
        for(int i= 0; i<size; i++){
            if(a[i] < result[0]){
                result[0] = a[i];
            }
            else if (a[i] > result[len - 1]){
                result[len] = a[i];
                len++;
            } else {
                int index = binarySearch(result, 0, len - 1, a[i]);
                result[index] = a[i];
            }
        }
        return len;
    }
    private static int binarySearch(int[] result, int start, int end, int key){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(result[mid] == key)
                return mid;

            else if (result[mid] < key)
                start= mid + 1;

            else
                end = mid - 1;
        }

        return start;
    }


}
