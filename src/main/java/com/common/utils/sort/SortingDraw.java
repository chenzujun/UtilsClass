package com.common.utils.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.utils.EnumUtils;

public class SortingDraw
{
	public void quickSortList(List<Integer> list)
    {
        // 数组为空判断
        if (null == list || list.size() == 0)
        {
            return;
        }
        
        quickSort(list, 0, list.size() - 1);
    }
    
    private void quickSort(List<Integer> list, int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        
        int middle = getMiddle(list, low, high); //将list数组进行一分为二
        
        quickSort(list, low, middle - 1); //对低值组进行递归排序
        quickSort(list, middle + 1, high); //对高值组进行递归排序
    }
    
    /**
     * 数组一份为二，返回中间值
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int getMiddle(List<Integer> list, int low, int high)
    {
        int tmp = list.get(low);
        
        while (low < high)
        {
            while (high > low && list.get(high) >= tmp)
            {
                high--;
            }
            list.set(low, list.get(high)); //比中轴小的记录移到低端
            while (high > low && list.get(low) <= tmp)
            {
                low++;
            }
            list.set(high, list.get(low)); //比中轴大的记录移到高端
        }
        list.set(low, tmp); //中轴记录到位
        
        return low; //返回中轴的位置
    }
	
	/**
	 * 
	 * 描述：数组排序
	 * @param array 
	 * @exception
	 */
	public void quicksort(Integer[] array)
    {
        // 数组为空判断
        if (null == array || array.length == 0)
        {
            return;
        }
        
        _quick_sort(array, 0, array.length - 1);
    }
    
    public void _quick_sort(Integer[] array, int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        
        int middle = getMiddle(array, low, high); //将list数组进行一分为二
        
        _quick_sort(array, low, middle - 1); //对低值组进行递归排序
        _quick_sort(array, middle + 1, high); //对高值组进行递归排序
    }
    
    /**
     * 数组一份为二，返回中间值
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int getMiddle(Integer[] array, int low, int high)
    {
        int tmp = array[low]; //数组的第一个作为中轴
        
        while (low < high)
        {
            while (high > low && array[high] >= tmp)
            {
                high--;
            }
            array[low] = array[high]; //比中轴小的记录移到低端
            while (high > low && array[low] <= tmp)
            {
                low++;
            }
            array[high] = array[low]; //比中轴大的记录移到高端
        }
        array[low] = tmp; //中轴记录到位
        
        return low; //返回中轴的位置
    }
    
    public static void main(String[] args)
    {
//        Integer[] array = {323, 213, 44, 2121, 1, 22, 3, 99, 97, 23, 44 };
//        //     Integer[] array = {2,32,3,324,56};
//        
//        new SortingDraw().quicksort(array);
//        
//        int i = 0;
//        for (Integer integer : array)
//        {
//            i++;
//            System.out.println("第" + i + "个数：" + integer);
//        }
        
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map1 = new HashMap<String, Object>();
    	map1.put("name", "三区");
    	map1.put("value", "faa");
    	Map<String, Object> map2 = new HashMap<String, Object>();
    	map2.put("name", "十区");
    	map2.put("value1", "fafafafafd");
    	Map<String, Object> map3 = new HashMap<String, Object>();
    	map3.put("name", "二区");
    	map3.put("valu3", "一区");
    	Map<String, Object> map4 = new HashMap<String, Object>();
    	map4.put("name", "六区");
    	map4.put("valu31", "fafafa");
    	Map<String, Object> map5 = new HashMap<String, Object>();
    	map5.put("name", "一区");
    	map5.put("valu31", "fafafa");
    	list.add(map1);
    	list.add(map2);
    	list.add(map3);
    	list.add(map4);
    	list.add(map5);
    	
    	List<Integer> sortList = new ArrayList<Integer>();
    	for (int i=0;i<list.size();i++) {
			Object name = list.get(i).get("name");
			int val = EnumUtils.Numeric.getValue(name.toString().substring(0, 1));
			sortList.add(val);
		}
    	for (Integer in : sortList) {
			System.out.print(in+"-");
		}
    	System.out.println();
    	new SortingDraw().quickSortList(sortList);
    	for (Integer in : sortList) {
			System.out.print(in+"-");
		}
    	
    	System.out.println(sortList.indexOf(3));
    }
    
}
