package edu.wmich.CS3310.PA2.RajBasnet;

/**
 * This interface is implemented by TreeChecker to use all the methods defined in it.
 * @param <T> Represents the generic nature of the tree
 */
public interface ITreeChecker<T> {

	/**
	 * This method checks if the two trees are mirror image of each other or not. If yes, it returns true else false
	 * @param root1 ITree represents the tree to be checked (generally this is Binary Search Tree for this project)
	 * @param root2 ITree represents the tree to be checked (generally this is Binary Tree for this project)
	 * @return Returns the boolean value true or false
	 */
	boolean isMirror(ITree<T> root1, ITree<T> root2); // check if two trees are mirror images

	/**
	 * This method checks if the two trees are identical each other or not. If yes, it returns true else false
	 * @param root1 ITree represents the tree to be checked (generally this is Binary Search Tree for this project)
	 * @param root2 ITree represents the tree to be checked (generally this is Binary Tree for this project)
	 * @return Returns the boolean value true or false
	 */
	boolean isSame(ITree<T> root1, ITree<T> root2);  // check if two trees are identical

}
