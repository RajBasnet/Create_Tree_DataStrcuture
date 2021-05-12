package edu.wmich.CS3310.PA2.RajBasnet;

import java.util.Arrays;

/**
 * This class contains all the information needed to create a tree checker to know if two trees are mirror or identical or none.
 * Extends Comparable class for comparison of data
 * Implements ITreeChecker to use all the methods defined
 * @param <T> Represents the generic nature of the class
 */
public class TreeChecker<T extends Comparable<T>> implements ITreeChecker<T> {

	/**
	 * This method checks if the two trees are mirror image of each other or not. If yes, it returns true else false
	 * @param root1 ITree represents the tree to be checked (generally this is Binary Search Tree for this project)
	 * @param root2 ITree represents the tree to be checked (generally this is Binary Tree for this project)
	 * @return Returns the boolean value true or false
	 */
	public boolean isMirror(ITree<T> root1, ITree<T> root2) {

		//Creates two trees: tree1 being Binary Search Tree and tree2 being just Binary tree
		BinarySearchTree<T> tree1 = new BinarySearchTree<T>();
		BinaryTree<T> tree2 = new BinaryTree<T>();

		//Cast given parameters root1 and root2 to be tree1 and tree2 respectively
		tree1 = (BinarySearchTree<T>) root1;
		tree2 = (BinaryTree<T>) root2;

		//Using traversalCheck() method created in Binary Search Tree and Binary tree, create two arrays array1 (BST) and array2 (BT)
		Object[] array1 = tree1.traversalCheck().toArray();
		Object[] array2 = tree2.traversalCheck().toArray();

		//Initialize new array of same length as array2
		Object[] array =  new Object[array2.length];

		//Using loop, store each element of array2 to array beginning from last to ending at first
		//For example: if array2 = {1,2,3,4,5} , then array will become {5,4,3,2,1}
		int j = 0;
		for (int i = array2.length-1; i >= 0; i--) {

			array[j] = array2[i];
			j++;
		}

		//Now, if newly created array (from array2), matches array1 i.e. each element from array equals array2 along with number of elements
		// The return true i.e. array matches
		if (Arrays.equals(array1, array)) {
			return true;
			//Else return false i.e. array does not match
		} else {
			return false;
		}

		/* Basically, if we store all the data of inorder traversal of a tree and its mirror tree in two arrays, then they will have same number of elements
		 * as well as their elements from start to end of a tree will be same as its mirror from end to start.
		 * For example, if a tree has inorder traversal in array form to be {10,20,30,40,50}
		 * Then, inorder traversal of its mirror tree in array form has to be {50,40,30,20,10}
		 * These two tree matches when one of its array is taken from last to first and hence will be mirror form.
		 */
	}

	/**
	 * This method checks if the two trees are identical each other or not. If yes, it returns true else false
	 * @param root1 ITree represents the tree to be checked (generally this is Binary Search Tree for this project)
	 * @param root2 ITree represents the tree to be checked (generally this is Binary Tree for this project)
	 * @return Returns the boolean value true or false
	 */
	public boolean isSame(ITree<T> root1, ITree<T> root2) {

		//Creates two trees: tree1 being Binary Search Tree and tree2 being just Binary tree
		BinarySearchTree<T> tree1 = new BinarySearchTree<T>();
		BinaryTree<T> tree2 = new BinaryTree<T>();

		//Cast given parameters root1 and root2 to be tree1 and tree2 respectively
		tree1 = (BinarySearchTree<T>) root1;
		tree2 = (BinaryTree<T>) root2;

		//Using traversalCheck() method created in Binary Search Tree and Binary tree, create two arrays array1 (BST) and array2 (BT)
		Object[] array1 = tree1.traversalCheck().toArray();
		Object[] array2 = tree2.traversalCheck().toArray();

		//If both arrays have same number of elements and each element matches with each other, then the trees are identical
		//For trees to be identical, the place where elements are kept in tree should also match therefore matching traversal of both trees help
		if (Arrays.equals(array1, array2)) {
			return true;
		} else {
			return false;
		}

	}

}
