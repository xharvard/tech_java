package com.xhh.construct.leetcode.N739;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution {

    /**
     * 采用最笨的双重循环
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];

        for(int i = 0; i < length; i ++){
            int cur = T[i];
            for(int j = i + 1; j < length; j ++){
                if(T[j] > cur){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 本题使用逆序遍历，为什么要使用逆序遍历。因为正常遍历思路，遍历到当前天，你无法知道后面几天的温度情况。
     逆序遍历，后面几天的温度情况已经知晓，很容易得到经过几天后的温度比今天温度高。

     思路： 逆序遍历，把每天温度保存下来，存放在一个单调递减的栈中(其实是非递增)，如果不满足这个要求，则需要将栈顶元素依次弹出，
     直至重新满足要求为止。不满足要求的情况即为，当前天的温度比栈顶的温度要高，重新满足要求后，栈顶元素即为后面比当前天温度高的一天，
     如果栈空了，然么说明后面几天没有比当前天温度还要高的。

     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];

        //栈里存数组下标
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历
        for(int i = T.length -1; i >= 0; i--){

            //栈不为空 且 当前元素大于等于栈顶元素
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }

            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    /**
     * 最优解
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures3(int[] T) {
        int[] res = new int[T.length];
        if (T.length <= 1) {
            return res;
        }

        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (T[j] <= T[i] && res[j] != 0) {
                j += res[j];
            }
            if (T[i] < T[j]) {
                res[i] = j - i;
            } else {
                res[i] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new Solution().dailyTemperatures3(temperatures);
        for(int i : res)
            System.out.print(i + ",");
    }
}