package edu.wmich.CS3310.PA2.RajBasnet;

/**
 * This class contains all the information for the node to be utilized to create tree data structure.
 * Extends Comparable class for comparing objects.
 * Implements INode interface to implement all methods defined in it
 * Initializes variables T data, Node leftChild and Node rightChild
 * @param <T> It represents the generic nature of the class
 */
public class Node<T extends Comparable<T>> implements INode<T> {

	private T data;
	private Node<T> leftChild, rightChild;

	/**
	 * Creates a constructor with data as a parameter
	 * @param data T represents the data object of generic nature
	 */
	public Node(T data) {
		this.data = data;
		leftChild = rightChild = null;
	}

	/**
	 * @return Returns the data item stored in node
	 */
	public T getData() {

		return data;
	}

	/**
	 * Sets the data item for the node
	 * @param data Represents the object T of the generic interface
	 */
	public void setData(T data) {

		this.data = data;
	}

	/**
	 * @return Returns the pointer to the left child of the node
	 */
	public INode<T> getLeftChild() {

		return leftChild;
	}

	/**
	 * Sets the pointer for the left child of the node
	 * @param leftChild INode represents the left child of the node
	 */
	public void setLeftChild(INode<T> leftChild) {

		this.leftChild = (Node<T>) leftChild;
	}

	/**
	 * @return Returns the pointer to the right child of the node
	 */
	public INode<T> getRightChild() {

		return rightChild;
	}

	/**
	 * Sets the pointer for the right child of the node
	 * @param rightChild INode represents the right child of the node
	 */
	public void setRightChild(INode<T> rightChild) {

		this.rightChild = (Node<T>) rightChild;
	}

}
