package com.common.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bean.Pilot;

public class HeapOutOfMemory {

    private static void oom() {
        Map<String, Pilot> map = new HashMap<String, Pilot>();
        Object[] array = new Object[100000000];
        for (int i = 0; i < 1000000; i++) {
            String d = new Date().toString();
            Pilot p = new Pilot(d, i);
            map.put(i + "rosen jiang", p);
            array[i] = p;
        }
        System.out.println("ok");
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> strs = new ArrayList<String>(100000000);
        for (int i = 0; i <= 100000000; ++i) {
            strs.add(Integer.toString(i));
            if (i % 10000 == 0) {
                System.out.println(i);
            }
        }
        
        // 或者
        oom();
    }
}
