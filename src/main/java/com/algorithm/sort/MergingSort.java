package com.algorithm.sort;

import java.util.Arrays;

/**
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列。
 * 时间复杂度：O(nlogn)
 *
 * @ClassName: MergingSort
 * @Description: 归并排序
 * @author chenjun
 * @date 2017年3月29日 下午7:54:11
 * 
 */
public class MergingSort {
	int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	public void sort() {
		sort(a, 0, a.length - 1);

		System.out.print(Arrays.toString(a));
	}

	public void sort(int[] data, int left, int right) {
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			sort(data, left, center);
			// 对右边数组进行递归
			sort(data, center + 1, right);
			// 合并
			merge(data, left, center, right);
		}

	}

	/**
	 * 两个排序完成的区间合并到原数据
	 *
	 * @param data
	 * @param left
	 * @param center
	 * @param right
	 */
	public void merge(int[] data, int left, int center, int right) {
		// 临时存储两个有序表合并后的有序表
		int[] tmpArr = new int[right-left+1];
		// 临时序列指针
		int t = 0;
		// 左序列指针
		int i = left;
		// 右序列指针
		int j = center + 1;
		while (i <= center && j <= right) {
			// 从两个数组中取出最小的放入中间数组
			if (data[i] <= data[j]) {
				tmpArr[t++] = data[i++];
			} else {
				tmpArr[t++] = data[j++];
			}
		}

		// 剩余部分依次放入中间数组
		while (i <= center) {
			tmpArr[t++] = data[i++];
		}
		while (j <= right) {
			tmpArr[t++] = data[j++];
		}

		// 用临时有序序列替换原数据
		int t1 = left;
		int t2 = 0;
		while (t1 <= right) {
			data[t1++] = tmpArr[t2++];
		}
	}
}
