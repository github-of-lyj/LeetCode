package Random_Exercise;

public class Symmetric_Tree {
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
    Boolean isSym(TreeNode left, TreeNode right){
        if (left != null && right != null){
            if (left.val != right.val)
                return false;
            Boolean flag1 = isSym(left.left, right.right);
            Boolean flag2 = isSym(left.right, right.left);
            return flag1 && flag2;
        }
        return left == null && right == null;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left,root.right);
    }
}
