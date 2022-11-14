package November_2022;

import java.util.HashSet;
import java.util.Set;

public class Solution_2022_11_8 {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet<String>c = new HashSet<>();
        for (int i = 0;i < allowed.length();i++)
            c.add(String.valueOf(allowed.charAt(i)));
        for (String s : words) {
            for (int i = 0;i < s.length();i++){
                if (!c.contains(String.valueOf(s.charAt(i))))
                    break;
                if (c.contains(String.valueOf(s.charAt(i))) && i == s.length()-1)
                    count++;
            }

        }

        return count;

    }
}
