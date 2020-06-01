package hackerrank.sorting.mergesortcountinginversions;

/*
n an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

For example, consider the dataset . It has two inversions:  and . To sort the array, we must perform the following two swaps to correct the inversions:

Given  datasets, print the number of inversions that must be swapped to sort each dataset on a new line.

Function Description

Complete the function countInversions in the editor below. It must return an integer representing the number of inversions required to sort the array.

countInversions has the following parameter(s):

arr: an array of integers to sort .
Input Format

The first line contains an integer, , the number of datasets.

Each of the next  pairs of lines is as follows:

The first line contains an integer, , the number of elements in .
The second line contains  space-separated integers, .
Constraints

Output Format

For each of the  datasets, return the number of inversions that must be swapped to sort the dataset.

Sample Input

2  
5  
1 1 1 2 2  
5  
2 1 3 1 2
Sample Output

0  
4   
Explanation

We sort the following  datasets:

 is already sorted, so there are no inversions for us to correct. Thus, we print  on a new line.
We performed a total of  swaps to correct inversions.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(mergeSort(arr));
        }
    }
    
    static long mergeSort(int[] a){
        int temp[] = new int[a.length];
        return mergeSort(a, temp, 0, a.length - 1);
    }
    
    static long mergeSort(int[] a, int[] temp, int left, int right){
        long count = 0;
        if(right <= left) return 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(a, temp, left, mid);
        count += mergeSort(a, temp, mid + 1, right);
        count += merge(a, temp, left, mid, right);
        return count;
    }
    
    static long merge(int[] a, int[] temp, int left, int mid, int right){
        long count = 0;
        for(int k = left; k <= right; k++){
            temp[k] = a[k];
        }
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i > mid) a[k] = temp[j++];
            else if(j > right) a[k] = temp[i++];
            else if(temp[j] < temp[i]){
                a[k] = temp[j++];
                count += (mid - i + 1);
            }
            else a[k] = temp[i++];
        }
        return count;
    }
}