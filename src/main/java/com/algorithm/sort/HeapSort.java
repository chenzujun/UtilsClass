package com.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 3个间比较，减少比较量
 * 时间复杂度：O(nlogn)
 *
 * @ClassName: HeapSort
 * @Description: 堆排序
 * @author chenjun
 * @date 2017年3月29日 下午7:44:32
 * 
 */
public class HeapSort {
	int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	public void sort() {
		sort(a);

		System.out.println("siz="+a.length+" | "+Arrays.toString(a));
	}

	public void sort(int[] a) {
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1 - i);
			// 堆顶和堆最后一个元素交换
			swap(a, 0, arrayLength - 1 - i);
		}
	}

	private void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	/**
	 * 对data数组从0到lastIndex建大顶堆
	 *
	 * @param data
	 * @param lastIndex
	 */
	private void buildMaxHeap(int[] data, int lastIndex) {
		// 堆最后一个节点的父节点
		int parentIndex = (lastIndex - 1) / 2;
		for (int i = parentIndex; i >= 0; i--) {
			// 如果当前k节点的子节点存在
			if (i * 2 + 1 <= lastIndex) {
				// biggerIndex经过计算总是记录较大子节点的索引
				int biggerIndex = 2 * i + 1;
				if (biggerIndex < lastIndex) {
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						biggerIndex++;
					}
				}

				// 判断是否要交换父节点和较大子节点的值
				if (data[i] < data[biggerIndex]) {
					swap(data, i, biggerIndex);
				}
			}
		}
	}
}
