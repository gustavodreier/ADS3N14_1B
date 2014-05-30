package estrutura.tree;

import java.util.ArrayList;

import estrutura.node.NodeAVL;

public class AVLTree<E extends Comparable<E>> {

	private NodeAVL<E> raiz;
	
	public AVLTree() {
		raiz = null;
	}
	
	public boolean isEmpty() {
		return raiz == null;
	}
	
	public void insert(NodeAVL<E> nodo) {
		//se arvore vazia nodo = raiz
		if (isEmpty()) {
			raiz = nodo;
		} else {
			insert(nodo, raiz);
		}
	}
	
	private void insert(NodeAVL<E> nodo, NodeAVL<E> arvore) {
		//nao pode existir nodos iguai
		if (nodo.key().compareTo(arvore.key()) == 0) {
			return;
		} else if (nodo.key().compareTo(arvore.key()) < 0) {
			//tenta inserir a esquerda se chave for menor que a arvore
			if (arvore.left() == null) {
				arvore.left(nodo);//atualiza referencia do filho
				nodo.parent(arvore);//atualiza referencia do pai
				//se o pai trocar a altura tem q fazer a validacao
				if (arvore.changeHeight())
					validaAVL(arvore);
			} else 
			insert(nodo, (NodeAVL<E>) arvore.left());
		} else if (nodo.key().compareTo(arvore.key()) > 0){
			//se chave for maior tenta inserir a direita
			if (arvore.right() == null) {
				arvore.right(nodo);
				nodo.parent(arvore);
				//se o pai trocar a altura tem q fazer a validacao
				if (arvore.changeHeight())
					validaAVL(arvore);
				//recalcula a altura do pai, recusivamente, caso a mesma tenha trocado
			} else
			insert(nodo, (NodeAVL<E>) arvore.right());
		}//else nao insere

	}//fim insere

