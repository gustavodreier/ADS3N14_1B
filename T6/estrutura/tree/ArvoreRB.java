package estrutura.tree;

import java.util.ArrayList;

import estrutura.node.NodeRB;

public class ArvoreRB<E extends Comparable<E>> {

	private NodeRB<E> raiz;


	public ArvoreRB(){
		raiz = null;
	}


	public void insert(NodeRB<E> nodo) {
		//se arvore vazia nodo = raiz
		if (raiz == null) {
			raiz = nodo;
		} else {
			insert(nodo, raiz);
		}
		
		insertCase1(nodo);
	}
	
	private void insertCase1(NodeRB<E> nodo) {
		if (nodo == null)
			return;
		if (nodo.parent() == null)
			nodo.setBlack();
		else
			insertCase2(nodo);
		
	}

	private void insert(NodeRB<E> nodo, NodeRB<E> arvore) {
		//nao pode existir nodos iguais
		if (nodo.key().compareTo(arvore.key()) == 0) {
			return;
		} else if (nodo.key().compareTo(arvore.key()) < 0) {
			//tenta inserir a esquerda se chave for menor que a arvore
			if (arvore.left() == null) {
				arvore.left(nodo);//atualiza referencia do filho
				nodo.parent(arvore);//atualiza referencia do pai
				//se o pai trocar a altura tem q fazer a validacao
				
			} else 
			insert(nodo, (NodeRB<E>) arvore.left());
		} else if (nodo.key().compareTo(arvore.key()) > 0){
			//se chave for maior tenta inserir a direita
			if (arvore.right() == null) {
				arvore.right(nodo);
				nodo.parent(arvore);
				//se o pai trocar a altura tem q fazer a validacao
				
				//recalcula a altura do pai, recusivamente, caso a mesma tenha trocado
			} else
			insert(nodo, (NodeRB<E>) arvore.right());
		}//else nao insere

	}//fim insere	
	
	private void insertCase2(NodeRB<E> nodo) {

		if (nodo == null || nodo.parent() == null)
			return;
		if (((NodeRB<E>) nodo.parent()).isBlack()) {
			return;
		} else {
			insertCase3(nodo);
		}
		
	}


	private void insertCase3(NodeRB<E> nodo) {
		// TODO Auto-generated method stub
		if (nodo == null)
			return;
		NodeRB<E> uncle = nodo.uncle();
		if (uncle != null && uncle.isRed()) {
			((NodeRB<E>) nodo.parent()).setBlack();
			uncle.setBlack();
			NodeRB<E> grandparent = nodo.grandparent();
			grandparent.setRed();
			insertCase1(grandparent);
		} else {
			insertCase4(nodo);
		}
		
	}


	private void insertCase4(NodeRB<E> nodo) {
		// TODO Auto-generated method stub
		if (nodo == null)
			return;

		NodeRB<E> grandparent = nodo.grandparent();
		NodeRB<E> parent = (NodeRB<E>) nodo.parent();

		if (grandparent != null)
		{
			if (nodo == parent.right() && parent == grandparent.left())
			{
				rotateLeft(parent);
				nodo = (NodeRB<E>) nodo.left();
			} else if (nodo == parent.left() && parent == grandparent.right()) {
				rotateRight(parent);
				nodo = (NodeRB<E>) nodo.right();
			}
		}
		addCaso5(nodo);
		
	}//fim caso 4
	
	private void addCaso5(NodeRB<E> nodo) {
		if (nodo == null)
			return;
		NodeRB<E> grandparent = nodo.grandparent();
		NodeRB<E> parent = (NodeRB<E>) nodo.parent();

		parent.setBlack();

		if (grandparent != null) {
			grandparent.setRed();

			if (nodo == parent.left()) {
				rotateRight(grandparent);
			} else {
				rotateLeft(grandparent);
			}
		}
	}//fim caso 5

	private void rotateLeft(NodeRB<E> nodo) {
		NodeRB<E> filho = (NodeRB<E>) nodo.right();
		if (nodo.parent() == null) {
			raiz = filho;
		} else {
			//se for o filho a esquerda
			if (nodo == nodo.parent().left())
				nodo.parent().left(filho);
			else
				nodo.parent().right(filho);
		}
		if (filho != null) {
			filho.parent(nodo.parent());
		}
		nodo.right(filho.left());
		if (filho.left() != null) {
			filho.left().parent(nodo);
		}
		filho.left(nodo);
		nodo.parent(filho);
	}

	private void rotateRight(NodeRB<E> nodo) {
		NodeRB<E> filho = (NodeRB<E>) nodo.left();
		if (nodo.parent() == null) {
			raiz = filho;
		} else {
			//se for o filho a esquerda
			if (nodo == nodo.parent().left())
				nodo.parent().left(filho);
			else
				nodo.parent().right(filho);
		}
		if (filho != null) {
			filho.parent(nodo.parent());
		}
		nodo.left(filho.right());
		if (filho.right() != null) {
			filho.right().parent(nodo);
		}
		filho.right(nodo);
		nodo.parent(filho);
	}//fim rotateRight
	
	public ArrayList<NodeRB<E>> travessiaPosfixa() {

		ArrayList<NodeRB<E>> lista = new ArrayList<NodeRB<E>>();
		if (raiz == null)
			return lista;
		travessiaPosfixa(raiz, lista);
		return lista;

	}//fim travessiaPosfixa
	/*
	private ArrayList<NodeAVL<E>> travessiaPosfixa(NodeAVL<E> nodo) {
		return travessiaPosfixa(nodo, new ArrayList<NodeAVL<E>>());
	}
	*/
	private ArrayList<NodeRB<E>> travessiaPosfixa(NodeRB<E> nodo, ArrayList<NodeRB<E>> lista) {

		if (nodo == null)
			return lista;
		travessiaPosfixa((NodeRB<E>) nodo.right(), lista);
		travessiaPosfixa((NodeRB<E>) nodo.left(), lista);
		
		//nodo.calculaAltura();
		lista.add(nodo);
		//nodo.calculaAltura(nodo);
		//validaAVL(nodo);
		
		
		return lista;
	}//fim travessia Posfixa
	
	public NodeRB<E> raiz() {
		return raiz;
	}
}



