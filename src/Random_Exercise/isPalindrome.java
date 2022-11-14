package Random_Exercise;

import java.util.ArrayList;

public class isPalindrome {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean Solution(ListNode head) {
        boolean flag = true;
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = arr.size()-1;
        while (left < right){
            if (arr.get(left) != arr.get(right)) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;


    }
}
