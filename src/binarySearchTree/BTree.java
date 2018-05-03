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
			return addChild(root, e);
		}
	}
	
	/**
	 * adds a descendant of a given node recursively
	 * Since the set of all of a node's descendants cannot contain the node's data itself, the base case checks to see if the node 
	 * @param e element to add
	 * @return true if successful
	 */
	private boolean addChild(BTreeNode<E> node, E e) {
		if (node.getData().equals(e)) {
			return false;
		} else if (e.compareTo(node.getData()) > 0) {
			if (node.getRight() == null) {
				node.setRight(new BTreeNode<E>(e));
				return true;
			} else {
				return addChild(node.getRight(), e);
			}
		} else {
			if (node.getLeft() == null) {
				node.setLeft(new BTreeNode<E>(e));
				return true;
			} else {
				return addChild(node.getLeft(),e);
			}
		}
	}
	
	/**
	 * removes element e from the tree
	 * @param e the element to remove
	 * @return true if successful
	 */
	public boolean remove(E e) {
		if (root.getData().equals(e) && root.getLeft() == null) {
			root = root.getRight();
			return true;
		} else {
			return rmChild(root, e);
		}
	}
	
	/**
	 * removes a child of this node recursively.
	 * @param e element of child to remove
	 * @return true if successful
	 */
	private boolean rmChild(BTreeNode<E> node, E e) {//'this' is a reference to the parent of the node we want to delete
		if (node.getData().equals(e)) {
			if (node.getLeft().getRight() == null) {//checks to make sure the in order successor isn't just the left node. If it is, we need to add if before the loop to prevent null pointer exception
				node.setData(node.getLeft().getData());
				node.setLeft(node.getLeft().getLeft());//successor has no right node so don't need to worry about it.
			} else {// we can use a while loop to find the parent node of the in order successor
				BTreeNode<E> temp = node.getLeft();//start to find in order successor. temp is the parent of the node we'd like to use as successor
				while (temp.getRight().getRight() != null) {
					temp = temp.getRight();
				}
				node.setData(temp.getRight().getData());
				temp.setRight(temp.getRight().getLeft());
			}
			return true;
		} else if (e.compareTo(node.getData()) > 0) {//The element should be a rightwards descendant of this node.
			if (node.getRight() == null) {//There's no descendant where the element should be. Thus, the element isn't in the tree.
				return false;
			} else if (node.getRight().getData().equals(e) && node.getRight().getLeft() == null) {//We found the element, and don't need to do in order succession
				node.setRight(node.getRight().getRight());
				return true;
			} else {//The element isn't the right child, so we keep looking.
				return rmChild(node.getRight(),e);
			}
		} else {//The element should be a leftwards descendant of this node.
			if (node.getLeft() == null) {//There's no descendant where the element should be. Thus, the element isn't in the tree.
				return false;
			} else if (node.getLeft().getData().equals(e) && node.getLeft().getLeft() == null){//We found the element.
				node.setLeft(node.getLeft().getRight());
				return true;
			} else {//The element isn't the left child, so we keep looking.
				return rmChild(node.getLeft(),e);
			}
		}
	}
	
	/**
	 * output this tree's contents in preorder
	 */
	public void preOrder() {
		if (root == null)
			System.out.println("Tree is Empty");
		else {
			System.out.print("PreOrder: [");
			preOrder(root);
			System.out.println("]");
		}
	}
	
	/**
	 * output this tree's contents in order
	 */
	public void inOrder() {
		if (root == null)
			System.out.println("Tree is Empty");
		else {
			System.out.print("InOrder: [");
			inOrder(root);
			System.out.println("]");
		}
	}
	
	/**
	 * output this tree's contents in postorder
	 */
	public void postOrder() {
		if (root == null)
			System.out.println("PostOrder: Tree is Empty");
		else {
			System.out.print("[");
			postOrder(root);
			System.out.println("]");
		}
	}
	
	/**
	 * recursive method to output a tree's contents in preorder
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void preOrder(BTreeNode<T> node) {
		if (node != null) {
			System.out.print(node.getData().toString() + ", ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	/**
	 * recursive method to output a tree's contents in order
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void inOrder(BTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getData().toString() + ", ");
			inOrder(node.getRight());
		}
	}
	
	/**
	 * recursive method to output a tree's contents in postorder
	 * @param node starting node
	 */
	public static <T extends Comparable<T>> void postOrder(BTreeNode<T> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getData().toString() + ", ");
		}
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
