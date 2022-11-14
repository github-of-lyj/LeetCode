package October_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_2022_10_31 {
    public int magicalString(int n) {
        if (n == 1 || n==2)
            return 1;
        boolean flag = false;
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        s.add(1);
        arr.add(1);
        arr.add(2);
        int count = 1;
        int index = 1;
        int arrindex = 1;
        while (true) {
            int peek = arr.get(arrindex++);
            if (!flag) {
                for (int i = 0;i < peek;i++){
                    s.add(2);
                    index++;
                    if (index == n)
                        break;
                }
                flag = true;
            } else {
                for (int i = 0;i < peek;i++){
                    s.add(1);
                    index++;
                    count++;
                    if (index == n)
                        break;
                }
                flag = false;
            }
            if (index == n)
                break;
            arr.add(s.get(arrindex)) ;
        }
        return count;
    }


    @Test
    void Test() {
        System.out.println(magicalString(4));
    }
}
