package week02;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Work01 {
    public static void main(String[] args) {
        String[] strings = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        new Work01().subdomainVisits(strings);
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> result = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for(String cp : cpdomains){
            String[] s = cp.split(" ");
            int count = Integer.valueOf(s[0]);
            String[] words = s[1].split("\\.");
            for(int i = words.length - 1; i >= 0; i --){
                StringBuilder word = new StringBuilder("");
                for(int j = words.length - 1 - i; j <= words.length - 1; j++){
                    if(j == words.length - 1){
                        word.append(words[j]);
                    }else{
                        word.append(words[j]+".");
                    }
                }
                result.put(word.toString(),result.getOrDefault(word.toString(),0)+count);
            }
        }
        for(String key : result.keySet()){
            list.add(result.get(key).toString() + " " + key);
        }
        return list;
    }
}
