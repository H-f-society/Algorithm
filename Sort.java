/*
* @Author: root
* @Date:   2020-02-11 01:41:33
* @Last Modified by:   H-f-society
* @Last Modified time: 2020-02-15 01:16:47
*/
import java.util.*;

public class Sort {
	public static void main(String[] args) {
		RadixSort(); // 基数排序
		countSort(); // 计数排序
		bubbleSort(); // 冒泡排序

		int[] nums = {5, 8, 3, 9, 1, 7, 0, 2, 4, 6};
		int[] result = new int[nums.length];
		mergeSort(nums, result, 0, nums.length-1);
		printArr(nums, "归并排序");
	}
	public static void RadixSort() {
		int[] nums = {3, 44, 38, 5, 47, 35, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		List<LinkedList<Integer>> list = new ArrayList<>();
		for(int i=0; i<10; i++)
			list.add(new LinkedList<>());
		for(int i=0; i<2; i++) {
			for(int j=0; j<nums.length; j++) {
				if(i==0) list.get(nums[j]%10).offer(nums[j]);
				if(i==1) list.get(nums[j]/10).offer(nums[j]);
			}
			int n = 0;
			for(int j=0; j<10; j++) {
				//System.out.println(list.get(j));
				while(!list.get(j).isEmpty())
					nums[n++] = list.get(j).poll();
			}
			//System.out.println("------------");
		}
		printArr(nums, "基数排序");
	}
	public static void countSort() {
		int[] nums = {6, 7, 4, 9, 6, 1, 5, 3, 0, 1, 2, 9, 6, 8};
		int[] temp = new int[10];
		for(int i=0; i<nums.length; i++)
			temp[nums[i]]++;
		int k = 0;
		for(int i=0; i<temp.length; i++) {
			while((temp[i]--) > 0)
				nums[k++] = i;
		}
		printArr(nums, "计数排序");
	}
	public static void bubbleSort() {
		int[] nums = {5, 8, 3, 9, 1, 7, 0, 2, 4, 6};
		for(int i=0; i<nums.length-1; i++) {
			for(int j=0; j<nums.length-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp  = nums[j+1];
					nums[j+1] = nums[j];
					nums[j]   = temp;
				}
			}
		}
		printArr(nums, "冒泡排序");
	}
	public static void mergeSort(int[] nums, int[] result, int start, int end) {
		if(start >= end) return;
		int mid = ((end-start) >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		mergeSort(nums, result, start1, end1);
		mergeSort(nums, result, start2, end2);
		int i = start;
		while(start1 <= end1 && start2 <= end2)
			result[i++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
		while(start1 <= end1)
			result[i++] = nums[start1++];
		while(start2 <= end2)
			result[i++] = nums[start2++];
		for(i=start; i<=end; i++)
			nums[i] = result[i];
	}
	public static void printArr(int[] nums, String sortName) {
		System.out.print(sortName + ": ");
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i] + ", ");
		System.out.println();
	}
}