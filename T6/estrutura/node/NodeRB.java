package estrutura.node;

public class NodeRB<E extends Comparable<E>> extends Node<E> {

	private boolean color;//black = true, red = false
	
	public NodeRB(E key) {
		super(key);
		this.color = false;
	}
	
	public void swapColor() {
		if (isBlack())
			color = false;
		else color = true;
	}
	public boolean isBlack() {
		return color;
	}
	
	public boolean isRed() {
		return !color;
	}
	
	public boolean color() {
		return color;
	}

	public void setBlack() {
		this.color = true;
	}
	
	public void setRed() {
		this.color = false;
	}
	
	public NodeRB<E> grandparent() {
		if (parent == null)
			return null;
		else
			return (NodeRB<E>) parent.parent();
	}//fim avo
	
	public NodeRB<E> uncle() {
		NodeRB<E> grandparent = grandparent();
		if (grandparent == null) {
			return null;
		} else if (parent == grandparent.left()) {
			return (NodeRB<E>) grandparent.right();
		} else {
			return (NodeRB<E>) grandparent.left();
		}
	}//fim tio
	
	public NodeRB<E> sobrinho() {
		if (parent == null) {
			return null;
		} if (this == parent.left()) {
			return (NodeRB<E>) parent.right();
		} else {
			return (NodeRB<E>) parent.left();
		}
	}//fim sobrinho
	
}
