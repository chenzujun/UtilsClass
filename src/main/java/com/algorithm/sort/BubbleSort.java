package com.algorithm.sort;

/**
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：
 * 每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * 时间复杂度：O(n^2)
 *
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @author chenjun
 * @date 2017年3月29日 下午7:47:01
 * 
 */
public class BubbleSort {
	int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	public void sort() {
		int temp;
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					flag = false;
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			// 一趟结束未发生位置交换，说明已是有序
			if(flag){
				break;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
