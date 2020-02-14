/*
* @Author: H-f-society
* @Date:   2020-02-14 01:39:05
* @Last Modified by:   H-f-society
* @Last Modified time: 2020-02-14 23:36:31
*/
import java.util.*;

public class Permute {
	public static int[] nums = {1, 2, 3};
	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<>();
		Permute1(nums, 0, nums.length-1, result);
		System.out.println(result);
	}
	public static void Permute1(int[] nums, int start, int end, List<List<Integer>> result) {
		// 递归实现
		List<Integer> list = new ArrayList<>();
		if(start == end) {
			for(int i : nums) list.add(i);
			result.add(list);
			return;
		}
		for(int i=start; i<=end; i++) {
			if(i==start || nums[i]!=nums[start]) { //该条件避免[1, 1]重复
				swap(nums, start, i);
				Permute1(nums, start+1, end, result);
				swap(nums, start, i);
			}
		}
	}
	public static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}