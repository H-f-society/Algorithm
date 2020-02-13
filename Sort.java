/*
* @Author: root
* @Date:   2020-02-11 01:41:33
* @Last Modified by:   root
* @Last Modified time: 2020-02-11 02:33:16
*/
import java.util.*;

public class Sort {
	public static void main(String[] args) {
		RadixSort(); // 基数排序
		System.out.println("\n#########################################");
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
				System.out.println(list.get(j));
				while(!list.get(j).isEmpty())
					nums[n++] = list.get(j).poll();
			}
			System.out.println("------------");
		}
		printArr(nums);
	}
	public static void printArr(int[] nums) {
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}