package week08.lesson05;

import java.util.HashMap;

public class Trie1 {

    Node1 root;

    public Trie1() {
        root = new Node1();
    }

    public void insert(String word) {
        find(word, true, false);
    }

    public boolean search(String word) {
        return find(word, false, false);
    }

    public boolean startsWith(String prefix) {
        return find(prefix, false, true);
    }

    private boolean find(String s, boolean isInsert, boolean isPrefix) {
        Node1 curr = root;
        for (char ch : s.toCharArray()) {
            if (!curr.map.containsKey(ch)) {
                if (isInsert) {
                    curr.map.put(ch, new Node1());
                } else {
                    return false;
                }
            }
            curr = curr.map.get(ch);
        }
        if (isInsert) curr.count++;
        if (isPrefix) return true;
        return curr.count > 0;
    }
}

class Node1{
    int count = 0;
    HashMap<Character,Node1> map = new HashMap<>();
}
