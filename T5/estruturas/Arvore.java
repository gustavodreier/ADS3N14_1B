package estruturas;

import java.util.ArrayList;

public class Arvore {

	/*
	 * Infixa: sub-arvore a esquerda, raiz, sub-arvore a direita
	 * posfixa: sub-arvore esquerda, sub-arvore direita e raiz
	 * pré-fixa: raiz, sub-arvore esquerda e sub-arvore direita
	 */
	
	
	//ordem 2
	private Nodo raiz;

	public Arvore() {
		raiz = null;
	}
	
	//verifica se um nodo é folha
	public boolean ehFolha(Nodo nodo) {
		if((nodo.getLeftNodo() == null) && (nodo.getRightNodo() == null))
			return true;
		return false;
	}
	
	public void insere(Nodo nodo) {
		if (raiz == null) {
			raiz = nodo;
		} else {
			insere(raiz, nodo);
		}
	}//fim insere
	
	private void insere(Nodo arvore, Nodo nodo) {
		
		//deve ser sempre inserido pela primeira vez pela raiz
		
		//se posicao onde esta tentando inserir esta vazia insere
		if (raiz == null) {
			arvore = nodo;
			//se nodo for menor
		} else if (nodo.getValor().compareToIgnoreCase(arvore.getValor()) < 0) {
			//passa a posição da esquerda para tentar inserir
			//se estiver vazia insere e atualiza a referencia antes de inserir
			//se nao tenta inserir a esquerda
			if (arvore.getLeftNodo() == null)
				arvore.setLeftNodo(nodo);
			else
				insere(arvore.getLeftNodo(),nodo);
		} else {
			//mesma ideia para de cima só que a direita
			if (arvore.getRightNodo() == null) 
				arvore.setRightNodo(nodo);
			else
				insere(arvore.getRightNodo(),nodo);
		}
	}//fim insere
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	/*
	public ArrayList<Nodo> travessiaPrefixa() {
		ArrayList<Nodo> saida = new ArrayList<Nodo>();		
		
		if (raiz == null) {
			return saida;
		}
		ArrayList<Nodo> pilha = new ArrayList<Nodo>();
		Nodo nodo = raiz;
		
		do {
			if (nodo == null) {//desempilha o nodo. O nodo a ser comparado é igual ao nodo desempilhado
				nodo = pilha.get(pilha.size()-1);
				pilha.remove(pilha.size()-1);
			} else {
				//procura elementos da esquerda até não ter mais elementos
				while (nodo.getLeftNodo() != null) {
					pilha.add(nodo);
					nodo = nodo.getLeftNodo();
				}
			}//fim else
				saida.add(nodo);
			if (nodo.getRightNodo() != null) {
				//se tiver elementos a direita irá procurar todos os elemntos a esquerda deste 
				nodo = nodo.getRightNodo();
				continue;
			} else {
				//nodos desempilhados nao devem mais ser comparados
				nodo = null;
			}
		} while (!pilha.isEmpty());
		
		return saida;
		
		
	}//fim travessia prefixa
	*/
	
	public ArrayList<Nodo> buscaLargura() {
		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		ArrayList<Nodo> saida = new ArrayList<Nodo>();
		Nodo nodo = raiz;
		
		if (raiz == null) {
			return saida;
		} else {
			do {//faz...enquanto a lista não esta vazia
				//se não tiver nodo...
				if(nodo == null) {
					//...recebe o proximo nodo da lista
					nodo = lista.remove(0);
				}
				//adiciona o nodo a saida
				saida.add(nodo);
				//adiciona os nodos a lista
				if (nodo.getLeftNodo() != null) 
					lista.add(nodo.getLeftNodo());
				if (nodo.getRightNodo() != null) 
					lista.add(nodo.getRightNodo());
				//e zera o nodo para que recebe o próximo da lista
				nodo = null;
			} while (!lista.isEmpty());
		}
		
		
		return saida;
	}//fim travessia infixa
	
	public ArrayList<Nodo> travessiaInfixa() {
		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		
		if (raiz == null)
			return lista;
		
		travessiaInfixa(raiz, lista);
		
		return lista;
	}//fim travessiaInfixa
	
	private ArrayList<Nodo> travessiaInfixa(Nodo nodo, ArrayList<Nodo> lista) {
	
		if (nodo == null)
			return lista;
		
		lista.add(nodo);
		travessiaInfixa(nodo.getLeftNodo(), lista);
		travessiaInfixa(nodo.getRightNodo(), lista);
		return lista;
	}//fim travessiaInfixa
	
	public ArrayList<Nodo> travessiaPrefixa() {
		
		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		
		if (raiz == null)
			return lista;
		
		travessiaPrefixa(raiz, lista);
		
		return lista;
		
	}//fim travessiaPrefixa
	
	private ArrayList<Nodo> travessiaPrefixa(Nodo nodo, ArrayList<Nodo> lista) {
		
		if (nodo == null)
			return lista;
		
		travessiaPrefixa(nodo.getLeftNodo(), lista);
		lista.add(nodo);
		travessiaPrefixa(nodo.getRightNodo(), lista);
		
		return lista;
	}//fim travessia Prefixa
	
	
	public ArrayList<Nodo> travessiaPosfixa() {
		
		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		
		if (raiz == null)
			return lista;
		
		travessiaPosfixa(raiz, lista);
		
		return lista;
		
	}//fim travessiaPosfixa
	
