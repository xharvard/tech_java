package com.xhh.construct.leetcode.N303;

/**
 * 用临时数组的方式，只能针对不可变数组
 *
 */
public class NumArray {

	private int[] sum; // sum[i]存储前i个元素和， sum[0] = 0

	public NumArray(int[] nums) {
		sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}
}
