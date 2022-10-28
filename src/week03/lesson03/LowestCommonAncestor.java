package week03.lesson03;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * 二叉树最近公共祖先
 * 思路：找到最深的包含p和q的root节点
 * 1.以合适的方式标识p和q的存在，使用pair<Boolean,Boolean>
 * 2.我们是从跟向下递归遍历树，所以出栈的时候，第一个(true,true)就是最深的包含p和q的root节点
 * 3.将结果保存在class中
 */
public class LowestCommonAncestor {

    TreeNode p;
    TreeNode q;
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ans;
    }

    Pair<Boolean,Boolean> dfs(TreeNode node){
        if(node == null) return new Pair<Boolean,Boolean>(false,false);
        //todo 先向下查找，找到叶子结点
        Pair<Boolean,Boolean> left = dfs(node.left);
        Pair<Boolean,Boolean> right = dfs(node.right);
        //todo 判断树下面是否有p和q
        Pair<Boolean,Boolean> result = new Pair<Boolean,Boolean>(left.getKey() || right.getKey() || node.val == p.val,left.getValue() || right.getValue() || node.val == q.val);
        ///todo 返回最深的包含p和q的root节点
        if(result.getKey() && result.getValue() && ans == null) ans = node;
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
