package binarySearchTree;

public class BTree<T extends Comparable<T>> {
	
	private BTreeNode<T> root;
	
	public BTree() {
		this((BTreeNode<T>) null);//makes a BTree with a null root, not a root with a null data
	}
	
	public BTree(T t) {
		this(new BTreeNode<T>(t));
	}
	
	public BTree(BTreeNode<T> n) {
		root = n;
	}
	
	/**
	 * getter for root
	 * @return root node of tree
	 */
	public BTreeNode<T >getRoot() {
		return root;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean add(T t) {
		return false;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean remove(T t) {
		return false;
	}
	
	public LinkedList<T> preOrder() {
		return null;
	}
	
	public LinkedList<T> inOrder() {
		return null;	
	}
	
	public LinkedList<T> postOrder() {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
}

class BTreeNode<T extends Comparable<T>> implements Comparable<T> {
	
	private T data;
	private BTreeNode<T> left;
	private BTreeNode<T> right;
	
	BTreeNode(T t) {
		this(t,null,null);
	}
	
	BTreeNode(T t, BTreeNode<T> l, BTreeNode<T> r) {
		data = t;
		left = l;
		right = r;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BTreeNode<T> getRight() {
		return right;
	}
	
	public BTree<T> getChildren() {
		return new BTree<T>(this);
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public int compareTo(T t) {
		return data.compareTo(t);
	}
	
	
	
}
