package estrutura.node;

public class Node <E extends Comparable<E>> {

	protected Node<E> left;
	protected Node<E> right;
	protected Node<E> parent;
	protected E key;
	
	public Node(E key) {
		this.key = key;
		left = right = parent = null;
	}
	public boolean hasParent() {
		return parent != null;
	}
	public boolean hasLeft() {
		return left != null;
	}
	public boolean hasRight() {
		return right != null;
	}
	public Node<E> left() {
		return left;
	}
	public void left(Node<E> left) {
		this.left = left;
	}
	public Node<E> right() {
		return right;
	}
	public void right(Node<E> right) {
		this.right = right;
	}
	public Node<E> parent() {
		return parent;
	}
	public void parent(Node<E> parent) {
		this.parent = parent;
	}
	public E key() {
		return key;
	}
	public void key(E key) {
		this.key = key;
	}
	
	
}
