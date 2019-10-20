package com.xhh.construct.recursive;

/**
 * 求和的递归实现
 */
public class ArrayAdd {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 递归函数
    private static int sum(int[] arr, int index) {
        if (index == arr.length)
            return 0;
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(data));
    }

}
