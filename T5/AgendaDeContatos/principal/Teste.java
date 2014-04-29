package principal;

import java.util.ArrayList;

import dados.*;
import estruturas.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ler arquivo de texto com os contatos
		
		//gerar arvore Binaria de pesquisa ordenada pelo nome dos contatos
		//obs: ordenada pelo nome dos contatos na realizade significa
		//que o valor da busca eh nome
		
		//"menu de opções" com add contato, del contato, procurar dados dos contatos
		
		//mostrar numero de comparações para localizar um contato
		
		//implementar as seguintes formas de busca:
		//Travessia prefixa
		//Travessia infixa
		//Travessia posfixa
		//Busca em largura
		//Busca em profundidade
		
		//A cada insercao, mostrar a altura do nod raiz
		//e o numero elementos existentes na arvore
		
		//ao encerrar o programa salvar base de dados baseado nos dados existentes na arvore
		
		Arvore arvore = new Arvore();
		
		Pessoa maria = new Pessoa("maria", 99999999);
		Pessoa joao = new Pessoa("joao", 88888888);
		Pessoa andre = new Pessoa("andre", 77777777);
		Pessoa carlos = new Pessoa("carlos", 77777777);
		
		//arvore.travessiaPrefixa();
		
		arvore.insere(new Nodo(maria));
		arvore.insere(new Nodo(joao));
		arvore.insere(new Nodo(andre));
		arvore.insere(new Nodo(carlos));
		
		if (arvore.ehFolha(arvore.getRaiz()) == true) {
			System.out.println("falha na Matrix");
		} else {
			System.out.println("Possui objetos");
		}
		
		//arvore.removeNodo(arvore.getRaiz().getLeftNodo().getLeftNodo());
		/*
		System.out.println(arvore.getRaiz().getLeftNodo().getValor());
		
		if(arvore.getRaiz().getLeftNodo().getLeftNodo() == null) {
			System.out.println("Nodo removido com sucesso!");
		} else
			System.out.println(arvore.getRaiz().getLeftNodo().getLeftNodo().getValor());
		*/
		
		//arvore.travessiaPrefixa();
		
		ArrayList<Nodo> largura = new ArrayList<Nodo>();
		ArrayList<Nodo> travInfixa = new ArrayList<Nodo>();
		ArrayList<Nodo> travPrefixa = new ArrayList<Nodo>();
		ArrayList<Nodo> travPosfixa = new ArrayList<Nodo>();
		largura = arvore.buscaLargura();
		travInfixa = arvore.travessiaInfixa();
		travPrefixa = arvore.travessiaPrefixa();
		travPosfixa = arvore.travessiaPosfixa();
		
		String saidaIn = "Travessia Infixa:\n";
		String saidaPre = "Travessia Prefixa:\n";
		String saidaPos = "Travessia Posfixa:\n";
		String saidaLarg = "Busca em largura:\n";
		
		for (int i = 0; i < travInfixa.size(); i++) {
			saidaIn += " "+travInfixa.get(i).getValor();
			saidaPre += " "+travPrefixa.get(i).getValor();
			saidaPos += " "+travPosfixa.get(i).getValor();
			saidaLarg += " "+largura.get(i).getValor();
		}
		
		System.out.println(saidaIn);
		System.out.println(saidaPre);
		System.out.println(saidaPos);
		System.out.println(saidaLarg);
		
		
		Nodo test = arvore.buscaProfundidade("maria");
		
		System.out.println("nome = "+test.getValor());
	}

}
