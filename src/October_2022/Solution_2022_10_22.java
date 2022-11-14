package October_2022;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2022_10_22 {
    public int findjob(int[] startTime, int[] endTime, int[] profit,int i){
        int wages = 0;
        int temp  = i;
        int tempwages = 0;
        while(startTime[temp] < endTime[i]){
            temp++;
            if (temp == startTime.length)
                return wages;
        }
        for (int j = temp; j < startTime.length;j++){
            tempwages+=profit[j];
            tempwages+=findjob(startTime,endTime,profit,j);
            if (tempwages > wages)
                wages = tempwages;
            tempwages = 0;
        }
        return wages;

    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        for(int i=0;i<startTime.length-1;i++){//每次循环都会找出最小的数
            int minIndex = i;//记录最小数的下标
            int minNum = startTime[i];//记录最小数
            for(int j=i+1;j<startTime.length;j++){//每次循环都会找出最小的数
                if(startTime[j]<minNum){//如果当前数比最小数小，则更新最小数
                    minNum = startTime[j];//更新最小数
                    minIndex = j;//更新最小数的下标
                }
            }
            startTime[minIndex]=startTime[i];
            startTime[i]=minNum;
            int temp = endTime[i];
            endTime[i] = endTime[minIndex];
            endTime[minIndex] = temp;
            temp = profit[i];
            profit[i] = profit[minIndex];
            profit[minIndex] = temp;
        }
        int max = 0;
        for (int i = 0;i < startTime.length;i++){
            int temp = profit[i];
            temp += findjob(startTime,endTime,profit,i);
            if (temp >max)
                max = temp;
        }
        return max;
    }


    @Test
    void Test(){
        int[] starttime = {6,15,7,11,1,3,16,2};
        int[] endtime = {19,18,19,16,10,8,19,8};
        int[] profit = {2,9,1,19,5,7,3,19};
        System.out.println(jobScheduling(starttime, endtime, profit));
    }
}
//[6,15,7,11,1,3,16,2]
//[19,18,19,16,10,8,19,8]
//[2,9,1,19,5,7,3,19]

