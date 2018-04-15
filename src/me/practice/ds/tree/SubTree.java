package me.practice.ds.tree;

public class SubTree {
	Node root;
	private static class Node {
		int data;
		Node right, left;

		Node(int data) {
			this.data = data;
		}
	}
	
	public static boolean isSubTree(Node r1, Node r2) {
		
		if(r1 == null)
			return false;
		
		if(r2 == null)
			return true;
		
		if(areIdempotent(r1, r2)) {
			return true;
		}
		
		return isSubTree(r1.left, r2) || isSubTree(r1.right, r2);
	}
	
	private static boolean areIdempotent(Node r1, Node r2) {
		if(r1 == null && r2 == null)
			return true;
		
		if(r2 == null || r1 == null)
			return false;
		
		return r1.data == r2.data && areIdempotent(r1.left, r2.left) && areIdempotent(r1.right, r2.right);
	}
	
	public static void main(String[] args) {
		SubTree tree1 = new SubTree();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(4);
		tree1.root.left.right = new Node(5);
		
		SubTree tree2 = new SubTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(3);
		tree2.root.left.left = new Node(4);
		tree2.root.left.right = new Node(5);
		
		
		System.out.println(isSubTree(tree1.root, tree2.root));
		
	}
}
