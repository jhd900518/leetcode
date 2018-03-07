package com.base.chapter02;

/**
 * Created by jhd on 18/3/7.
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 斐波那契数列 F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2) n>=2
 */
public class RectangularCover {

    public static void main(String[] args) {
        System.out.println(solution(30));
        System.out.println(solution2(30));
    }

    public static int solution(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return solution(target - 1) + solution(target - 2);
    }

    public static int solution2(int target) {
        if (target == 0 || target == 1) return 1;
        int arr[] = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        int temp = 0;
        for (int i = 2; i < target; i++) {
            temp = arr[1];
            arr[1] = arr[0] + arr[1];
            arr[0] = temp;
        }
        return arr[1];
    }
}
