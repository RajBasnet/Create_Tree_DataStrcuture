package edu.wmich.CS3310.PA2.RajBasnet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class contains all the information to create Binary Tree data structure created using nodes.
 * Extends Comparable class to compare data of two objects (generic data)
 * Implements ITree interface to use all the methods defined in it to create binary tree
 * Initializes variables Node root, DataComparaot comp
 * @param <T> Represents the generic nature of the class
 */
public class BinaryTree<T extends Comparable<T>> implements ITree<T> {

	private Node<T> root;
	private DataComparator<T> comp = new DataComparator<T>();

	/**
	 * Creates a constructor setting the root node as null in th beginning
	 */
	BinaryTree(){
		root = null;
	}

	/**
	 * Sets the comparator for tree to compare generic data
	 * @param treeComp Comparator represents the comparator of generic nature
	 */
	public void setTreeComp(Comparator<T> treeComp) {

		this.comp = (DataComparator<T>) treeComp;
	}

	/**
	 * @return Returns the comparator to compare generic data
	 */
	public Comparator<T> getTreeComp() {

		return comp;
	}

	/**
	 * Sets the root node of the tree
	 * @param root INode represents the root node of the tree
	 */
	public void setRoot(INode<T> root) {

		this.root = (Node<T>) root;
	}

	/**
	 * @return Returns the root node of the tree
	 */
	public INode<T> getRoot() {

		return root;
	}

	/**
	 * Prints the preorder traversal of the binary tree (Root, Left, Right)
	 */
	public void preorder() {

		//Creates linked list object to add the data while doing preorder traversal
		LinkedList<Object> list = new LinkedList<Object>();
		//Set the value of root node in the variable node pre
		Node<T> pre = (Node<T>) this.getRoot();

		//Keep on looping until variable pre has null value
		while (pre != null) {

			//Adds the data of node pre to the list if left Child of node pre is null and traverse towards right Child
			if (pre.getLeftChild() == null) {
				list.add(pre.getData());
				pre = (Node<T>) pre.getRightChild();

				//If left Child of pre node is not null
			} else {
				//Traverse towards left Child setting variable node to be left child of pre node
				Node<T> node = (Node<T>) pre.getLeftChild();

				//Then after that traverse towards right until right Child of node is null or equal to pre
				while (node.getRightChild() != null && node.getRightChild() != pre) {
					node = (Node<T>) node.getRightChild();
				}

				//If right Child of node equals to pre, sets right Child of node as null and traverse towards right Child of pre node
				if (node.getRightChild() == pre) {
					node.setRightChild(null);
					pre = (Node<T>) pre.getRightChild();

					//Else add the data of pre node to list, sets the right Child of node as pre and traverse towards left Child of pre
				} else {
					list.add(pre.getData());
					node.setRightChild(pre);
					pre = (Node<T>) pre.getLeftChild();
				}
			}
		}
		//Print the final list of preorder traversal
		//Basically, the list contains root node first, then left of each node and right of each node
		System.out.println(list);
	}

	/**
	 * Prints the inorder traversal of the binary tree (Left, Root, Right)
	 */
	public void inorder() {

		//Creates linked list object to add the data while doing inorder traversal
		LinkedList<Object> list = new LinkedList<Object>();
		//Set the value of root node in the variable node in
		Node<T> in = (Node<T>) this.getRoot();

		//Keep on looping until variable in has null value
		while (in != null) {

			//Adds the data of node in to the list if left Child of node in is null and traverse towards right Child
			if (in.getLeftChild() == null) {
				list.add(in.getData());
				in = (Node<T>) in.getRightChild();

				//If left Child of in node is not null
			} else {

				//Traverse towards left Child setting variable node to be left child of in node
				Node<T> node = (Node<T>) in.getLeftChild();

				//Then after that traverse towards right until right Child of node is null or equal to in
				while (node.getRightChild() != null && node.getRightChild() != in) {
					node = (Node<T>) node.getRightChild();
				}

				//If right Child of node equals to null, sets right Child of node as in and traverse towards left Child of in node
				if (node.getRightChild() == null) {
					node.setRightChild(in);
					in = (Node<T>) in.getLeftChild();

					//Else sets the right Child of node as null, add the data of in node to the list and traverse towards right Child of in node
				} else {
					node.setRightChild(null);
					list.add(in.getData());
					in = (Node<T>) in.getRightChild();
				}
			}
		}
		//Print the final list of inorder traversal
		//Basically, the list contains left child of each node first, then the node itself and then the right node.
		System.out.println(list);
	}

