package edu.wmich.CS3310.PA2.RajBasnet;

import java.io.IOException;

/**
 * @author Raj
 * This is the main class to create the tree data structure and perform specified functions
 */
public class Main {

	/**
	 * This is the main method which executes all the function needed for tree data structure
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Arrays of List from which both binary tree and binary search tree are to be created
		int array1[] = {4, 1, 9, 12, 3, 2, 8, 7, 16, 20, 13, 11, 1, 8};

		int array2[] = {10, 1, 5, 12, 8, 4, 2, 9, 7, 13, 19, 18, 11};

		int array3[] = {4, 6, 3, 7, 5};  //** Binary Tree and Binary Search Tree made from this array are mirror of each other
		int array4[] = {100, 50, 200, 25, 75, 125};   //** Binary Tree and Binary Search Tree made from this array are identical to each other
		int array5[] = {20, 10, 30, 5, 15, 25, 35, 1, 8, 12, 18, 22, 28, 33, 40}; 


		//Initialize comparator for comparison of data
		DataComparator<Integer> comparator = new DataComparator<Integer>();

		//Create new TreeChecker object treeChecker to compare two trees
		TreeChecker<Integer> treeChecker = new TreeChecker<Integer>();

		//Create five binary seacrh tree and five binary tree from five arrays mentioned
		BinarySearchTree<Integer> Bst1 = new BinarySearchTree<Integer>();
		BinaryTree<Integer> Bin_tree1 = new BinaryTree<Integer>();

		BinarySearchTree<Integer> Bst2 = new BinarySearchTree<Integer>();
		BinaryTree<Integer> Bin_tree2 = new BinaryTree<Integer>();


		BinarySearchTree<Integer> Bst3 = new BinarySearchTree<Integer>();
		BinaryTree<Integer> Bin_tree3 = new BinaryTree<Integer>();

		BinarySearchTree<Integer> Bst4 = new BinarySearchTree<Integer>();
		BinaryTree<Integer> Bin_tree4 = new BinaryTree<Integer>();

		BinarySearchTree<Integer> Bst5 = new BinarySearchTree<Integer>();
		BinaryTree<Integer> Bin_tree5 = new BinaryTree<Integer>();

		//Create and initialize root node to be first element of an array (for first array)
		Node<Integer> rootBst1 = (Node<Integer>) Bst1.insert(null, array1[0]);
		Node<Integer> rootBin_tree1 = (Node<Integer>) Bin_tree1.insert(null, array1[0]);

		//Create both binary tree and binary search tree using root node and remaining elements of first array by inserting each element as node into trees
		for (int i = 1; i < array1.length; i++) {

			Bst1.insert(rootBst1, array1[i]);
			Bin_tree1.insert(rootBin_tree1, array1[i]);
		}

		//Create and initialize root node to be first element of an array (for second array)
		Node<Integer> rootBst2 = (Node<Integer>) Bst2.insert(null, array2[0]);
		Node<Integer> rootBin_tree2 = (Node<Integer>) Bin_tree2.insert(null, array2[0]);

		//Create both binary tree and binary search tree using root node and remaining elements of second array by inserting each element as node into trees
		for (int i = 1; i < array2.length; i++) {

			Bst2.insert(rootBst2, array2[i]);
			Bin_tree2.insert(rootBin_tree2, array2[i]);
		}

		//Create and initialize root node to be first element of an array (for third array)
		Node<Integer> rootBst3 = (Node<Integer>) Bst3.insert(null, array3[0]);
		Node<Integer> rootBin_tree3 = (Node<Integer>) Bin_tree3.insert(null, array3[0]);

		//Create both binary tree and binary search tree using root node and remaining elements of third array by inserting each element as node into trees
		for (int i = 1; i < array3.length; i++) {

			Bst3.insert(rootBst3, array3[i]);
			Bin_tree3.insert(rootBin_tree3, array3[i]);
		}

		//Create and initialize root node to be first element of an array (for fourth array)
		Node<Integer> rootBst4 = (Node<Integer>) Bst4.insert(null, array4[0]);
		Node<Integer> rootBin_tree4 = (Node<Integer>) Bin_tree4.insert(null, array4[0]);

		//Create both binary tree and binary search tree using root node and remaining elements of fourth array by inserting each element as node into trees
		for (int i = 1; i < array4.length; i++) {

			Bst4.insert(rootBst4, array4[i]);
			Bin_tree4.insert(rootBin_tree4, array4[i]);
		}

		//Create and initialize root node to be first element of an array (for fifth array)
		Node<Integer> rootBst5 = (Node<Integer>) Bst5.insert(null, array5[0]);
		Node<Integer> rootBin_tree5 = (Node<Integer>) Bin_tree5.insert(null, array5[0]);

		//Create both binary tree and binary search tree using root node and remaining elements of fifth array by inserting each element as node into trees
		for (int i = 1; i < array5.length; i++) {

			Bst5.insert(rootBst5, array5[i]);
			Bin_tree5.insert(rootBin_tree5, array5[i]);
		}

		//Each tree gets the comparator
		Bst1.getTreeComp();
		Bin_tree1.getTreeComp();
		Bst2.getTreeComp();
		Bin_tree2.getTreeComp();
		Bst3.getTreeComp();
		Bin_tree3.getTreeComp();
		Bst4.getTreeComp();
		Bin_tree4.getTreeComp();
		Bst5.getTreeComp();
		Bin_tree5.getTreeComp();

		//Prints each traversal of binary tree for first array

		System.out.println("Inorder Traversal Binary Tree (first array): ");
		Bin_tree1.inorder();
		System.out.println("Preorder Traversal Binary Tree (first array): ");
		Bin_tree1.preorder();
		System.out.println("Postorder Traversal Binary Tree (first array): ");
		Bin_tree1.postorder();

		//Prints each traversal of binary search tree for first array
		System.out.println("Inorder Traversal Binary Search Tree (first array): ");
		Bst1.inorder();
		System.out.println("Preorder Traversal Binary Search Tree (first array): ");
		Bst1.preorder();
		System.out.println("Postorder Traversal Binary Search Tree (first array): ");
		Bst1.postorder();

		System.out.println();

		//Prints each traversal of binary tree for second array

		System.out.println("Inorder Traversal Binary Tree (second array): ");
		Bin_tree2.inorder();
		System.out.println("Preorder Traversal Binary Tree (second array): ");
		Bin_tree2.preorder();
		System.out.println("Postorder Traversal Binary Tree (second array): ");
		Bin_tree2.postorder();

		//Prints each traversal of binary search tree for second array
		System.out.println("Inorder Traversal Binary Search Tree (second array): ");
		Bst2.inorder();
		System.out.println("Preorder Traversal Binary Search Tree (second array): ");
		Bst2.preorder();
		System.out.println("Postorder Traversal Binary Search Tree (second array): ");
		Bst2.postorder();

		//Traversal for rest of the trees can also be printed easily (Hope two Bst and two Bin_tree are enough here) 

		//compare bst1 and bin_tree as mirror images with tree checker
		comparator.getClass();
		System.out.println();

		//Comparison of binary search tree and binary tree (first array)
		if (treeChecker.isMirror(Bst1, Bin_tree1)) {
			System.out.println("First Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst1, Bin_tree1)) {
			System.out.println("First Array: The trees are indentical to each other.");
		} else {
			System.out.println("First Array: The trees are not related.");
		}

		System.out.println();

		//Comparison of binary search tree and binary tree (second array)
		if (treeChecker.isMirror(Bst2, Bin_tree2)) {
			System.out.println("Second Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst2, Bin_tree2)) {
			System.out.println("Second Array: The trees are indentical to each other.");
		} else {
			System.out.println("Second Array: The trees are not related.");
		}

		System.out.println();

		//Comparison of binary search tree and binary tree (third array)
		if (treeChecker.isMirror(Bst3, Bin_tree3)) {
			System.out.println("Third Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst3, Bin_tree3)) {
			System.out.println("Third Array: The trees are indentical to each other.");
		} else {
			System.out.println("Third Array: The trees are not related.");
		}

		System.out.println();

		//Comparison of binary search tree and binary tree (fourth array)
		if (treeChecker.isMirror(Bst4, Bin_tree4)) {
			System.out.println("Fourth Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst4, Bin_tree4)) {
			System.out.println("Fourth Array: The trees are indentical to each other.");
		} else {
			System.out.println("Fourth Array: The trees are not related.");
		}

		System.out.println();

		Bst2.remove(rootBst2, 5); //Deleting the node containing data 5 from Binary Search Tree (Second Array)
		System.out.println("Second Array: After removing certain node");
		Bst2.inorder(); //Inorder traversal after node deletion

		//Comparison of binary search tree and binary tree after removing node data
		if (treeChecker.isMirror(Bst2, Bin_tree2)) {
			System.out.println("Second Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst2, Bin_tree2)) {
			System.out.println("Second Array: The trees are indentical to each other.");
		} else {
			System.out.println("Second Array: The trees are not related.");
		}

		System.out.println();

		//Fifth Array inorder traversal
		System.out.println("Fifth Array: Inorder traversal for Binary Search Tree");
		Bst5.inorder();

		//Comparison of binary search tree and binary tree (fifth array)
		if (treeChecker.isMirror(Bst5, Bin_tree5)) {
			System.out.println("Fifth Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst5, Bin_tree5)) {
			System.out.println("Fifth Array: The trees are indentical to each other.");
		} else {
			System.out.println("Fifth Array: The trees are not related.");
		}

		//Removal of node containing given data from binary search tree
		Bst5.remove(rootBst5, 20);

		//Inorder traversal after node data removal
		System.out.println("Fifth Array: After removal of certain node");
		Bst5.inorder();

		//Comparison of two trees after node data removal (fifth array)
		if (treeChecker.isMirror(Bst5, Bin_tree5)) {
			System.out.println("Fifth Array: The trees are mirrors of each other."); 
		} else if(treeChecker.isSame(Bst5, Bin_tree5)) {
			System.out.println("Fifth Array: The trees are indentical to each other.");
		} else {
			System.out.println("Fifth Array: The trees are not related.");
		}

		//Here, fifth array makes two trees (BST and Bin_tree) identical to each other but after data removal they are not related.

		System.out.println("Max value Bst1 = " + Bst1.getMax(rootBst1).getData()); //Prints maximum value of BST1
		System.out.println("Min value Bst1 = " + Bst1.getMin(rootBst1).getData());	//Prints minimum value of BST!
		System.out.print("Max value Bin_Tree4 = ");
		Bin_tree4.getMax(rootBst4); //Prints maximum value of Bin_Tree4
		System.out.print("Min Value Bin_Tree4 = "); 
		Bin_tree4.getMin(rootBst4); //Prints minimum value of Bin_Tree4
		System.out.println("Searching given data in Binary Search Tree: " + Bst1.search(rootBst1, 10)); //Searches for the data in binary search tree (array1)
		System.out.print("Searching given data in Binary Tree: ");
		Bin_tree5.search(rootBst5, 40); //Searches for the data in binary tree (array5)

	}

}
