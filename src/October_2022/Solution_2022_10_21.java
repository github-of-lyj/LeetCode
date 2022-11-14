package October_2022;

import java.util.Stack;

public class Solution_2022_10_21 {


    Stack<Integer> prices, weights;

    public Solution_2022_10_21() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}
//作者：LeetCode
//        链接：https://leetcode.cn/problems/online-stock-span/solution/gu-piao-jie-ge-kua-du-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

