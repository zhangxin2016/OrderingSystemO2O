package com.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/6/1.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("qwe");
        list1.add("ads");
        list1.add("zxc");
        List<String> list2 = new ArrayList<>();
        list2.add("qwe");
        list2.add("123");
        list2.add("456");
        //Boolean a = (list1.size() == list2.size()) && list1.containsAll(list2);
        //System.out.println(a);
        System.out.println(getSameList(list1, list2));
    }
    private static List<String> getSameList(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size()||list2.size()==list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            if(map.get(string)!=null)
            {
                map.put(string, 2);
                continue;
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==2)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }
}
