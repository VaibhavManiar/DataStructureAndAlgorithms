package me.practice.ds.tree;

public class MirrorTree {
	private Node root;

	public static final Node mirror(Node root) {
		if (root == null)
			return root;

		Node left = mirror(root.left);
		Node right = mirror(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	private static class Node {
		int data;
		Node right, left;

		Node(int data) {
			this.data = data;
		}
	}

	public static final boolean areMirror(Node r1, Node r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;

		return r1.data == r2.data && areMirror(r1.left, r2.right) && areMirror(r1.right, r2.left);
	}

	private static final void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		inOrder(tree.root);
		System.out.println();
		mirror(tree.root);
		System.out.println();
		inOrder(tree.root);
		System.out.println();

		tree = new MirrorTree();
		Node a = new Node(1);
		Node b = new Node(1);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);

		b.left = new Node(3);
		b.right = new Node(2);
		b.right.left = new Node(5);
		b.right.right = new Node(4);

		if (areMirror(a, b) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
