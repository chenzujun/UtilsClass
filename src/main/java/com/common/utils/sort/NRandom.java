package com.common.utils.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @类描述：数组乱序类
 * @创建人：chenjun
 * @修改时间：2015年12月16日 上午9:55:39
 * @修改备注：
 */
public class NRandom {
	 /**
     * 对给定数目的自0开始步长为1的数字序列进行乱序
     * @param no 给定数目
     * @return 乱序后的数组
     */
    public static int[] getSequence(int no) {
        int[] sequence = new int[no];
        for(int i = 0; i < no; i++){
            sequence[i] = i;
        }
        Random random = new Random();
        for(int i = 0; i < no; i++){
            int p = random.nextInt(no);
            int tmp = sequence[i];
            sequence[i] = sequence[p];
            sequence[p] = tmp;
        }
        random = null;
        return sequence;
    }
    
    
    public static List<String> getSequenceList(List<String> list){
    	int size = list.size();
    	int[] a=  getSequence(size);
    	
    	List<String> returnList = new ArrayList<String>();
    	for (int i = 0; i < size; i++) {
    		returnList.add(list.get(a[i]));
		}
    	return returnList;
    }
    
    public static void main(String[] args) {
    	List<String> list = new ArrayList<String>();
    	list.add("21");
    	list.add("str");
    	list.add("而我");
    	
    	list = getSequenceList(list);
    	
    	for (String string : list) {
			System.out.println(string);
		}
    	System.out.println(list.size());
	}
}
