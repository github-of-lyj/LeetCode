package October_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Solution_2022_10_25 {
    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        //求前缀和
        int[] preadd = new int[nums.length+1];
        preadd[0] = 0;
        for (int i = 0;i < nums.length;i++)
            preadd[i+1] = preadd[i] + nums[i];
        //双端队列
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i <= nums.length;i++){
            int current = preadd[i];
            while( !que.isEmpty() && current-preadd[que.peekFirst()] >= k)
                len = Math.min(len,i-que.pollFirst());
            while( !que.isEmpty() && preadd[que.peekLast()]>=current)
                que.pollLast();
            que.addLast(i);
        }
        return len == Integer.MAX_VALUE ? -1:len;
    }


    @Test
    void Test(){
        int[] nums = {2,-1,2};
        int k = 3;
        System.out.println(shortestSubarray(nums, k));

        if (1 ==1 )
            System.out.println(1);
        else if (2 ==2)
            System.out.println(2);
        else
            System.out.println(3);
    }
}
