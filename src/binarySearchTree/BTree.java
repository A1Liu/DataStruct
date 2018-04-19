package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BTree<E extends Comparable<E>> {
	
	private BTreeNode<E> root;
	
	public BTree() {
		this((BTreeNode<E>) null);//makes a BTree with a null root, not a root with a null data
	}
	
	public BTree(E e) {
		this(new BTreeNode<E>(e));
	}
	
	public BTree(BTreeNode<E> n) {
		root = n;
	}
	
	public LinkedList<E> dump() {
		LinkedList<E> data = preOrder();
		root = null;
		return data;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean add(E e) {
		if (root == null) {
			root = new BTreeNode<E>(e);
			return true;
		} else {
			return root.addChild(e);
		}
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean remove(E e) {
		if (root.getData().equals(e)) {
			return true;
		} else {
			return root.rmChild(e);
		}
	}
	
	public LinkedList<E> preOrder() {
		return preOrder(root);
	}
	
	public LinkedList<E> inOrder() {
		return inOrder(root);
	}
	
	public LinkedList<E> postOrder() {
		return postOrder(root);
	}
	
	public static <T extends Comparable<T>> LinkedList<T> preOrder(BTreeNode<T> n) {
		return order(0,n, n.getLeft(), n.getRight());
	}
	
	public static <T extends Comparable<T>> LinkedList<T> inOrder(BTreeNode<T> n) {
		return order(1,n.getLeft(),n,n.getRight());	
	}
	
	public static <T extends Comparable<T>> LinkedList<T> postOrder(BTreeNode<T> n) {
		return order(2,n.getLeft(),n.getRight(),n);
	}
	
	@SuppressWarnings("serial")
	final private static <T extends Comparable<T>> LinkedList<T> order(int localRoot, BTreeNode<T> n1,BTreeNode<T> n2,BTreeNode<T> n3) throws IllegalArgumentException {
		
		LinkedList<T> data = new LinkedList<T>();
		
		//Making a list of the inputs to make coding easier
		List<BTreeNode<T>> nodes = new ArrayList<BTreeNode<T>>() {{add(n1);add(n2);add(n3);}};

		//Go through each input, and start adding to the list if necessary
		for (int x = 0; x < nodes.size(); x++) {
			if (nodes.get(x) != null) {
				if (x == localRoot) {
					data.add(nodes.get(x).getData());
				} else {
					if (localRoot == 0){
						data.append(  order(  localRoot,nodes.get(x),nodes.get(x).getLeft(),nodes.get(x).getRight()  )  );
					} else if (localRoot == 1) {
						data.append(  order(  localRoot,nodes.get(x).getLeft(),nodes.get(x),nodes.get(x).getRight()  )  );
					} else {
						data.append(  order(  localRoot,nodes.get(x).getLeft(),nodes.get(x).getRight(),nodes.get(x)  )  );
					}
				}
			}
		}
		return data;
	}
	
	public BTreeNode<E> getRoot() {
		return root;
	}
	
	public String toString() {
		return null;
	}
}

class BTreeNode<E extends Comparable<E>> implements Comparable<E> {
	
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
	
	public BTreeNode<E> find(E e) {
		if (this.getData().equals(e)) {
			return this;
		} else if (e.compareTo(this.getData()) > 0) {
			if (right == null) {
				return null;
			} else {
				return this.getRight().find(e);
			}
		} else {
			if (left == null) {
				return null;
			} else {
				return this.getLeft().find(e);
			}
		}
	}
	
	public boolean addChild(BTreeNode<E> e) {
		if (this.getData().equals(e.getData())) {
			return false;
		} else if (e.compareTo(this.getData()) > 0) {
			if (right == null) {
				this.setRight(e);
				return true;
			} else {
				return this.getRight().addChild(e);
			}
		} else {
			if (left == null) {
				this.setLeft(e);
				return true;
			} else {
				return this.getLeft().addChild(e);
			}
		}
	}

	public boolean addChild(E e) {
		return addChild(new BTreeNode<E>(e));
	}
	
	public boolean rmChild(E e) {
		if (e.compareTo(this.getData()) > 0) {
			if (right == null) {
				return false;
			} else if (right.getData().equals(e)){
				BTreeNode<E> branch = right.getRight();
				right = right.getLeft();
				right.getLeft().addChild(branch);
				return true;
			} else {
				return right.rmChild(e);
			}
		} else {
			if (left == null) {
				return false;
			} else if (left.getData().equals(e)){
				BTreeNode<E> branch = left.getLeft();
				left = left.getRight();
				left.getRight().addChild(branch);
				return true;
			} else {
				return left.rmChild(e);
			}
		}
	}
	
	public BTree<E> getChildren() {
		return new BTree<E>(this);
	}
	
	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BTreeNode<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BTreeNode<E> right) {
		this.right = right;
	}

	@Override
	public int compareTo(E e) {
		return data.compareTo(e);
	}
	
	
	
}
