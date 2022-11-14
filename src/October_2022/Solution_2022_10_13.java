package October_2022;

import org.junit.jupiter.api.Test;
//2022。10.13        最多能完成排序的块
//给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
//        我们将 arr 分割成若干块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
//        返回数组能分成的最多块数量。
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
public class Solution_2022_10_13 {
    public int maxChunksToSorted(int[] arr) {
        int block = 1;          //初始块的数量
        int index = 0;          //始终记录当前块的下表索引
        int max,min,temp;       //max：前一个块中的最大值   min:后一个块中的最小值
        int blockLength = 1;    //记录相关块的长度
        int n = arr.length;     //记录数组的长度
        while(index+blockLength != n){
            //求第一块的最大值
            //初始默认块长为1
            blockLength = 1;
            temp = arr[index];   //初始默认首项为最大值
            for(int i = index ; i<n ; i++){
                if(arr[i] < temp){
                    blockLength = i+1-index;
                    //此时要重新确定最值
                    for(int j = index;j < blockLength;j++){
                        if(arr[j] > temp)
                            temp = arr[j];
                    }
                }
                if(blockLength == n)
                    return 1;
            }
            //最大值
            max = temp;
            //求第二块的最小值
            index+=blockLength;
            if(index == n)
                break;
            //初始默认块长为1
            blockLength = 1;
            temp = arr[index];
            for(int j = index; j<n ; j++){
                if(arr[j] < temp){
                    blockLength = j+1-index;
                    for(int k = index;k < blockLength;k++){
                        if(arr[k] > temp)
                            temp = arr[k];
                    }
                }
            }
            //遍历得到最小值
            min = arr[index];
            for(int k = index; k < index+blockLength ; k++){
                if(arr[k] < min)
                    min = arr[k];
            }


            if(max > min)
                return 1;
            else
                block = block + 1;
        }
        return block;
    }

    @Test
    public void Test(){
        int[] arr = {1,4,0,2,3,5};
        System.out.println(maxChunksToSorted(arr));
    }
}
//主要思路：前一个块中的最大数要比后一个块中的最小数还要小 若发现不符合的情况，直接返回1
//如果发现比前一个块中的最大数还要小的数，就将到这个数为止的所有数字分为一块，此时要重新确定该块中最大的数才能再次开始
