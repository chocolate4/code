package week02.lesson06;


//todo : 解决树问题的思想：关注每个节点做的事情，剩下的交给递归来处理
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.left;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
