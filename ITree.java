package edu.wmich.CS3310.PA2.RajBasnet;

import java.util.Comparator;

/**
 * This interface is implemented by Binary Tree and Binary Search Tree class to use all methods defined in it.
 * @param <T> Represents the generic nature of the interface.
 */
public interface ITree<T> {

	/**
	 * Sets the comparator for tree to compare generic data
	 * @param treeComp Comparator represents the comparator of generic nature
	 */
	void setTreeComp(Comparator<T> treeComp);

	/**
	 * @return Returns the comparator to compare generic data
	 */
	Comparator<T> getTreeComp();

	/**
	 * Sets the root node of the tree
	 * @param root INode represents the root node of the tree
	 */
	void setRoot(INode<T> root);

	/**
	 * @return Returns the root node of the tree
	 */
	INode<T> getRoot();

	/**
	 * Prints the tree in a preorder traversal (Root, Left, Right)
	 */
	void preorder();	// print tree in a preorder traversal

	/**
	 * Prints the tree in an inorder traversal (Left, Root, Right)
	 */
	void inorder();	    // print tree in an inorder traversal

	/**
	 * Prints the tree in a postorder traversal (Left, Right, Root)
	 */
	void postorder();	    // print tree in a postorder traversal

	/**
	 * Searches for the specified data in a tree traversing through the tree
	 * @param root INode represents the root node of the tree
	 * @param data T represents the data item of the node of generic nature
	 * @return Returns the searched data it it exists in the tree
	 */
	T search(INode<T> root, T data); 

	/**
	 * Gets the maximum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the maximum value of the tree
	 */
	INode<T> getMax(INode<T> root); 

	/**
	 * Gets the minimum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the minimum value of the tree
	 */
	INode<T> getMin(INode<T> root); 

	/**
	 * Inserts the data item into the tree data structure
	 * @param root INode represents the root node of the tree
	 * @param data T represents the data item stored in node of generic nature
	 * @return Returns the root node of the tree where data is inserted
	 */
	INode<T> insert(INode<T> root, T data);     

}
