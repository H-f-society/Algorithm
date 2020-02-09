/*
* @Author: root
* @Date:   2020-02-09 19:02:53
* @Last Modified by:   root
* @Last Modified time: 2020-02-09 19:33:38
*/
import java.util.*;

public class BinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		BinaryTree binTree = new BinaryTree();
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = binTree.createTree(nums, 0);
		System.out.println(binTree.levelOrder(root));

		List<List<Integer>> result = new ArrayList<>();
		binTree.getAllPath(root, new ArrayList<>(), result);
		System.out.println(result);
	}
	public TreeNode createTree(int[] nums, int index) {
		TreeNode node = null;
		if(index < nums.length) {
			node = new TreeNode(nums[index]);
			node.left  = createTree(nums, index * 2 + 1);
			node.right = createTree(nums, index * 2 + 2);
		}
		return node;
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()) {
			int size = que.size();
			List<Integer> list = new ArrayList<>();
			while(size > 0) {
				root = que.poll();
				list.add(root.val);
				if(root.left != null)
					que.offer(root.left);
				if(root.right != null)
					que.offer(root.right);
				size--;
			}
			result.add(list);
		}
		return result;
	}
	public void getAllPath(TreeNode root, List<Integer> list, List<List<Integer>> result) {
		if(root == null) return;
		list.add(root.val);
		if(root.left==null && root.right==null)
			result.add(new ArrayList<>(list));
		getAllPath(root.left, list, result);
		getAllPath(root.right, list, result);
		list.remove(list.size() - 1);
	}
}