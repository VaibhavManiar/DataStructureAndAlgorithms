/**
 * 
 */
package me.practice.ds.tree;

/**
 * Incomplete implementation.
 * @author Vaibhav Maniar
 *
 */

public class BinaryTree {
	public Node buildTree(int[] inOrder, int[] preOrder, int inOrderStartIndex, int inOrderEndIndex) {
		if(inOrderStartIndex > inOrderEndIndex) {
			return null;
		}
		
		Node node = new Node(preOrder[0]);
		if(inOrderStartIndex == inOrderEndIndex)
			return node;
		
		return null;
	}
	
	public int search(int[] arr, int inOrderStartIndex, int inOrderEndIndex, int value) {
		int index = 0;
		for(int i =inOrderStartIndex ; i<= inOrderStartIndex;i++) {
			if(arr[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
