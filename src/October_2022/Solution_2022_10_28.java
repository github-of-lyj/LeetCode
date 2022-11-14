package October_2022;

import org.junit.jupiter.api.Test;
//907. 子数组的最小值之和
//        给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//        由于答案可能很大，因此 返回答案模 10^9 + 7 。
//        https://leetcode.cn/problems/sum-of-subarray-minimums/
public class Solution_2022_10_28 {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        double mod = Math.pow(10,9)+7;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0 ; i < arr.length;i++){
            left[i] = i;
            right[i] = i;
        }
        for (int i = 0 ; i < arr.length;i++){
            int current = arr[i];
            for (int j = i-1;j >=0;j--){
                if (arr[j] >= current){
                    left[i] = j;
                }else {
                    break;
                }
            }
            for (int k = i+1;k < arr.length;k++){
                if (arr[k] > current){
                    right[i] = k;
                }else {
                    break;
                }
            }
        }
        for (int i = 0;i < arr.length;i++){
            sum+= (long) (i - left[i] + 1) *(right[i]-i+1)*arr[i];
        }
        sum%=mod;
        return (int)sum;
    }

    @Test
    void Test(){
        int[] arr = {71,55,82,55};
        System.out.println(sumSubarrayMins(arr));

    }
}
