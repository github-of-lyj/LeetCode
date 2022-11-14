package November_2022;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution_2022_11_13 {
    public String customSortString(String order, String s) {
        Map<Character,Integer> maps = new HashMap<>();
        StringBuilder result = new StringBuilder();
        char[] chars = new char[s.length()];
        char c;
        Integer current = -1;
        for (int i = 0; i < s.length(); i++)
            chars[i] = s.charAt(i);
        for (int i = 0; i < order.length(); i++)
            maps.put(order.charAt(i),i);
        for (int i = 0; i < s.length();i++){
            c = chars[i];
            current = maps.get(c);
            int min = i;
            for (int j = i+1;j < s.length();j++){
                Integer temp = maps.get(chars[j]);
                if (current==null){
                    break;
                }
                if (temp == null)
                    continue;
                if (current > temp){
                    current = temp;
                    min = j;
                }
            }
            if (maps.get(c) != null){
                char tempchar = chars[i];
                chars[i] = chars[min];
                chars[min] = tempchar;
                result.append(chars[i]);
            }else{
                result.append(chars[i]);
            }
        }
        return result.toString();
    }

//    "kqep"
//    "pekeq"


    @Test
    void Test(){
        System.out.println(customSortString("kqep", "pekeq"));
    }



}
