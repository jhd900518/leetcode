package com.base.chapter04;

/**
 * Created by jhd on 18/3/9.
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonaccisequence {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int arr[] = new int[2];
        arr[0] = 0;
        arr[1] = 1;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = arr[1];
            arr[1] = arr[0] + arr[1];
            arr[0] = temp;
        }
        return arr[1];
    }
}
