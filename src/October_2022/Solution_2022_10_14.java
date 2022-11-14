package October_2022;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_2022_10_14 {

    public HashSet<String> findsub(String s,ArrayList<String> element,HashSet<String> Subsequence,String s1,int index,int count){
        //count 记录当前循环的子序列长度
        //index 记录索引
        String temp = s1;
        while(count>1){
            count--;
            for (int m=1;m < s.length();m++){
                s1 = temp;
                if (index < m){
                    s1+=element.get(m);
                    index = m;
                    Subsequence=findsub(s,element,Subsequence,s1,index,count);
                    Subsequence.add(s1);
                }
            }
        }
        return  Subsequence;
    }

    public int distinctSubseqII(String s) {
        int result;
        ArrayList<String> element = new ArrayList<String>();
        HashSet<String> Subsequence = new HashSet<>();
        for (int i = 0;i < s.length();i++){
            element.add(String.valueOf(s.charAt(i)));
        }
        int expect;
        for (int i = 1;i <= s.length();i++){
            int count = i;
            int index;
            for(int k = 0;k < s.length();k++){
                Subsequence.add(element.get(k));
            }
            for(int j = 0;j < s.length();j++){
                String s1="";
                index = j;
                if (s1.isBlank())
                    s1+=element.get(j);
                Subsequence=findsub(s,element,Subsequence,s1,index,count);
            }
        }
        int x = (int) Math.pow(10,9)+7;
        result = Subsequence.size()%x;
        return result;
    }


    @Test
    void Test(){
        System.out.println(distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }
}
//class Solution {
//    public int distinctSubseqII(String s) {
//        final int MOD = 1000000007;
//        int[] g = new int[26];
//        int n = s.length();
//        for (int i = 0; i < n; ++i) {
//            int total = 1;
//            for (int j = 0; j < 26; ++j) {
//                total = (total + g[j]) % MOD;
//            }
//            g[s.charAt(i) - 'a'] = total;
//        }
//
//        int ans = 0;
//        for (int i = 0; i < 26; ++i) {
//            ans = (ans + g[i]) % MOD;
//        }
//        return ans;
//    }
//}
//
//作者：LeetCode-Solution
//        链接：https://leetcode.cn/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode-solu-k2h5/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
