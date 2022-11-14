package October_2022;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
//给你一个数组 target 和一个整数 n。每次迭代，需要从  list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
//
//        请使用下述操作来构建目标数组 target ：
//
//        "Push"：从 list 中读取一个新元素， 并将其推入数组中。
//        "Pop"：删除数组中的最后一个元素。
//        如果目标数组构建完成，就停止读取更多元素。
//        题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
//
//        请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/build-an-array-with-stack-operations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Solution_2022_10_15 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        int index = 1;

        for (int i = 0;i < target.length;i++){
            //排除错误项
            while (target[i] != index){
                arrayList.add("Push");
                arrayList.add("Pop");
                index++;
            }
            //得到正确项
            arrayList.add("Push");
            index++;
            if (target[target.length-1] == i+1)
                break;
        }
        return arrayList;
    }

    @Test
    void Test(){
        int[] target={1,2};
        System.out.println(buildArray(target,4));
    }
}
