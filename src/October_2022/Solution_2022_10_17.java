package October_2022;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class Solution_2022_10_17 {
    public int totalFruit(int[] fruits) {
        ArrayList<Integer> fruit1 = new ArrayList<>();
        ArrayList<Integer> fruit2 = new ArrayList<>();
        int maxcount = 0;
        int nowcount = 0;
        for (int i = 0;i < fruits.length;i++){
            if (fruit1.isEmpty()){
                fruit1.add(fruits[i]);
                fruit1.add(i);
                nowcount++;
                continue;
            }
            if (fruit1.get(0)==fruits[i]){
                fruit1.add(fruits[i]);
                nowcount++;
                continue;
            }
            if (fruit2.isEmpty()){
                fruit2.add(fruits[i]);
                fruit2.add(i);
                nowcount++;
                continue;
            }
            if (fruit2.get(0)==fruits[i]){
                fruit2.add(fruits[i]);
                nowcount++;
                continue;
            }
            if (nowcount > maxcount)
                    maxcount = nowcount;
            nowcount = 0;
            i=fruit2.get(1)-1;
            fruit1.clear();
            fruit2.clear();

            }
            if (nowcount > maxcount)
                maxcount = nowcount;
        return maxcount;



    }

    @Test
    void Test(){
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }
}
