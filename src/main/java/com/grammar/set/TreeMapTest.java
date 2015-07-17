package com.grammar.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest
{
    private Map<Double,String> treemap = new TreeMap<Double,String>(new Comparator<Double>(){ 
        public int compare(Double obj1,Double obj2){ 
            //升序排序 
            return obj1.compareTo(obj2); 
        } 
    });
    
    public void getMinStr(){
        treemap.put(1.4, "1");
        treemap.put(12.4, "2");
        treemap.put(123.4, "3");
        treemap.put(1.0, "4");
        Set<Double> keySet = treemap.keySet(); 
        Iterator<Double> iter = keySet.iterator(); 
        while(iter.hasNext()){ 
            System.out.println(iter.next());
        }
    }
    
    
    public static void main(String[] args)
    {
        new TreeMapTest().getMinStr();
    }
}
