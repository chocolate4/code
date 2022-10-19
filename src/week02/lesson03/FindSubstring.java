package week02.lesson03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FindSubstring {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        final String[] strings = new String[128];
        for(int i = 0; i < 128; i++){
            s.append("a");
            strings[i] = "a";
        }
        new FindSubstring().findSubstring(s.toString(),strings);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String word : words){
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int totalLength = words.length*wordLength;
        for(int i = 0; i <= s.length()-totalLength; i+=wordLength){
            if(valid(s.substring(i,i+totalLength),wordMap,wordLength)) result.add(i);
        }
//        wordMap.size();
        return result;
    }

    public boolean valid(String text,HashMap<String,Integer> wordMap, Integer wordLength){
        HashMap<String, Integer> textMap = new HashMap<>();
        for(int i = 0; i <= text.length()-wordLength; i+=wordLength){
            String word = text.substring(i, i + wordLength);
            textMap.put(word,textMap.getOrDefault(word,0)+1);
        }
        System.out.println(wordMap.get("a"));
        System.out.println(textMap.get("a"));
//        System.out.println(equalMap(wordMap,textMap));
        if(!equalMap(wordMap,textMap)) return false;
        return true;
    }

    public boolean equalMap(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        for(String key : map1.keySet()){
            System.out.println(map2.containsKey(key));
            System.out.println(map2.get(key));
            System.out.println(map1.get(key));
            System.out.println(map2.get(key) == (map1.get(key)));
            System.out.println(map2.get(key).equals(map1.get(key)));
            if(!(map2.containsKey(key) && map2.get(key).equals(map1.get(key)))) return false;
        }
        for(String key : map2.keySet()){
            if(!(map1.containsKey(key) && map1.get(key) == map2.get(key))) return false;
        }
        return true;
    }
}
