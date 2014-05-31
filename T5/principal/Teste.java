package principal;

import mensagens.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dados.*;
import erros.Erro;
import estruturas.*;

public class Teste {

	public static void main(String[] args) throws IOException {
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
		/*
		Arvore arvore = new Arvore();
		
		Pessoa maria = new Pessoa("maria", 99999999);
		Pessoa joao = new Pessoa("joao", 88888888);
		Pessoa andre = new Pessoa("andre", 77777777);
		Pessoa carlos = new Pessoa("carlos", 77777777);
		Pessoa vinicius = new Pessoa("Vinicius", 83294923);
		
		//arvore.travessiaPrefixa();
		
		arvore.insere(new Nodo(maria));
		arvore.insere(new Nodo(joao));
		arvore.insere(new Nodo(andre));
		arvore.insere(new Nodo(carlos));
		arvore.insere(new Nodo(vinicius));
		
		if (arvore.ehFolha(arvore.getRaiz()) == true) {
			System.out.println("falha na Matrix");
		} else {
			System.out.println("Possui objetos");
		}
		*/
		//arvore.removeNodo(arvore.getRaiz().getLeftNodo().getLeftNodo());
		/*
		System.out.println(arvore.getRaiz().getLeftNodo().getValor());
		
		if(arvore.getRaiz().getLeftNodo().getLeftNodo() == null) {
			System.out.println("Nodo removido com sucesso!");
		} else
			System.out.println(arvore.getRaiz().getLeftNodo().getLeftNodo().getValor());
		*/
		
		//arvore.travessiaPrefixa();
		/*
		ArrayList<Nodo> largura = new ArrayList<Nodo>();
		ArrayList<Nodo> travInfixa = new ArrayList<Nodo>();
		ArrayList<Nodo> travPrefixa = new ArrayList<Nodo>();
		ArrayList<Nodo> travPosfixa = new ArrayList<Nodo>();
		ArrayList<Nodo> buscaProfundidade = new ArrayList<Nodo>();
		
		//arvore.removeNodo("carlos");
		
		
		largura = arvore.buscaLargura();
		travInfixa = arvore.travessiaInfixa();
		travPrefixa = arvore.travessiaPrefixa();
		travPosfixa = arvore.travessiaPosfixa();
		buscaProfundidade = arvore.buscaProfundidade();
		
		
		
		String saidaIn = "Travessia Infixa:\n";
		String saidaPre = "Travessia Prefixa:\n";
		String saidaPos = "Travessia Posfixa:\n";
		String saidaLarg = "Busca em largura:\n";
		String saidaBProf = "Busca em profundidade:\n";
		
		for (int i = 0; i < travInfixa.size(); i++) {
			saidaIn += " "+travInfixa.get(i).getValor();
			saidaPre += " "+travPrefixa.get(i).getValor();
			saidaPos += " "+travPosfixa.get(i).getValor();
			saidaLarg += " "+largura.get(i).getValor();
			saidaBProf += " "+buscaProfundidade.get(i).getValor();
		}
		
		System.out.println(saidaIn);
		System.out.println(saidaPre);
		System.out.println(saidaPos);
		System.out.println(saidaLarg);
		System.out.println(saidaBProf);
		
		
		//Nodo test = arvore.buscaProfundidade("maria");
		
		//System.out.println("nome = "+test.getValor());
		
		Nodo bla = arvore.buscaPai("andre");
		if (bla == null) {
			System.out.println("Não localizado");
		}else {
			System.out.println("nome = "+bla.getValor());
		}
		*/
		
		Pessoa p;
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String aux = "";
		Menu menu = new Menu();
		MensagemConsole mc = new MensagemConsole();
		Arvore arvore = new Arvore();
		Nodo nodoAux;
		Erro trataErro = new Erro();
		
		
		ArrayList<Nodo> travessia = new ArrayList<Nodo>();
		

		File arquivo = new File( "contatos.txt" );
		if (!arquivo.exists())
			arquivo.createNewFile();
		
		  FileReader fr = new FileReader(arquivo);
		  BufferedReader br = new BufferedReader(fr);
		
		while (br.ready()) {
		    //lê o nome
		    aux = br.readLine();
		    p = new Pessoa(aux);
		    // lê o telefone
		    aux = br.readLine();
		    p.setTelefone(aux);
		    //insere na arvore
		    arvore.insere(new Nodo(p));
		  }
		br.close();
		fr.close();
		
		//Arquivo arquivo = new Arquivo();
		
		//arquivo.open();
	
		while(true) {
			menu.menuInicial();
			opcao = trataErro.scannerInt(entrada);
			
			switch (opcao) {
			case 1:
				menu.menuInserir();
				aux = entrada.next();
				
				p = new Pessoa(aux);
				menu.menuInserirTelefone();
				p.setTelefone(entrada.next());
				arvore.insere(new Nodo(p));
				
				mc.imprimeMensagem("Pessoa inserida com sucesso:\n" +
						"Nome: "+p.getNome()+"\n" +
								"Telefone: "+p.getTelefone());
				break;
			case 2:
				mc.imprimeMensagem("Digite o nome do contato\n" +
						"que deseja remover:");
				aux = entrada.next();
				if (arvore.removeNodo(aux))
					mc.imprimeMensagem("Contato removido com sucesso:");
				else
					mc.imprimeMensagem("Contato não localizado.");
				break;
			case 3:
				mc.imprimeMensagem("Digite o nome do contato\n" +
						" que deseja procurar:");
				aux = entrada.next();
				nodoAux = arvore.buscaNodo(aux); 
				if ( nodoAux == null) 
					mc.imprimeMensagem("Nodo não localizado.");
				else
					mc.imprimeMensagem("Nome: "+nodoAux.getDados().getNome()+"\n" +
							"Telefone: "+nodoAux.getDados().getTelefone());
				break;
			case 4:
				mc.imprimeMensagem("Escolha qual tipo de travessia\n" +
						"ou  busca deseja efetuar:\n" +
						"1 - Travessia infixa." +
						"2 - Travessia prefixa.\n" +
						"3 - Travessia posfixa.\n" +
						"4 - Busca em largura+\n" +
						"5 - Busca em profundidade.");

				opcao = trataErro.scannerInt(entrada);
				
				switch (opcao) {
				case 1:
					travessia = arvore.travessiaInfixa();
					aux = "Travessia Infixa.\n";
					break;
				case 2:
					travessia = arvore.travessiaPrefixa();
					aux = "Travessia Prefixa.\n";
					break;
				case 3:
					travessia = arvore.travessiaPosfixa();
					aux = "Travessia Posfixa.\n";
					break;
				case 4:
					travessia = arvore.buscaProfundidade();
					aux = "Busca em largura.\n";
					break;
				case 5:
					travessia = arvore.buscaLargura();
					aux = "Busca em profundidade.\n";
					break;
				default:
					mc.imprimeMensagem("Opcao invalida, o sistema será encerado.");
					System.exit(0);
					break;
				}
				
				aux += "Nome,\t Telefone\n";
				
				for (int i = 0; i < travessia.size(); i++) {
					aux += travessia.get(i).getValor()+", "+travessia.get(i).getDados().getTelefone()+"\n";
				}
				
				mc.imprimeMensagem(aux);
				break;
			case 5:
				mc.imprimeMensagem("Salvando arquivo...");
				travessia = arvore.travessiaInfixa();
				
				//arquivo.delete();
				
				//arquivo.createNewFile();
				
				FileWriter fw = new FileWriter(arquivo);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int i = 0; i < travessia.size(); i++) {
					bw.write(travessia.get(i).getValor());
					bw.newLine();
					bw.write(travessia.get(i).getDados().getTelefone());
					//se não for a ultima linha
					if (!(i == travessia.size() - 1))
						bw.newLine();
				}
				
				bw.close();
				fw.close();
				
				mc.imprimeMensagem("...arquivo salvo com sucesso.");
				
				System.exit(0);
				
			default:
				System.exit(0);
				break;
		}
		
		}
		
	}

	/*
	public final int trataEntrada(Scanner entrada) {
		int opcao;
		try {
			opcao = entrada.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Digite apenas valores inteiros.");
			opcao = trataEntrada(entrada);
		}
		
		return opcao;
	}
	*/
	
}
