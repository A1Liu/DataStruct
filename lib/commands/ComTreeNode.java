package commands;

import java.util.ArrayList;

/**
 * Tree node of a generalized tree
 * @author Alyer
 *
 * @param <E> dataType of the tree node
 */
class ComTreeNode {
	private String name;
	private Integer id;
	private String helpText;
	
	private ArrayList<ComTreeNode> children;
	
	ComTreeNode(String name) {
		this(name, null);
	}
	
	ComTreeNode(String name, Integer id) {
		this(name, id, null);
	}
	
	ComTreeNode(String name, Integer id, String helpText) {
		this.name = name;
		this.id = id;
		this.helpText = helpText;
		children = new ArrayList<ComTreeNode>(0);
	}

	void addChild(String e) {
		this.addChild(e, null);
	}
	
	void addChild(String e, Integer id) {
		if (!this.children.contains(new ComTreeNode(e,id)))
			this.children.add(new ComTreeNode(e,id));
	}
	
	void addChild(String e, Integer id, String helpText) {
		if (!this.children.contains(new ComTreeNode(e,id)))
			this.children.add(new ComTreeNode(e,id,helpText));
	}
	
	void rmChild(String e) {
		this.children.remove(new ComTreeNode(e));
	}
	
	boolean containsChild(String e) {
		return this.children.contains(new ComTreeNode(e));
	}
	
	ComTreeNode getChild(String e) {
		int index = this.children.indexOf(new ComTreeNode(e));
		return index == -1 ? null : this.children.get(index);
	}
	
	public boolean equals(Object o) {
		if (o instanceof ComTreeNode) {
			if (((ComTreeNode) o).getName() == null) {
				return ((ComTreeNode) o).getName() == name;
			} else if (((ComTreeNode) o).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getID() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(Integer id) {
		this.id = id;
	}
	
	public String getHelp() {
		return helpText;
	}
	
	public void setHelp(String helpText) {
		this.helpText = helpText;
	}

	/**
	 * @return the children
	 */
	public ArrayList<ComTreeNode> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<ComTreeNode> children) {
		this.children = children;
	}
	
	public String toString() {
		String childs = "";
		for (int x = 0; x < children.size(); x++) {
			childs += children.get(x).toString().replaceAll("\\n", "\n\t");
		}
		
		return "\n" + this.name + (id == null ? "" : ":" + id) + childs;
	}

	
}