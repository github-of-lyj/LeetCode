package October_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution_2022_10_20 {
    public int kthGrammar(int n, int k) {
        ArrayList<Integer> position = new ArrayList<>();
        int temp1 = k;
        int count = 1;
        int temp2 = 1;
        int root = 0;
        int result = 0;
        while(count!=n){
            if (temp1%2 != 0)
                position.add(0);
            else
                position.add(1);
            temp1 = (temp1+1)/2;
            count++;
        }
        int left;
        int right;
        while(temp2!=n){
            for (int i = position.size()-1;i >=0;i--){
                if (root == 0){
                    left = 0;
                    right = 1;
                }else {
                    left = 1;
                    right = 0;
                }
                if (position.get(i) == 1){
                    result = right;
                    root = right;
                }else {
                    result = left;
                    root = left;
                }
                temp2++;
            }
        }
        return result;
    }

    @Test
    void Test(){
        System.out.println(kthGrammar(2,2));

    }

}
