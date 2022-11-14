package week05.lesson06;

import java.util.*;

public class LetterCombinations {

    String digits;
    HashMap<Character,String> map;
    ArrayList<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        this.digits = digits;
        this.map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(0,"");
        return ans;
    }
    public void dfs(int index, String str){
        if(index == digits.length()){
            ans.add(str);
            return;
        }
        for(char c : map.get(digits.toCharArray()[index]).toCharArray()){
            dfs(index+1,str+c);
        }
    }
}
