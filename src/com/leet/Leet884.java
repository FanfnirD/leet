package com.leet;

import java.util.*;

/**
 * @author Fafnir
 * @date 2023/6/5
 */
public class Leet884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        //String str = s1 + " " + s2;
        //String[] strArr = str.split(" ");
        //List<String> res = new ArrayList<>();
        //HashMap<String, Integer> map = new HashMap<>();
        //
        //for (String s : strArr) {
        //    map.put(s, map.getOrDefault(s, 0) + 1);
        //}
        //map.keySet().forEach(s -> {
        //    if (map.get(s) == 1) {
        //        res.add(s);
        //    }
        //});
        //
        //return res.toArray(new String[res.size()]);
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s : s1.split(" ")) {
            if(set.add(s)) list.add(s);
            else list.remove(s);
        }
        for(String s : s2.split(" ")) {
            if(set.add(s)) list.add(s);
            else list.remove(s);
        }
        return list.toArray(new String[0]);
    }
}
