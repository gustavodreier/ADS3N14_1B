package estrutura.node;

public class NodeAVL<E extends Comparable<E>> extends Node<E>{
	
	private int height;
	
	public NodeAVL(E key) {
		super(key);
		this.changeHeight();
	}

	public int highHeight(NodeAVL<E> node) {
		//retorna a altura do maior filho
		//se nao tiver retorn zero
		int hLeft = 0;
		int hRight = 0;
		
		if (node.hasLeft()) {
			hLeft = ((NodeAVL<E>) node.left).height;
		}
		if (node.hasRight()) {
			hRight = ((NodeAVL<E>) node.right).height;
		}
		
		if (hLeft > hRight) {
			return hLeft;
		}
		return hRight;
	}
	
	public boolean changeHeight() {
		//troca a altura, se mudar retorna true
		int alt = height;
		height = highHeight(this) + 1;
		if (height != alt) {
			return true;
		}
		return false;
	}
	public int height() {
		return height;
	}
	
}
