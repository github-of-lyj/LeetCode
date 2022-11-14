package Random_Exercise;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
//https://leetcode.cn/problems/count-vowel-substrings-of-a-string/
//        2062. 统计字符串中的元音子字符串
//        子字符串 是字符串中的一个连续（非空）的字符序列。
//
//        元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
//
//        给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
public class Count_Vowel_Substrings_of_a_String {
    public int countVowelSubstrings(String word) {
        int count = 0;
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');
        for (int i = 0; i < word.length();i++){
            HashSet<Character> temp = new HashSet<>();
            if (chars.contains(word.charAt(i))){
                temp.add(word.charAt(i));
                for (int j = i+1;j < word.length();j++){
                    if (chars.contains(word.charAt(j)))
                        temp.add(word.charAt(j));
                    else break;
                    if (temp.size() == 5)
                        count++;
                }
            }
        }
        return count;
    }


    @Test
    void Test(){
        String s ="bbaeixoubb";
        System.out.println(countVowelSubstrings(s));
    }
}
