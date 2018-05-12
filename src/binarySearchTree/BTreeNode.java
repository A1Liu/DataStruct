package binarySearchTree;

/**
 * This class represents a node in a binary tree structure. Its access is only package wide to prevent other classes besides the BTree class from altering the tree's structural integrity.
 * For any node in the tree, data equal to or less than its data will be to its left, and data greater than its own will be to the right
 * @author Alyer
 *
 * @param <E> The data type of the tree. The data needs to be comparable to take advantage of the O(log(n)) search time of a binary tree.
 */
class BTreeNode<E extends Comparable<E>> implements Comparable<BTreeNode<E>> {
	
	private E data;
	private BTreeNode<E> left;
	private BTreeNode<E> right;
	
	BTreeNode(E e) {
		this(e,null,null);
	}
	
	BTreeNode(E e, BTreeNode<E> l, BTreeNode<E> r) {
		data = e;
		left = l;
		right = r;
	}
	
	/**
	 * finds a child of this node recursively
	 * @param e element to find
	 * @return the child, or null if not found
	 */
//	BTreeNode<E> find(E e) {
//		if (this.getData().equals(e)) {
//			return this;
//		} else if (e.compareTo(this.getData()) > 0) {
//			if (right == null) {
//				return null;
//			} else {
//				return this.getRight().find(e);
//			}
//		} else {
//			if (left == null) {
//				return null;
//			} else {
//				return this.getLeft().find(e);
//			}
//		}
//	}
	
	/**
	 * getter for data
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * setter for data
	 * @param data the data to set
	 */
	void setData(E data) {
		this.data = data;
	}

	/**
	 * getter for left child
	 * @return the left
	 */
	public BTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * setter for left child
	 * @param left the left to set
	 */
	void setLeft(BTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * getter for right child
	 * @return the right
	 */
	public BTreeNode<E> getRight() {
		return right;
	}

	/**
	 * setter for right child
	 * @param right the right to set
	 */
	void setRight(BTreeNode<E> right) {
		this.right = right;
	}

	
	@Override
	public int compareTo(BTreeNode<E> e) {
		return data.compareTo(e.getData());
	}
	
	/**
	 * ToString for a single node
	 */
	public String toString() {
		return "[Tree Node containing " + getData().toString() + "]";
	}
	
}