	private ArrayList<Nodo> travessiaPosfixa(Nodo nodo, ArrayList<Nodo> lista) {
		
		if (nodo == null)
			return lista;
		
		travessiaPosfixa(nodo.getRightNodo(), lista);
		travessiaPosfixa(nodo.getLeftNodo(), lista);
		lista.add(nodo);
		
		return lista;
	}//fim travessia Posfixa
	
	public ArrayList<Nodo> buscaProfundidade() {
		//Depth First Search
		ArrayList<Nodo> pilha = new ArrayList<Nodo>();
		ArrayList<Nodo> saida = new ArrayList<Nodo>();
		Nodo nodo;
		pilha.add(raiz);
		while(!pilha.isEmpty()) {
			nodo = pilha.remove((pilha.size()-1));
			/*
			if (nodo.getValor().equalsIgnoreCase(valor)) {
				return nodo;
			}
			*/
			saida.add(nodo);
			if (nodo.getLeftNodo() != null)
				pilha.add(nodo.getLeftNodo());
			if (nodo.getRightNodo() != null)
				pilha.add(nodo.getRightNodo());
		}
		
		return saida;
	}//fim busca profundidade
	
	public Nodo buscaNodo(String valor) {
		
		Nodo nodo = buscaNodo(valor, raiz);
		return nodo;
		
	}
	
	private Nodo buscaNodo(String valor, Nodo nodo) {
		//busca recursivamente até localizar o nodo ou descobrir que o nodo não existe
		if (nodo == null) {
			return nodo;
		} else if (nodo.getValor().equalsIgnoreCase(valor) || nodo == null) {
			return nodo;
		} else if (valor.compareToIgnoreCase(nodo.getValor()) < 0) {
			return nodo = buscaNodo(valor, nodo.getLeftNodo());
		} else {
			return nodo = buscaNodo(valor, nodo.getRightNodo());
		}
	}
	
	public Nodo buscaPai(String valor) {
		if (raiz == null)
			return null;
		else if (raiz.getValor().equalsIgnoreCase(valor))
			return null;
		else
			return buscaPai(valor, raiz);
	}
	
	private Nodo buscaPai(String valor, Nodo nodo) {
		
		if (nodo == null)
			return null;
		else if (valor.compareToIgnoreCase(nodo.getValor()) < 0) {
			if (nodo.getLeftNodo() == null)
				return null;
			else if (valor.equalsIgnoreCase(nodo.getLeftNodo().getValor()))
				return nodo;
			else
				return buscaPai(valor, nodo.getLeftNodo());
		} else if (valor.compareToIgnoreCase(nodo.getValor()) > 0) {
			if (nodo.getRightNodo() == null) 
				return null;
			else if (valor.equalsIgnoreCase(nodo.getRightNodo().getValor()))
				return nodo;
			else
				return nodo;
		}
		return nodo;
	}//fim buscaPai
	
	public boolean removeNodo(String valor) {
		Nodo nodo = buscaNodo(valor);
		Nodo pai = buscaPai(valor);
		
		if (nodo == null)
			return false;
		
		if (ehFolha(nodo)) {
			removeFolha(pai, nodo);
		} else if (nodo.getRightNodo() == null) {
			removeFilhoUnicoLeft(pai, nodo);
		} else if (nodo.getLeftNodo() == null) {
			removeFilhoUnicoRight(pai, nodo);
		} else {
			//possui dois filhos
			Nodo auxiliar = LeftDeapthSearch(nodo.getRightNodo());
			auxiliar.setLeftNodo(nodo.getLeftNodo());
			//se pai for nulo elemento eh raiz
			if (pai == null)
				raiz = auxiliar;
			else
				pai.setRightNodo(auxiliar);
		}
		return true;
		
	}//fim remove nodo
	
	private void removeFolha(Nodo pai, Nodo nodo) {
		if (nodo == raiz) {
			raiz = null;
		} else if (pai.getLeftNodo() == nodo) {
			pai.setLeftNodo(null);
		} else if (pai.getRightNodo() == nodo) {
			pai.setRightNodo(null);
		} else {
			//nao localizou o pai
			System.out.println("Referencia ao pai não existe!");
		}
	}
	
	private void removeFilhoUnicoLeft(Nodo pai, Nodo nodo) {
		//so possui um filho a esquerda
		if (raiz == nodo)
			raiz.setLeftNodo(nodo.getLeftNodo());
		if (pai.getLeftNodo() == nodo) {
			pai.setLeftNodo(nodo.getLeftNodo());
		} else {
			pai.setRightNodo(nodo.getLeftNodo());
		}
	}
	
	private void removeFilhoUnicoRight(Nodo pai, Nodo nodo) {
		//so possui um filho a direita
		if (raiz == nodo)
			raiz.setRightNodo(nodo.getRightNodo());
		if (pai.getLeftNodo() == nodo) {
			pai.setLeftNodo(nodo.getRightNodo());
		} else {
			pai.setRightNodo(nodo.getRightNodo());
		}
	}
	
	private Nodo LeftDeapthSearch(Nodo nodo) {
		while (nodo.getLeftNodo() != null) {
			nodo = nodo.getLeftNodo();
		}
		return nodo;
	}
	
}