	/**
	 * Prints the postorder traversal of the binary tree (Left, Right, Root)
	 */
	public void postorder() {

		//Creates linked list object to add the data while doing postorder traversal
		LinkedList<Object> list = new LinkedList<Object>();
		//Set the value of root node in the variable node post
		Node<T> post = (Node<T>) this.getRoot();

		//Create a stack data structure with variable name stack
		Stack<Node<T>> stack = new Stack<Node<T>>(); //@GeeksforGeeks Learned use of stack for this traversal

		if (post == null) {
		}

		//Push the node post to the stack
		stack.push(post);
		//Initialize node temp as null
		Node<T> temp = null;

		//Keeps looping until the stack is empty
		while (stack.isEmpty() == false) {
			//Stores the top value of stack in the variable node 
			Node<T> node = stack.peek();

			//If either temp node is null or left Child of temp node is equal to node or right Child of temp node is equal to node
			if (temp == null || temp.getLeftChild() == node || temp.getRightChild() == node) {

				//If left Child of node is not null, push the left Child of node to stack
				if(node.getLeftChild() != null) {
					stack.push((Node<T>) node.getLeftChild());
					//Else If right Child of node is not null, push the right Child of node to stack
				} else if(node.getRightChild() != null) {
					stack.push((Node<T>) node.getRightChild());
					//Else pop the top value of stack and add the data of node to the list
				} else {
					stack.pop();
					list.add(node.getData());
				}

				//Else if left Child of node equal to temp node
			} else if (node.getLeftChild() == temp) {

				//If right Child of node is not null, push the right Child of node to stack
				if (node.getRightChild() != null) {
					stack.push((Node<T>) node.getRightChild());
					//Else pop the top value of the stack and add the data of the node to the list
				} else {
					stack.pop();
					list.add(node.getData());
				}

				//Else if right Child of node equal to temp node, pop the top value of stack and add the data of node to the list
			} else if (node.getRightChild() == temp) {
				stack.pop();
				list.add(node.getData());
			}

			//Set the value of temp to be value of node
			temp = node;
		}
		//Prints the final list of postorder traversal
		/* Basically, it traverses using one variable to be certain node and another variable to be parent of same node, pushing them into stack 
		 * and popping out whenever required. It prints the left child of any node first, then right child and only then the node itself.
		 */
		System.out.println(list);

	}

	/**
	 * Searches for the specified data in a tree traversing through the tree
	 * @param root INode represents the root node of the tree
	 * @param data T represents the data item of the node of generic nature
	 * @return Returns the searched data it it exists in the tree
	 */
	public T search(INode<T> root, T data) {

		//Creates an array of the all the data found in the tree and store them in the array
		Object[] array = traversalCheck().toArray();

		int j = 0;
		//Check each data of an array using and compare them with the given mentioned data using Data Comparator comp
		for (int i = 1; i < array.length; i++) {
			//If both the data matches, value coming from comparator is 0, then break the loop
			if (comp.compare((T) array[i], data) == 0) {
				j = i;
				break;
			} 
		}
		//Print that data of an array which matches, hence the data searched was found
		if (comp.compare((T) array[j], data) == 0) {
			System.out.println(array[j]);
			//If the data of an array does not match, print data was not found
		} else {
			System.out.println("Data not found");
		}

		//Returns the searched data if it exists
		return (T) array[j];
	}

