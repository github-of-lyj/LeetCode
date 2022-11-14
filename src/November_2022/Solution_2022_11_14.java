package November_2022;

import java.util.HashSet;
import java.util.Set;
//可以转化为简单的动态规划 背包问题
public class Solution_2022_11_14 {
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums.length == 1) {
                return false;
            }
            int n = nums.length, m = n / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            boolean isPossible = false;
            for (int i = 1; i <= m; i++) {
                if (sum * i % n == 0) {
                    isPossible = true;
                    break;
                }
            }
            if (!isPossible) {
                return false;
            }
            Set<Integer>[] dp = new Set[m + 1];
            for (int i = 0; i <= m; i++) {
                dp[i] = new HashSet<Integer>();
            }
            dp[0].add(0);
            for (int num : nums) {
                for (int i = m; i >= 1; i--) {
                    for (int x : dp[i - 1]) {
                        int curr = x + num;
                        if (curr * n == sum * i) {
                            return true;
                        }
                        dp[i].add(curr);
                    }
                }
            }
            return false;
        }
    }

}
