package November_2022;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.LinkedList;

//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
//        给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/maximum-repeating-substring
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Solution_2022_11_3 {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        int index = 1;
        LinkedList<Integer> str = new LinkedList<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                if (word.length() ==1){
                    str.add(i+1);
                    continue;
                }

                for (int j = i + 1; j < sequence.length(); j++) {
                    if (sequence.charAt(j) != word.charAt(index++))
                        break;
                    if (index == word.length()) {
                        str.add(j + 1);
                        break;
                    }
                }
                index = 1;
            }
        }
        if (!str.isEmpty())
            count++;
        while (!str.isEmpty()) {
            int x = str.size();
            for (int i =0;i < x;i++){
                Integer pop = str.pop();
                if (pop >= sequence.length())
                    break;
                if (sequence.charAt(pop) == word.charAt(0)) {
                    if (word.length() ==1){
                        str.add(pop+1);
                        continue;
                    }
                    for (int j = pop + 1; j < sequence.length(); j++) {
                        if (sequence.charAt(j) != word.charAt(index++))
                            break;
                        if (index == word.length() ) {
                            str.add(j+1);
                            break;
                        }
                    }
                    index = 1;
                }
            }
            if (!str.isEmpty())
                count++;
        }
        return count;

    }

    @Test
    void Test() {
        String sequence = "aaa";
        String word = "a";
        System.out.println(maxRepeating(sequence, word));
    }
}
