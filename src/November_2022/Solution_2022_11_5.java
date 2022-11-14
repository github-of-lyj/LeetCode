package November_2022;

import org.junit.jupiter.api.Test;

import java.util.*;
//1106. 解析布尔表达式
//        给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
//
//        有效的表达式需遵循以下约定：
//
//        "t"，运算结果为 True
//        "f"，运算结果为 False
//        "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
//        "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
//        "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
//https://leetcode.cn/problems/parsing-a-boolean-expression/
public class Solution_2022_11_5 {
    public boolean Booltry(String expression){
        boolean flag = true;
        ArrayList<String> split = new ArrayList<>();
        if (expression.equals("t"))
            return true;
        if (expression.equals("f"))
            return false;
        char c = expression.charAt(0);
        String substring = expression.substring(2, expression.length() - 1);
        for (int i = 0; i < substring.length();i++){
            if (substring.charAt(i) == '&' || substring.charAt(i) == '|' || substring.charAt(i) == '!') {
                flag = false;
                break;
            }
        }
        if (flag){
            String[] temp = substring.split(",");
            split.addAll(Arrays.asList(temp));
        }else {
            int index = 0;
            Stack<Boolean> booleans = new Stack<>();
            for (int i = 0; i < substring.length();i++){
                if (substring.charAt(i) == '(')
                    booleans.add(true);
                if (substring.charAt(i) ==  ')')
                    booleans.pop();
                if (substring.charAt(i) == ',' && booleans.isEmpty()){
                    split.add(substring.substring(index,i));
                    index = i+1;
                }else if (i == substring.length()-1){
                    split.add(substring.substring(index));
                }
            }
        }
        if (c == '!'){
            boolean booltry = Booltry(substring);
            return !booltry;
        }else if (c == '&'){
            for (String str : split) {
                boolean booltry = Booltry(str);
                if (!booltry)
                    return false;
            }
        }else if (c == '|'){
            for (String str : split) {
                boolean booltry = Booltry(str);
                if (booltry)
                    return true;
            }
            return false;
        }
        return true;
    }


    public boolean parseBoolExpr(String expression) {
            return Booltry(expression);
    }


    @Test
    void Test(){
        String str = "|(&(t,f,t),t)";
        System.out.println(Booltry(str));
    }
}
