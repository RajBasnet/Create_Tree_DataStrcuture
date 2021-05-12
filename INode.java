package edu.wmich.CS3310.PA2.RajBasnet;

/**
 * This interface is implemented by Node class to utilize all methods defined in it.
 * 
 * @param <T> It represents the generic nature of the interface.
 */
public interface INode<T> {

	/**
	 * @return Returns the data item stored in node
	 */
	T getData();

	/**
	 * Sets the data item for the node
	 * @param data Represents the object T of the generic interface
	 */
	void setData(T data);

	/**
	 * @return Returns the pointer to the left child of the node
	 */
	INode<T> getLeftChild() ;

	/**
	 * Sets the pointer for the left child of the node
	 * @param leftChild INode represents the left child of the node
	 */
	void setLeftChild(INode<T> leftChild) ;

	/**
	 * @return Returns the pointer to the right child of the node
	 */
	INode<T> getRightChild() ;

	/**
	 * Sets the pointer for the right child of the node
	 * @param rightChild INode represents the right child of the node
	 */
	void setRightChild(INode<T> rightChild);

}
