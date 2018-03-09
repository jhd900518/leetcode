package com.base.chapter04;

/**
 * Created by jhd on 18/3/9.
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumSum {

    public static void main(String[] args) {
        System.out.println(count(5));
    }

    public static int count(int n) {
        if (n == 0)
            return 0;
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

}
