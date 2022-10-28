package week03.lesson01;

import java.util.ArrayList;
import java.util.List;

/**
 * n树前序遍历
 */
public class Preprder {

    List<Integer> result;

    public List<Integer> preorder(Node root) {
        result = new ArrayList<Integer>();
        dfs(root);
        return result;
    }

    void dfs(Node root){
        if(root == null) return;
        result.add(root.val);
        for(Node node: root.children){
            dfs(node);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
