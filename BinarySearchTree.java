package edu.wmich.CS3310.PA2.RajBasnet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This class contains all the information to create Binary Search tree data structure created using nodes (left and right)
 * Extends Comparable class to compare data of two objects (generic data)
 * Implements ITree interface to use all the methods defined in it to create binary search tree
 * Initializes variables Node root, DataComparaot comp
 * @param <T> Represents the generic nature of the class
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

	private Node<T> root;
	private DataComparator<T> comp = new DataComparator<T>();

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
		Stack<Node<T>> stack = new Stack<Node<T>>();

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

		//For binary search tree, searching data is easier
		//If root node is null, return null
		if (root == null){
			return null;

			//Otherwise compare the data with the data of root node
			//If matches return data of root node i.e. value of comparator is 0 
		} else if(comp.compare(data, root.getData()) == 0) {
			return root.getData();
			//Else if the data is smaller than data of root node, traverse towards the left Child and make the comparison again
		} else if(comp.compare(data, root.getData()) == -1){
			return search(root.getLeftChild(), data);
			//Else if the data is greater than data of root node, traverse towards the right Child and make the comparison again
		}else {
			return search(root.getRightChild(), data);
		}

		//If data does not exist in tree, it returns null
	}

	/**
	 * Gets the maximum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the maximum value of the tree
	 */
	public INode<T> getMax(INode<T> root) {

		//Set root node as max node and traverse towards right until right child of the node is null
		Node<T> max = (Node<T>) root;
		while (max.getRightChild() != null) {

			max = (Node<T>) max.getRightChild();
		}
		//The final right child of the tree is the maximum value of tree
		return max;
	}

	/**
	 * Gets the minimum value of the tree
	 * @param root INode represents the root node of the tree
	 * @return Returns the node with the minimum value of the tree
	 */
	public INode<T> getMin(INode<T> root) {

		//Set root node as min node and traverse towards left until left child of the node is null
		Node<T> min = (Node<T>) root;
		while (min.getLeftChild() != null) {

			min = (Node<T>) min.getLeftChild();
		}
		//The final left child of the tree is the minimum value of tree
		return min;
	}

	/**
	 * Inserts the data item into the tree data structure
	 * @param root INode represents the root node of the tree
	 * @param data T represents the data item stored in node of generic nature
	 * @return Returns the root node of the tree where data is inserted
	 */
	public INode<T> insert(INode<T> root, T data){

		//Initialize insert node to be root node and node to be null
		this.root = (Node<T>) root;
		Node<T> insert = (Node<T>) root;
		Node<T> node = null;

		//If root node is null add new node as root node with value data and return root node
		if (root == null) {

			root = new Node<T>(data);
			this.root = (Node<T>) root;
			return root;

		} else {

			//Keep looping until insert node is null
			while (insert != null) {
				//Set the node to be insert node for each loop
				node = insert;

				//Compare the given data with data of insert node
				//If data is smaller than data of insert node, traverse towards the left Child of insert node
				if (comp.compare(data, insert.getData()) == -1) {
					insert = (Node<T>) insert.getLeftChild();
					//Else traverse towards the right Child of insert node
				} else if (comp.compare(data, insert.getData()) == 1) {
					insert = (Node<T>) insert.getRightChild();
					//Else break from loop because data to be inserted already exists
				} else {
					break;
				}
			}

			//Compare the given data with data of node
			//If given data is smaller than the data of node, insert the new node as the left Child of the node
			if (comp.compare(data, node.getData()) == -1) {
				node.setLeftChild(new Node<T>(data));
				//Else if given data is larger than the data of node, insert the new node as the right Child of the node
			} else if (comp.compare(data, node.getData()) == 1){
				node.setRightChild(new Node<T>(data));
				//If they are equal, do nothing
			} else {

			}
			//Return the root node of the tree where data was inserted
			this.root = (Node<T>) root;
			return root;
		}
	}

	/**
	 * Removes the node with specific data from the binary search tree
	 * @param root INode represents the root node of the tree
	 * @param data T represents data to be removed from the tree
	 * @return Returns the root node of the tree from where data is removed
	 */
	public INode<T> remove(INode<T> root, T data){

		//Set remove node as root node and node to be null
		this.root = (Node<T>) root;
		Node<T> remove = (Node<T>) root;
		Node<T> node = null;

		//If root node is null, return root and remove nothing
		if (root == null) {

			return root;
		} 

		//If data to be removed is stored by root node i.e. root node to removed
		/* Then, first find the inorder successor (the node that immediately follows root node in inorder traversal) of the root node
		 * and put that node in place of root node and remove root node.
		 * Also, make sure to break the connection of that node from its parent node, and make left child of root node to be left child of that node
		 * and right child of root node to be right child of that node
		 */
		else if(comp.compare(data, root.getData()) == 0) {
			node = (Node<T>) root;
			Node<T> temp = (Node<T>) node.getRightChild();
			Node<T> temp2 = (Node<T>) node.getRightChild();

			//temp amd temp2 are nodes to find inorder successor
			while(temp.getLeftChild() != null) {

				temp = (Node<T>) temp.getLeftChild();
			}
			if (temp2.getLeftChild() != null) {
				while(temp2.getLeftChild().getLeftChild() != null) {
					temp2 = (Node<T>) temp2.getLeftChild();

				}
			}

			//After finding inorder successor, replace root node with that node by setting and breaking proper connections of both root node and successor node
			if (temp.getData() == temp2.getData()) {
				this.root = (Node<T>) node.getRightChild();
			} else {

				temp2.setLeftChild(null);
				temp.setLeftChild(root.getLeftChild());
				temp.setRightChild(root.getRightChild());
				this.root = temp;
			}
		} 
		//If the data to be removed is present in any other node
		else {
			//Loop to find the node which is to be removed
			while (remove != null) {
				node = remove;

				if (comp.compare(data, remove.getData()) == -1) {
					if (comp.compare(data, remove.getLeftChild().getData()) == 0) {
						break;
					}
					remove = (Node<T>) remove.getLeftChild();
				} else {
					if (comp.compare(data, remove.getRightChild().getData()) == 0) {
						break;
					}
					remove = (Node<T>) remove.getRightChild();
				}

			}

			//Here, we will get the parent node of the node to be removed
			//If node to be removed is the left Child of that parent node then
			if (node.getLeftChild() != null && comp.compare(data, node.getLeftChild().getData()) == 0) {

				//If node to be removed is leaf node (i.e. no children, then just simply remove that node from the tree
				if(node.getLeftChild().getLeftChild() == null && node.getLeftChild().getRightChild() == null) {
					node.setLeftChild(null);
					//Else if node to be removed has one child (right child), then replace the node to be removed by its right child 
				} else if (node.getLeftChild().getLeftChild() == null) {
					node.setLeftChild(node.getLeftChild().getRightChild());
					//Else if node to be removed has one child (left child), then replace the node to be removed by its left child 
				} else if (node.getLeftChild().getRightChild() == null) {
					node.setLeftChild(node.getLeftChild().getLeftChild());
				} else {

					//If node to be removed has two children, then find its inorder succesor node using temp and temp2
					Node<T> temp = (Node<T>) node.getLeftChild().getRightChild();
					Node<T> temp2 = (Node<T>) node.getLeftChild().getRightChild();

					//Loops to find inorder successor traversing using temp and temp2
					while(temp.getLeftChild() != null) {

						temp = (Node<T>) temp.getLeftChild();
					}

					if (temp2.getLeftChild() != null) {
						while(temp2.getLeftChild().getLeftChild() != null) {
							temp2 = (Node<T>) temp2.getLeftChild();

						}
					}

					/* After finding inorder successor node, replace node to be removed with that node by 
					 * setting and breaking proper connections of both removed node and successor node
					 */
					if (temp.getData() == temp2.getData()) {
						temp.setLeftChild(node.getLeftChild().getLeftChild());
						node.setLeftChild(temp);
					} else {
						temp2.setLeftChild(null);
						temp.setLeftChild(node.getLeftChild().getLeftChild());
						temp.setRightChild(node.getLeftChild().getRightChild());
						node.setLeftChild(temp);
					}
				}
			} 
			//If node to be removed is the right Child of that parent node then we can follow the similar process for the right child
			else if ( node.getRightChild() != null && comp.compare(data, remove.getRightChild().getData()) == 0) {

				//If node to be removed is leaf node (i.e. no children), then just simply remove that node from the tree
				if(node.getRightChild().getLeftChild() == null && node.getRightChild().getRightChild() == null) {
					node.setRightChild(null);
					//Else if node to be removed has one child (right child), then replace the node to be removed by its right child 
				} else if (node.getRightChild().getLeftChild() == null) {
					node.setRightChild(node.getRightChild().getRightChild());
					//Else if node to be removed has one child (left child), then replace the node to be removed by its left child 
				} else if (node.getRightChild().getRightChild() == null) {
					node.setRightChild(node.getRightChild().getLeftChild());
				} else {

					//If node to be removed has two children, then find its inorder succesor node using temp and temp2
					Node<T> temp = (Node<T>) node.getRightChild().getRightChild();
					Node<T> temp2 = (Node<T>) node.getRightChild().getRightChild();

					//Loops to find inorder successor traversing using temp and temp2
					while(temp.getLeftChild() != null) {
						temp = (Node<T>) temp.getLeftChild();
					}

					if (temp2.getLeftChild() != null) {
						while(temp2.getLeftChild().getLeftChild() != null) {
							temp2 = (Node<T>) temp2.getLeftChild();
						}
					}

					/* After finding inorder successor node, replace node to be removed with that node by 
					 * setting and breaking proper connections of both removed node and successor node
					 */
					if (temp.getData() == temp2.getData()) {
						temp.setLeftChild(node.getRightChild().getLeftChild());
						node.setRightChild(temp);
					} else {
						temp2.setLeftChild(null);
						temp.setLeftChild(node.getRightChild().getLeftChild());
						temp.setRightChild(node.getRightChild().getRightChild());
						node.setRightChild(temp);
					}
				}
			}
			this.root = (Node<T>) root;

		}
		//Returns the root node of the tree from where data is to be removed
		return root;
	}

	/**
	 * This is an extra class created for inorder traversal and to get the list of all the data of the binary search tree. 
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
