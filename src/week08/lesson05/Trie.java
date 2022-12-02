package week08.lesson05;

public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        find(word,true,false);
    }

    public boolean search(String word) {
        return find(word,false,false);
    }

    public boolean startsWith(String prefix) {
        return find(prefix,false,true);
    }

    private boolean find(String s, boolean isInsert, boolean isPrefix){
        Node curr = root;
        for(char ch : s.toCharArray()){
            if(curr.nodes[ch - 'a'] == null){
                if(isInsert) {
                    curr.nodes[ch - 'a'] = new Node();
                }else{
                    return false;
                }
            }
            curr = curr.nodes[ch - 'a'];
        }
        if(isInsert) curr.count++;
        if(isPrefix) return true;
        return curr.count > 0;
    }
}

class Node{
    int count = 0;
    Node[] nodes = new Node[26];
}
