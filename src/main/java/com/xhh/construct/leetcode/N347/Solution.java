package com.xhh.construct.leetcode.N347;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:
 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]

 示例 2:
 输入: nums = [1], k = 1
 输出: [1]
 说明：

 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums){
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()){
            if (queue.size() < k)
                queue.add(key);
            else if (map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty())
            res.add(queue.remove());

        return res;
    }
}
