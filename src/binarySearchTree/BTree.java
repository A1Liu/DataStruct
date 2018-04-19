package binarySearchTree;

public class BTree<E extends Comparable<E>> {
	
	private BTreeNode<E> root;
	
	public BTree() {
		this((BTreeNode<E>) null);//makes a BTree with a null root, not a root with a null data
	}
	
	public BTree(E e) {
		this(new BTreeNode<E>(e));
	}
	
	BTree(BTreeNode<E> n) {
		root = n;
	}
	
	public void empty() {
		root = null;
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
	
	public void preOrder() {
		System.out.print("[");
		preOrder(root);
		System.out.println("]");
	}
	
	public void inOrder() {
		System.out.print("[");
		inOrder(root);
		System.out.println("]");
	}
	
	public void postOrder() {
		System.out.print("[");
		postOrder(root);
		System.out.println("]");
	}
	
	public static <T extends Comparable<T>> void preOrder(BTreeNode<T> node) {
		
		System.out.print(node.getData().toString() + ", ");
		
		if (node.getLeft() != null) {
			preOrder(node.getLeft());
		}
		
		if (node.getRight() != null) {
			preOrder(node.getRight());
		}
	}
	
	public static <T extends Comparable<T>> void inOrder(BTreeNode<T> node) {
		if (node.getLeft() != null) {
			inOrder(node.getLeft());
		}
		
		System.out.print(node.getData().toString() + ", ");
		
		if (node.getRight() != null) {
			inOrder(node.getRight());
		}
	}
	
	public static <T extends Comparable<T>> void postOrder(BTreeNode<T> node) {
		
		if (node.getLeft() != null) {
			postOrder(node.getLeft());
		}
		
		if (node.getRight() != null) {
			postOrder(node.getRight());
		}
		
		System.out.print(node.getData().toString() + ", ");
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
