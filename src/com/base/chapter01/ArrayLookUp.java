package com.base.chapter01;

/**
 * Created by jhd on 18/3/6.
 */
public class ArrayLookUp {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.print(find(array, 22));
    }

    public static boolean find(int[][] array, int target) {
        int n = 0;
        int m = array[0].length - 1;
        while (n < array.length && m > 0) {
            if (array[n][m] == target) {
                return true;
            } else if (array[n][m] < target) {
                n++;
            } else {
                m--;
            }
        }
        return false;
    }
}
