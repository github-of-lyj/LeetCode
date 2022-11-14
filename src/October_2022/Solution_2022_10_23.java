package October_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution_2022_10_23 {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        String string = "";
        Boolean flag = true;
        while (index1 < word1.length() && index2 < word2.length()){
            if (flag){
                string+=word1.charAt(index1);
                index1++;
                flag = false;
            }else{
                string+=word2.charAt(index2);
                index2++;
                flag = true;
            }
        }
        while (index1 < word1.length()){
            string+=word1.charAt(index1);
            index1++;
        }
        while (index2 < word2.length()){
            string+=word2.charAt(index2);
            index2++;
        }
        return string;
    }

    @Test
    void Test(){
        String str1 = "nzlasdasd";
        String str2 = "sbasfaffafa";
        System.out.println(mergeAlternately(str1, str2));

    }
}
