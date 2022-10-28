package week03.lesson01;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class LevelOrder {

    Queue<Pair<Integer,Node>> queue;

    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>(new ArrayList<>());
        queue = new ArrayDeque<>();
        ans = new ArrayList<>();
        queue.add(new Pair<Integer,Node>(0,root));
        while (!queue.isEmpty()){
            Integer level = queue.peek().getKey();
            Node node = queue.poll().getValue();
            System.out.println(level);
            System.out.println(ans);
            if(level >= ans.size()) ans.add(new ArrayList<>());
            ans.get(level).add(node.val);
            for(Node n : node.children){
                queue.add(new Pair<>(level + 1,n));
            }
        }
        return ans;
    }
}
