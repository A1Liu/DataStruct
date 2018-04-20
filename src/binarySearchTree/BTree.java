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
	
	/**
	 * deletes all nodes in the tree
	 */
	public void empty() {
		root = null;
	}
	
	/**
	 * adds element e to the tree
	 * @param e the element to add
	 * @return true if successful
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
	 * removes element e from the tree
	 * @param e the element to remove
	 * @return true if successful
	 */
	public boolean remove(E e) {
		if (root.getData().equals(e)) {
			return true;
		} else {
			return root.rmChild(e);
		}
	}
	
	/**
	 * output this tree's contents in preorder
	 */
	public void preOrder() {
		System.out.print("[");
		preOrder(root);
		System.out.println("]");
	}
	
	/**
	 * output this tree's contents in order
	 */
	public void inOrder() {
		System.out.print("[");
		inOrder(root);
		System.out.println("]");
	}
	
	/**
	 * output this tree's contents in postorder
	 */
	public void postOrder() {
		System.out.print("[");
		postOrder(root);
		System.out.println("]");
	}
	
	/**
	 * recursive method to output a tree's contents in preorder
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void preOrder(BTreeNode<T> node) {
		
		System.out.print(node.getData().toString() + ", ");
		
		if (node.getLeft() != null) {
			preOrder(node.getLeft());
		}
		
		if (node.getRight() != null) {
			preOrder(node.getRight());
		}
	}
	
	/**
	 * recursive method to output a tree's contents in order
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void inOrder(BTreeNode<T> node) {
		if (node.getLeft() != null) {
			inOrder(node.getLeft());
		}
		
		System.out.print(node.getData().toString() + ", ");
		
		if (node.getRight() != null) {
			inOrder(node.getRight());
		}
	}
	
	/**
	 * recursive method to output a tree's contents in postorder
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void postOrder(BTreeNode<T> node) {
		
		if (node.getLeft() != null) {
			postOrder(node.getLeft());
		}
		
		if (node.getRight() != null) {
			postOrder(node.getRight());
		}
		
		System.out.print(node.getData().toString() + ", ");
	}
	
	/**
	 * getter for the root node. Package visibility because tree nodes shouldn't be accessible without using the BTree
	 * @return the root node
	 */
	BTreeNode<E> getRoot() {
		return root;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return "BTree with root node containing "+ root.getData();
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
	
	/**
	 * finds a child of this node recursively
	 * @param e element to find
	 * @return the child, or null if not found
	 */
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
	
	/**
	 * adds a child of this node recursively
	 * @param e element to add
	 * @return true if successful
	 */
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
	
	/**
	 * removes a child of this node recursively
	 * @param e element of child to remove
	 * @return true if successful
	 */
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
	
	public String toString() {
		return "[Tree Node containing " + getData().toString() + "]";
	}
	
}
