package estruturas;

import dados.Pessoa;

public class Nodo{
	
	
	private String valor;
	private Pessoa dados;
	private Nodo left;
	private Nodo right;
	
	public Nodo(Pessoa dados) {
		this.dados = dados;
		this.valor = dados.getNome();
		this.left = null;
		this.right = null;
	}
	

	
	public Pessoa search() {
		return dados;
	}
	
	public String getValor() {
		return valor;
	}
	
	//default insere a esquerda
	public void setLeftNodo(Nodo nodo) {
		left = nodo;
	}
	
	public void setRightNodo(Nodo nodo) {
		right = nodo;
	}
	
	public Nodo getLeftNodo() {
		return left;
	}
	
	public Nodo getRightNodo() {
		return right;
	}
	
}
