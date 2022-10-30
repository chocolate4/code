package week03;

/**
 * 二叉搜素树转累加二叉树
 */
public class Work02 {

    int sum;

    public TreeNode convertBST(TreeNode root) {
        this.sum = 0;
        return bfs(root);
    }

    public TreeNode bfs(TreeNode root){
        if(root == null) return null;
        bfs(root.right);
        sum = sum + root.val;
        root.val = sum;
        bfs(root.left);
        return root;
    }
}
