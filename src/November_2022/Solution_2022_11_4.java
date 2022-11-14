package November_2022;

import org.junit.jupiter.api.Test;

public class Solution_2022_11_4 {
//    754. 到达终点数字
//    在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
//    你可以做一些数量的移动 numMoves :
//
//    每次你可以选择向左或向右移动。
//    第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
//    给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
//    https://leetcode.cn/problems/reach-a-number/
//    该死的数学问题

    public int reachNumber(int target) {
        int result = 0;
        int sum = 0;
        target = Math.abs(target);
        while (sum < target || (sum - target) % 2 != 0)
            sum += ++result;
        return result;
    }



    @Test
    void Test() {
        System.out.println(reachNumber(100));
    }
}
