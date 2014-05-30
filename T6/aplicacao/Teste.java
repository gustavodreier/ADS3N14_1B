package aplicacao;


import java.util.ArrayList;

import estrutura.node.*;
import estrutura.tree.*;

public class Teste {

	public static <E> void main(String[] args) {
		
		AVLTree<String> avlTree = new AVLTree<>();
		ArvoreRB<String> rbTree = new ArvoreRB<>();
		
		avlTree.insert(new NodeAVL<String>("1"));
		avlTree.insert(new NodeAVL<String>("2"));
		avlTree.insert(new NodeAVL<String>("3"));
		avlTree.insert(new NodeAVL<String>("4"));
		avlTree.insert(new NodeAVL<String>("5"));
		avlTree.removeNodo("1");

		
		rbTree.insert(new NodeRB<String>("1"));
		rbTree.insert(new NodeRB<String>("2"));
		rbTree.insert(new NodeRB<String>("3"));
		rbTree.insert(new NodeRB<String>("4"));
		rbTree.insert(new NodeRB<String>("5"));
		rbTree.insert(new NodeRB<String>("6"));
		
		
		ArrayList<NodeAVL<String>> listaAVL = avlTree.travessiaPosfixa();
		ArrayList<NodeRB<String>> listaRB = rbTree.travessiaPosfixa();
		
		for (NodeAVL<String> nodeAVL : listaAVL) {
			System.out.println(nodeAVL.key());
		}
		System.out.println();
		for (NodeRB<String> nodeRB : listaRB) {
			System.out.println(nodeRB.key());
		}
		
		//System.out.println(rbTree.raiz().key());
	}

}
