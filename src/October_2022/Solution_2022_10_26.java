package October_2022;

import java.util.ArrayDeque;
//        862. 和至少为 K 的最短子数组
//        给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
//        子数组 是数组中 连续 的一部分。
//        https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
public class Solution_2022_10_26 {
    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        //求前缀和
        long[] preadd = new long[nums.length+1];
        preadd[0] = 0;
        for (int i = 0;i < nums.length;i++)
            preadd[i+1] = preadd[i] + nums[i];
        //双端队列
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i <= nums.length;i++){
            long current = preadd[i];
            while( !que.isEmpty() && current-preadd[que.peekFirst()] >= k)
                len = Math.min(len,i-que.pollFirst());
            while( !que.isEmpty() && preadd[que.peekLast()]>=current)
                que.pollLast();
            que.addLast(i);
        }
        return len == Integer.MAX_VALUE ? -1:len;
    }
}
