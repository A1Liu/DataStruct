package binarySearchTree;

public class BTree<E extends Comparable<E>> {
	
	private BTreeNode<E> root;
	
	public BTree() {
		root = null;//makes a BTree with a null root, not a root with a null data
	}
	
	/**
	 * deletes all nodes in the tree
	 */
	public void empty() {
		root = null;
	}
	
	/**
	 * Adds an element to the tree
	 * @param e element to add
	 * @return true if successful, false if element is already in tree
	 */
	public boolean add(E e) {
		if (root == null) {//If the tree is empty, just add the element as root
			root = new BTreeNode<E>(e);
		} else if (e.equals(root.getData())) {//If the root contains e, then we can't add
			return false;
		} else {//General case
			BTreeNode<E> parent = descendTree(root, e);//Descend tree until we're at the parent node
			BTreeNode<E> child = e.compareTo(parent.getData()) > 0 ? parent.getRight() : parent.getLeft();//Child node that represents where the element we're adding should be
			if (child == null) {//If there's a space for e, we can add it
				if (e.compareTo(parent.getData()) > 0) parent.setRight(new BTreeNode<E>(e)); else parent.setLeft(new BTreeNode<E>(e));
			} else return false;//e is already there, so we can't add
		}
		return true;
	}
	
	/**
	 * Removes an element from the tree
	 * @param e element to remove
	 * @return true if successful, false if element isn't in tree
	 */
	public boolean remove(E e) {
		if (root == null) {//empty tree, can't remove anything
			return false;
		} else if (root.getData().equals(e)) {//remove the root, no need to use recursive method (also can't)
			if (root.getLeft() == null) {
				root = root.getRight();
			} else delete(root);
		} else {//General case
			BTreeNode<E> parent = descendTree(root, e);//descend tree until we get to parent of node we want to delete
			BTreeNode<E> child = e.compareTo(parent.getData()) > 0 ? parent.getRight() : parent.getLeft();//where the child should be
			if (child == null) {//nothing there! e isn't in tree
				return false;
			} else if (child.getLeft() == null){//if the child has 1 children or 0 children
				if (e.compareTo(parent.getData()) > 0) parent.setRight(child.getRight()); else parent.setLeft(child.getRight());//set the child to the successor, either null or the only child
			} else {//use in order successor method to delete
				delete(child);
			}
		}
		return true;
	}
	
	/**
	 * deletes a node using the in-order succession method (plus some other stuff I guess)
	 * @param node
	 */
	private void delete(BTreeNode<E> node) {
		if (node.getLeft().getRight() == null) {//checks to make sure the in order successor isn't just the left node. If it is, we need to add it before the loop to prevent null pointer exception
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
	}
	
	/**
	 * Descends the tree until it finds the parent of the node we're looking for
	 * @param node the parent node we're currently at
	 * @param e the element to find
	 * @return the parent node of the element we're trying to find, or at least the parent of where the element would be.
	 */
	private BTreeNode<E> descendTree(BTreeNode<E> node, E e) {
		
		BTreeNode<E> child = e.compareTo(node.getData()) > 0 ? node.getRight() : node.getLeft();//Decides which child to look at
		
		if (child == null || child.getData().equals(e))//we've found where 'e' should be; return the parent node down the stack
			return node;
		return descendTree(child, e);//otherwise we keep looking for e
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
	private void preOrder(BTreeNode<E> node) {
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
	private void inOrder(BTreeNode<E> node) {
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
	private void postOrder(BTreeNode<E> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getData().toString() + ", ");
		}
	}
	
	/**
	 * getter for the root node. Package visibility because tree nodes shouldn't be accessible by classes outside of package
	 * @return the root node
	 */
	BTreeNode<E> getRoot() {
		return root;
	}
}
