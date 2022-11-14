package Random_Exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        Stack<Integer> ints = new Stack<>();
        int[] arr = new int[intervals.length];
        ints.add(0);
        for (int i = 1;i < intervals.length;i++){
            if (ints.isEmpty()){
                ints.add(i);
                continue;
            }
            if (intervals[i][0] < intervals[ints.peek()][1] || ints.isEmpty()){
                ints.add(i);
                continue;
            }
            while (!ints.isEmpty() && intervals[i][0] >= intervals[ints.peek()][1])
                arr[ints.pop()] = i;
            ints.add(i);
        }
        while (!ints.isEmpty()){
            Integer pop = ints.pop();

            if (!ints.empty() && intervals[ints.peek()][0] >= intervals[pop][1]){
                arr[pop] = ints.peek();
            }else {
                arr[pop] = -1;
            }

        }
        return arr;
    }


    @Test
    void Test(){
        int[][] intervals = {{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));

    }
}
