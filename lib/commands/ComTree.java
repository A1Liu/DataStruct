package commands;

/**
 * Tree class
 * @author Alyer
 *
 * @param <E> data type that the tree holds
 */
class ComTree {

	private ComTreeNode root;
	
	
	public ComTree() {
		root = new ComTreeNode("Root");
	}
	
	public void addPath(String[] elist) {
		addPath(elist, null);
	}
	
	public ComTreeNode getRoot() {
		return root;
	}
	
	void setRoot(ComTreeNode root) {
		this.root = root;
	}
	
	
	/**
	 * adds a path in the tree that includes all elements of e, in order
	 * @param elist the list of elements that should be added
	 */
	public void addPath(String[] elist, Integer id) {
		ComTreeNode wd = root;
		for (String element : elist) {
			wd.addChild(element);
			wd = wd.getChild(element);
		}
		wd.setID(id);
	}
	
	/**
	 * adds a list of child nodes at a specific path
	 * @param ePath path to where the nodes should be added
	 * @param children list of nodes to add
	 */
	public void addChildren(String[] ePath, String[] children) {
		ComTreeNode wd = root;
		try {
			for (String element : ePath) {
				wd = wd.getChild(element);
			}
		} catch (NullPointerException e) {
			return;
		}
		for (String element : children) {
			wd.addChild(element);
		}
	}
	
	public String toString() {
		String childs = "";
		for (int x = 0; x < root.getChildren().size(); x++) {
			childs += root.getChildren().get(x).toString();
		}
		return childs;
	}
}