	/**
	 * Gets the maximum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the maximum value of the tree
	 */
	public INode<T> getMax(INode<T> root) {

		//Sets the max to be root node
		Node<T> max = (Node<T>) root;
		//Creates an array of the all the data found in the tree and store them in the array
		Object[] array = traversalCheck().toArray();
		//Sets the maximum value (maxValue) to be first value of array
		Object maxValue = (int) array[0];

		//Check each data of an array and compare with the maxValue
		for (int i = 1; i < array.length; i++) {

			//If the data of an array is greater than maxValue, then replace the data of maxValue with that data of an array
			if (comp.compare((T) array[i], (T) maxValue) == 1) {
				maxValue = array[i];
			} 
		}

		//Prints the maximum value of the tree
		System.out.println(maxValue);
		//Returns the root node of tree whose maximum value was found
		return max;
	}

	/**
	 * Gets the minimum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the minimum value of the tree
	 */
	public INode<T> getMin(INode<T> root) {

		//Sets the min to be root node
		Node<T> min = (Node<T>) root;
		//Creates an array of the all the data found in the tree and store them in the array
		Object[] array = traversalCheck().toArray();
		//Sets the minimum value (minValue) to be first value of array
		Object minValue = (int) array[0];

		//Check each data of an array and compare with the minValue
		for (int i = 1; i < array.length; i++) {
			//If the data of an array is smaller than minValue, then replace the data of minValue with that data of an array
			if (comp.compare((T) array[i], (T) minValue) == -1) {
				minValue = array[i];
			} 
		}

		//Prints the minimum value of the tree
		System.out.println(minValue);
		//Returns the root node of tree whose minimum value was found
		return min;
	}

	/**
	 * Inserts the data item into the tree data structure
	 * @param root INode represents the root node of the tree
	 * @param data T represents the data item stored in node of generic nature
	 * @return Returns the node of the tree where data is inserted
	 */
	public INode<T> insert(INode<T> root, T data) {

		this.root = (Node<T>) root;

		//If root node is null, create new node with data as root node of the tree
		if (root == null) {
			root = new Node<T>(data);
			this.root = (Node<T>) root;
			return root;

		} else {
			//Create a queue using linked list and add root node into queue
			Queue<Node<T>> queue = new LinkedList<Node<T>>(); //@GeeksforGeeks Learned use of queue for node insertion
			queue.add((Node<T>) root);

			//Keep looping until queue is empty
			while (queue.isEmpty() == false) {

				//Retrieve the head value of queue to be root node and remove the head value of queue
				root = queue.peek();
				queue.remove();

				//If left Child of root is null, set left Child of root to have new node with value data and break the loop
				if (root.getLeftChild() == null) {
					root.setLeftChild(new Node<>(data));
					break;

					//Else add the left Child of root to the queue
				} else {
					queue.add((Node<T>) root.getLeftChild());
				}

				//If right Child of root is null, set the right Child of root to have new node with value data and break the loop
				if (root.getRightChild() == null) {
					root.setRightChild(new Node<>(data));
					break;

					//Else add the right Child of root to the queue
				} else {
					queue.add((Node<T>) root.getRightChild());
				}
			}
		}
		//Returns the node of tree where data is inserted
		return root;
	}

	/**
	 * This is an extra class created for inorder traversal and get the list of all the data of the binary tree. 
	 * Makes easier to know all the data present in the tree which can be converted into array form to print each data of tree.
	 * @return Returns the list of all the data present in the tree in inorder traversal form
	 */
	public LinkedList<Object> traversalCheck(){

		/*
		 * The code is same as the void inorder(), which just prints the inroder traversal of tree
		 * This method is utilized to return the list that contains each data of the tree
		 */

		LinkedList<Object> list = new LinkedList<Object>();
		Node<T> in = (Node<T>) this.getRoot();

		while (in != null) {
			if (in.getLeftChild() == null) {
				list.add(in.getData());
				in = (Node<T>) in.getRightChild();
			} else {
				Node<T> node = (Node<T>) in.getLeftChild();
				while (node.getRightChild() != null && node.getRightChild() != in) {
					node = (Node<T>) node.getRightChild();
				}

				if (node.getRightChild() == null) {
					node.setRightChild(in);
					in = (Node<T>) in.getLeftChild();
				} else {
					node.setRightChild(null);
					list.add(in.getData());
					in = (Node<T>) in.getRightChild();
				}
			}
		}

		//Returns the list which contains all the data of the tree
		return list;
	}

}
