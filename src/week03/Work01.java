package week03;

import apple.laf.JRSUIUtils;

/**
 * 由中序后序生成二叉树
 */
public class Work01 {

    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0,inorder.length-1,0,postorder.length-1);
    }

    TreeNode build(int l1, int r1, int l2, int r2){
        if(l1 > r1) return null;
        TreeNode root = new TreeNode(postorder[r2]);
        int mid = l1;
        while (inorder[mid] != root.val){
            mid++;
        }
        root.right = build(mid+1,r1,r2-(r1-mid),r2-1);
        root.left = build(l1,mid-1,l2,r2-(r1-mid)-1);
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
