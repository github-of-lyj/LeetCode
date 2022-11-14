package Random_Exercise;

public class Cousins_in_Binary_Tree {
    public static class TreeNode {
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

    public static class result {
        int deepth;
        TreeNode father;
        public result() {
        }
        public result(int deepth, TreeNode father) {
            this.deepth = deepth;
            this.father = father;
        }
    }

    public static result FindNode(TreeNode root, TreeNode father, int x, int deepth) {
        if (root == null) {
            return null;
        }
        if (root.val == x){
            return new result(deepth,father);
        }
        father = root;
        result left = FindNode(root.left, root, x, deepth + 1);
        result right = FindNode(root.right, root, x, deepth + 1);
        return left == null?right:left;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean flag = false;
        result rx = FindNode(root, root, x, 0);
        result ry = FindNode(root, root, y, 0);
        System.out.println(rx.father.val);
        System.out.println(ry.father.val);
        if (rx.deepth == ry.deepth && rx.father != ry.father)
            flag = true;
        return flag;
    }
}
