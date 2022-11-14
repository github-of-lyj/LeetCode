package October_2022;

import java.util.List;
import java.util.Objects;
//1773. 统计匹配检索规则的物品数量
//https://leetcode.cn/problems/count-items-matching-a-rule/
//给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
//
//        另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
//
//        如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
//
//        ruleKey == "type" 且 ruleValue == typei 。
//        ruleKey == "color" 且 ruleValue == colori 。
//        ruleKey == "name" 且 ruleValue == namei 。
//        统计并返回 匹配检索规则的物品数量 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/count-items-matching-a-rule
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Solution_2022_10_29 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = 0;
        if (Objects.equals(ruleKey, "color"))
            index = 1;
        if (Objects.equals(ruleKey, "name"))
            index = 2;
        for (int i = 0;i < items.size();i++){
            if (items.get(i).get(index).equals(ruleValue))
                count++;
        }
        return count;

    }
}
