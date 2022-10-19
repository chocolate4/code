package week02.lesson02;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> map = new HashMap<>();
        for(String word: strs){
            ArrayList<Character> characters = new ArrayList<>();
            for(char ch : word.toCharArray()){
                characters.add(ch);
            }
            Collections.sort(characters);
            char[] chars = new char[characters.size()];
            for(int i = 0; i < chars.length; i++){
                chars[i] = characters.get(i);
            }
            String result = String.valueOf(chars);
            map.put(result,map.getOrDefault(result,"")+","+word);
        }
        List<List<String>> lists = new ArrayList<>();
        for(String key : map.keySet()){
            String[] split = map.get(key).substring(1).split(",");
            ArrayList<String> strings = new ArrayList<>();
            if(split.length == 0){
                final String[] split1 = map.get(key).split("");
                for(String s : split1){
                    if(s.equals(",")) strings.add("");
                }
            }else {
                for (String w : split) {
                    strings.add(w);
                }
            }
            lists.add(strings);
        }
        return lists;
    }
}
