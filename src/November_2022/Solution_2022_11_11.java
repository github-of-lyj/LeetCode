package November_2022;
//1704. 判断字符串的两半是否相似
//        给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
//
//        两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
//
//        如果 a 和 b 相似，返回 true ；否则，返回 false 。
//https://leetcode.cn/problems/determine-if-string-halves-are-alike/

public class Solution_2022_11_11 {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0,s.length()/2);
        String b = s.substring(s.length()/2,s.length());
        char[] c = {'a','e','i','o','u','A','E','I','O','U',};
        int countA = 0;
        int countB = 0;
        for(int i = 0;i < a.length();i++){
            for(int j =0;j < c.length;j++){
                if(a.charAt(i) == c[j]){
                    countA++;
                    break;
                }
            }
        }
        for(int i = 0;i < a.length();i++){
            for(int j =0;j < c.length;j++){
                if(b.charAt(i) == c[j]){
                    countB++;
                    break;
                }
            }
        }
        return countA == countB;

    }
}
