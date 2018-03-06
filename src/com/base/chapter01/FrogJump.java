package com.base.chapter01;

/**
 * Created by jhd on 18/3/6.
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 斐波那契数列 F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2) n>=2
 */
public class FrogJump {

    public static void main(String[] args) {
        System.out.print(solution(3));
        System.out.println(solution02(3));
    }

    public static int solution(int target) {
        if (target == 1)
            return 1;
        int a[] = new int[2];
        a[0] = 1;
        a[1] = 2;
        int temp = 0;
        for (int i = 3; i <= target; i++) {
            temp = a[1];
            a[1] = a[0] + a[1];
            a[0] = temp;
        }
        return a[1];
    }

    public static int solution02(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return solution(target - 1) + solution(target - 2);
    }
}
