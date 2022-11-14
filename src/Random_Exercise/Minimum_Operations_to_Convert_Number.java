package Random_Exercise;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
//2059. 转化数字的最小运算数
//        给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
//
//        整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
//
//        如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
//
//        x + nums[i]
//        x - nums[i]
//        x ^ nums[i]（按位异或 XOR）
//        注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
//
//        返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。
//https://leetcode.cn/problems/minimum-operations-to-convert-number/
public class Minimum_Operations_to_Convert_Number {
    public int minimumOperations(int[] nums, int start, int goal) {
        int step = 0;
        HashMap<Integer, Integer> Map = new HashMap<>();
        LinkedList<Integer> que = new LinkedList<>();
        Map.put(start,step);
        que.add(start);
        while (!que.isEmpty()){
            Integer pop = que.pop();
            step = Map.get(pop);
            for (Integer i : nums) {
                int[] next = {pop+i,pop-i,pop^i};
                for (Integer j : next) {
                    if (j == goal)
                        return step+1;
                    if (j < 0 || j> 1000)
                        continue;
                    if (Map.containsKey(j))
                        continue;
                    Map.put(j,step+1);
                    que.add(j);
                }
            }
        }
        return -1;
    }


    @Test
    void Test(){
        int[] nums = {2,8,16};
        System.out.println(minimumOperations(nums, 0, 1));

    }
}
