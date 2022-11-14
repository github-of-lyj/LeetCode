package November_2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//816. 模糊坐标
//        我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
//
//        原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
//
//        最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
//https://leetcode.cn/problems/ambiguous-coordinates/
class Solution_2022_11_7 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> list = new LinkedList<String>();
        String str = s.substring(1, s.length() - 1);
        List<String> str1 = new LinkedList<>();
        List<String> str2 = new LinkedList<>();
        for (int i = 1 ;i < str.length();i++){
            str1.clear();
            str2.clear();
            String substring1 = str.substring(0, i);
            String substring2 = str.substring(i);
            //判断小数点的位置
            if(substring1.charAt(0) == '0' && substring1.length() ==1)
                str1.add(substring1);
            if (substring1.charAt(0)=='0' && substring1.charAt(substring1.length()-1) == '0' && substring1.length() !=1)
                continue;
            if (substring1.charAt(0)=='0' && substring1.charAt(substring1.length()-1) != '0'){
                String temp1 = "";
                temp1+=substring1.charAt(0);
                temp1+=".";
                temp1+=substring1.substring(1);
                str1.add(temp1);
            }
            if (substring1.charAt(0)!='0' && substring1.charAt(substring1.length()-1) == '0'){
                str1.add(substring1);
            }
            if (substring1.charAt(0)!='0' && substring1.charAt(substring1.length()-1) != '0'){
                for(int j = 1;j <= substring1.length();j++){
                    if(substring1.length() == j){
                        str1.add(substring1);
                        break;
                    }
                    String temp1 = "";
                    temp1+=substring1.substring(0,j);
                    temp1+=".";
                    temp1+=substring1.substring(j);
                    str1.add(temp1);
                }

            }

            //判断小数点的位置
            if(substring2.charAt(0) == '0' && substring2.length() ==1)
                str2.add(substring2);
            if (substring2.charAt(0)=='0' && substring2.charAt(substring2.length()-1) == '0' && substring2.length() !=1)
                continue;
            if (substring2.charAt(0)=='0' && substring2.charAt(substring2.length()-1) != '0'){
                String temp2 = "";
                temp2+=substring2.charAt(0);
                temp2+=".";
                temp2+=substring2.substring(1);
                str2.add(temp2);
            }
            if (substring2.charAt(0)!='0' && substring2.charAt(substring2.length()-1) == '0'){
                str2.add(substring2);
            }
            if (substring2.charAt(0)!='0' && substring2.charAt(substring2.length()-1) != '0'){
                for(int j = 1;j <= substring2.length();j++){
                    if(substring2.length() == j){
                        str2.add(substring2);
                        break;
                    }
                    String temp2 = "";
                    temp2+=substring2.substring(0,j);
                    temp2+=".";
                    temp2+=substring2.substring(j);
                    str2.add(temp2);
                }
            }
            for (String value : str1)
                for (String item : str2) {
                    String temp = "";
                    temp += "(";
                    temp += value;
                    temp += ", ";
                    temp += item;
                    temp += ")";
                    list.add(temp);
                }

        }

        return list;

    }
}