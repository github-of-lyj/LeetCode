package October_2022;

public class Solution_2022_10_27 {
//    1822. 数组元素积的符号
//    已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
//    如果 x 是正数，返回 1 。
//    如果 x 是负数，返回 -1 。
//    如果 x 是等于 0 ，返回 0 。
//    给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
//    返回 signFunc(product) 。
//    https://leetcode.cn/problems/sign-of-the-product-of-an-array/
    public int arraySign(int[] nums) {
        int product = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                return 0;
            if(nums[i]<0)
                product*=-1;
        }
        return product==1 ? 1:-1;
    }
}
