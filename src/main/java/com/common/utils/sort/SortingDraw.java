package com.common.utils.sort;

public class SortingDraw
{
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
        Integer[] array = {323, 213, 44, 2121, 1, 22, 3, 99, 97, 23, 44 };
        //     Integer[] array = {2,32,3,324,56};
        
        new SortingDraw().quicksort(array);
        
        int i = 0;
        for (Integer integer : array)
        {
            i++;
            System.out.println("第" + i + "个数：" + integer);
        }
        
    }
    
}
