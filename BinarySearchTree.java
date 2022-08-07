package com.binary.search.tree;

public class BinarySearchTree<T extends Comparable<T>> {
	static MyBinaryNode root;

	// adding data recursively.
	public void add(T data) {
		this.root = insertElementRecursive(root, data);
	}

	// Assigning data in Binary search tree format.
	public MyBinaryNode<T> insertElementRecursive(MyBinaryNode<T> root, T data) {
		if (root == null) {
			root = new MyBinaryNode(data);
			return root;
		}
 
		if (data.compareTo(root.data) < 0) {                  // if data is less than the root , then data will assign to the left side of the root.
			root.left = insertElementRecursive(root.left, data);
		} else if (data.compareTo(root.data) > 0) {           // if data is greater than the root , then data will assign to the right side of the root.
			root.right = insertElementRecursive(root.right, data);
		}
		return root;
	}

	// PreOrder traversal :- root , left , right
	public void preOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "  ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	// In-Order traversal :- left , root , right
	public void inOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data + "  ");
		inOrderTraversal(node.right);
	}

	// Post-Order traversal :- left , right , root
	public void postOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + "  ");
	}

	// Main Method
	public static void main(String[] args) {
		System.out.println("\t WELCOME TO BINARY-SEARCH-TREE \n");

		// creating object of Binary_Search_Tree class.
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		bst.add(56);
		bst.add(30);
		bst.add(70);

		System.out.print("Pre-Order Traversal:- ");
		bst.preOrderTraversal(root);

		System.out.print("\n\nIn-Order Traversal:- ");
		bst.inOrderTraversal(root);

		System.out.print("\n\nPost-Order Traversal:- ");
		bst.postOrderTraversal(root);

	}
}
