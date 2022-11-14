package Random_Exercise;

import java.util.ArrayList;

public class Count_Complete_Tree_Nodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int process(TreeNode root){
        int count = 0;
        if (root == null)
            return 0;
        count++;
        count+=process(root.left);
        count+=process(root.right);
        return count;
    }

    public int countNodes(TreeNode root) {
        int count = 0;
        count = process(root);
        return count;


    }
}
