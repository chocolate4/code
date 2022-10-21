package week02.lesson06;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val > max || root.val < min) return false;
        return check(root.left,min,root.val - 1L) && check(root.right, root.val + 1L,max);
    }
}
