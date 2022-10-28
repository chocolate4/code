package week03.lesson01;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class InorderTraversal {
    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
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
