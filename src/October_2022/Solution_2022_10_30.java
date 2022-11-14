package October_2022;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Solution_2022_10_30 {
    public List<String> letterCasePermutation(String s) {
        String[] strs = new String[s.length()];
        LinkedList<String> que = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0;i <s.length();i++){
            String temp = "";
            temp+=s.charAt(i);
            strs[i] = temp;
        }
        que.add(strs[0].toUpperCase());
        que.add(strs[0].toLowerCase());
        for (int i = 1; i< strs.length;i++){
            int count = que.size();
            for (int j = 0;j < count;j++){
                String pop1 = que.pop();
                String pop2 = pop1;

                pop1+=strs[i].toLowerCase();
                pop2+=strs[i].toUpperCase();
                que.add(pop1);
                que.add(pop2);
            }
        }
        while (!que.isEmpty())
            set.add(que.pop());
        List<String> strings = new ArrayList<>(set);
        return strings;
    }

    @org.junit.jupiter.api.Test
    void Test(){
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
}