	public ArrayList<NodeAVL<E>> travessiaPosfixa() {

		ArrayList<NodeAVL<E>> lista = new ArrayList<NodeAVL<E>>();
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
	private ArrayList<NodeAVL<E>> travessiaPosfixa(NodeAVL<E> nodo, ArrayList<NodeAVL<E>> lista) {

		if (nodo == null)
			return lista;
		travessiaPosfixa((NodeAVL<E>) nodo.right(), lista);
		travessiaPosfixa((NodeAVL<E>) nodo.left(), lista);
		
		//nodo.calculaAltura();
		lista.add(nodo);
		//nodo.calculaAltura(nodo);
		//validaAVL(nodo);
		
		
		return lista;
	}//fim travessia Posfixa
	
	
	/*
	
	public NodeAVL<E> rotateLeft(NodeAVL<E> nodo) {
		
		NodeAVL<E> filho = (NodeAVL<E>) nodo.right();//2
		nodo.right(filho.left());//1.r = null
		filho.left(nodo);//2.left = 1
		filho.parent(nodo.parent());//2.pai = 9
		nodo.parent(filho);//1.pai = 2
		if (nodo.right() != null) {
			nodo.right().parent(nodo);
		}
		
		if(nodo == raiz)
			raiz = filho;
		return filho;
	}
	*/
	public NodeAVL<E> rotateLeft(NodeAVL<E> nodo) {

		/*
				2
			  /
			 1
			   \
			     3
		*/
		
		NodeAVL<E> filho = (NodeAVL<E>) nodo.right();
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
		//System.out.println("Rotacionando a esquerda"+nodo.key());
		
		////System.out.println("Nodo.parent = "+nodo.parent().key());
		/*
		NodeAVL<E> filho = (NodeAVL<E>) nodo.right();//3
		nodo.right(filho.left());//1.right = null
		if (filho.hasLeft()) {//nao
			////System.out.println("tem filho a esquerda");
			nodo.right().parent(nodo);
		}
		filho.parent(nodo.parent());//3.parent = 2
		filho.left(nodo);//3.left = 1
		if (nodo == raiz) {//nao eh
			//o unico nodo que nao tem pai eh a raiz
			raiz = filho;
		}
		nodo.parent(filho);//1.parent = 3
		
		nodo.changeHeight();//h eh 1
		//System.out.println(nodo.key()+".height = "+nodo.height());
		filho.changeHeight();//h eh 2
		//System.out.println(filho.key()+".height = "+filho.height());
		/*

		String mensagem = "";
		if(nodo.hasLeft()) {
			mensagem += nodo.key()+".Left = "+nodo.left().key()+"\n";
			mensagem += nodo.left().key()+".parent = "+nodo.left().parent().key()+"\n";
		}
		if(nodo.hasRight())
			mensagem += nodo.key()+".Right = "+nodo.right().key()+"\n";
			//mensagem += nodo.right().key()+".parent = "+nodo.right().parent().key()+"\n";
		    mensagem += ".parent = \n";
		if(nodo.hasParent())
			mensagem += nodo.key()+".Parent = "+nodo.parent().key()+"\n";
			
		
		if(filho.hasLeft())
			mensagem += filho.key()+".Left = "+filho.left().key()+"\n";
			mensagem += filho.left().key()+".parent = "+filho.left().parent().key()+"\n";
		if(filho.hasRight())
			mensagem += filho.key()+".Right = "+filho.right().key()+"\n";
			mensagem += filho.right().key()+".parent = "+filho.right().parent().key()+"\n";
		if(filho.hasParent())
			mensagem += filho.key()+".Parent = "+filho.parent().key()+"\n";
		
		//System.out.println(mensagem+"\nRaiz = "+raiz.key());
		*/
		return filho;

	}
	
	public NodeAVL<E> rotateRight(NodeAVL<E> nodo) {
		
		NodeAVL<E> filho = (NodeAVL<E>) nodo.left();
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
		
		/*
		//System.out.println("Rotacionando a direita"+nodo.key());
		NodeAVL<E> filho = (NodeAVL<E>) nodo.left();//2
		nodo.left(filho.right());
		if (filho.hasRight()) {
			nodo.left().parent(nodo);
		}
		filho.right(nodo);
		filho.parent(nodo.parent());
		if (nodo == raiz) {
			//o unico nodo que nao tem pai eh a raiz
			raiz = filho;
		}
		nodo.parent(filho);
		
		nodo.changeHeight();
		filho.changeHeight();
		
		nodo.changeHeight();//h eh 1
		//System.out.println(nodo.key()+".height = "+nodo.height());
		filho.changeHeight();//h eh 2
		//System.out.println(filho.key()+".height = "+filho.height());
		 
		 */
		/*
		String mensagem = "";
		if(nodo.hasLeft()) {
			mensagem += nodo.key()+".Left = "+nodo.left().key()+"\n";
			mensagem += nodo.left().key()+".parent = "+nodo.left().parent().key()+"\n";
		}
		if(nodo.hasRight())
			mensagem += nodo.key()+".Right = "+nodo.right().key()+"\n";
			mensagem += nodo.right().key()+".parent = "+nodo.right().parent().key()+"\n";
		if(nodo.hasParent())
			mensagem += nodo.key()+".Parent = "+nodo.parent().key()+"\n";
			
		
		if(filho.hasLeft())
			mensagem += filho.key()+".Left = "+filho.left().key()+"\n";
			mensagem += filho.left().key()+".parent = "+filho.left().parent().key()+"\n";
		if(filho.hasRight())
			mensagem += filho.key()+".Right = "+filho.right().key()+"\n";
			mensagem += filho.right().key()+".parent = "+filho.right().parent().key()+"\n";
		if(filho.hasParent())
			mensagem += filho.key()+".Parent = "+filho.parent().key()+"\n";
		
		//System.out.println(mensagem+"Raiz = "+raiz.key()+"\n");
		*/
		return filho;
		
	}
	

	
	public int fatorBalanceamento(NodeAVL<E> nodo) {
		
		int hLeft = 0;
		int hRight = 0;
		if (nodo.left() != null)
			hLeft = ((NodeAVL<E>) nodo.left()).height();
		if (nodo.right() != null)
			hRight = ((NodeAVL<E>) nodo.right()).height();
		return (hLeft - hRight);
	}
	
	public void validaAVL(NodeAVL<E> node) {
		NodeAVL<E> nodo = node; 
		
		// se entrou após uma rotação tem que atualizar a altura dos filhos
		
		if (fatorBalanceamento(nodo) == 2) {
			if (fatorBalanceamento((NodeAVL<E>) nodo.left()) == -1) {
				nodo = rotateLeft((NodeAVL<E>) nodo.left());
			}
			nodo = rotateRight(nodo);//atualiza a referencia
			//travessiaPosfixa(nodo, new ArrayList<NodeAVL>());
			//ArrayList<NodeAVL> lista = travessiaPosfixa(nodo, new ArrayList<NodeAVL>());
		} else if (fatorBalanceamento(nodo) == -2) {
			if (fatorBalanceamento((NodeAVL<E>) nodo.right()) == 1) {
				nodo = rotateRight((NodeAVL<E>) nodo.right());
			}
			nodo = rotateLeft(nodo);
		}
		if (nodo.hasParent()) {
			if (((NodeAVL<E>) nodo.parent()).changeHeight())
				validaAVL((NodeAVL<E>) nodo.parent());
		}
		//return nodo;
	}//fim validaAVL
	
	public NodeAVL<E> raiz() {
		return raiz;
	}

	public void raiz(NodeAVL<E> raiz) {
		this.raiz = raiz;
	}
	
	public NodeAVL<E> buscaNodo(E valor) {
		
		NodeAVL<E> nodo = buscaNodo(valor, raiz);
		return nodo;
		
	}
	
	private NodeAVL<E> buscaNodo(E valor, NodeAVL<E> nodo) {
		//busca recursivamente até localizar o nodo ou descobrir que o nodo não existe
		if (nodo == null) {
			return nodo;
		} else if ((nodo.key().compareTo(valor) == 0) || nodo == null) {
			return nodo;
		} else if (valor.compareTo(nodo.key()) < 0) {
			return nodo = buscaNodo(valor, (NodeAVL<E>) nodo.left());
		} else {
			return nodo = buscaNodo(valor, (NodeAVL<E>) nodo.left());
		}
	}
	
	public boolean ehFolha(NodeAVL<E> nodo) {
		return nodo.left() == null && nodo.right() == null;
	}
	
	public void removeNodo(E valor) {
		NodeAVL<E> nodo = buscaNodo(valor);
		if (nodo == null)
			return;
			
		NodeAVL<E> pai = (NodeAVL<E>) nodo.parent();
		if (ehFolha(nodo)) {
			removeFolha(pai, nodo);
		} else if (nodo.right() == null) {
			removeFilhoUnicoLeft(pai, nodo);
		} else if (nodo.left() == null) {
			removeFilhoUnicoRight(pai, nodo);
		} else {
			//possui dois filhos
			NodeAVL<E> auxiliar = LeftDeapthSearch((NodeAVL<E>) nodo.right());
			auxiliar.left(nodo.left());
			//se pai for nulo elemento eh raiz
			if (pai == null)
				raiz = auxiliar;
			else
				pai.right(auxiliar);
		}
		
	}//fim remove nodo
	
	private void removeFolha(NodeAVL<E> pai, NodeAVL<E> nodo) {
		if (nodo == raiz) {
			raiz = null;
		} else if (pai.left() == nodo) {
			pai.left(null);
		} else if (pai.right() == nodo) {
			pai.right(null);
		} else {
			//nao localizou o pai
			System.out.println("Referencia ao pai não existe!");
		}
	}
	
	private void removeFilhoUnicoLeft(NodeAVL<E> pai, NodeAVL<E> nodo) {
		//so possui um filho a esquerda
		if (raiz == nodo)
			raiz.left(nodo.left());
		if (pai.left() == nodo) {
			pai.left(nodo.left());
		} else {
			pai.right(nodo.left());
		}
	}
	
	private void removeFilhoUnicoRight(NodeAVL<E> pai, NodeAVL<E> nodo) {
		//so possui um filho a direita
		if (raiz == nodo)
			raiz.right(nodo.right());
		if (pai.left() == nodo) {
			pai.left(nodo.right());
		} else {
			pai.right(nodo.right());
		}
	}
	
	private NodeAVL<E> LeftDeapthSearch(NodeAVL<E> nodo) {
		while (nodo.left() != null) {
			nodo = (NodeAVL<E>) nodo.left();
		}
		return nodo;
	}
	
}
