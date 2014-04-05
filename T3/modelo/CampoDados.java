package modelo;

import modelo.estrutura.*;
import java.util.Random;

public class CampoDados {
	
	private Objeto[][] campo = new Objeto[10][10];
	private int objetosCampo;
	
	public CampoDados() {
		//inicia um campo preenchido por mar
		objetosCampo = 0;
		Mar mar = new Mar();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				campo[i][j] = mar;
			}
		}
		
	}
	
	public Objeto getCampo(int linha, int coluna) {
		return campo[linha][coluna];
	}
	
	public boolean insereNavio(Navio navio) {
		//verifica o tamanho do navio e verifica se pode inserir
		//caso haja algum navio na posicao retorna falso (ja ocupada)
		//(ou seja nao pode inserir nesta posicao)
		
		Random rLinha = new Random();
		int linha = rLinha.nextInt(10);
		Random rColuna = new Random(10);
		int coluna = rColuna.nextInt(11 - navio.getTamanho());
		//testa para cada valor da coluna se pode inserir
		//pode inserir se tiver mar na posicao (identificado por valor = 0)
		for (int i = coluna; i < coluna+navio.getTamanho(); i++) {
			if(campo[linha][i].getValor() != 0) {
				return false;
			}	
		}
		//se não havia navios entao insere o navio nas posições
		for (int i = coluna; i < coluna+navio.getTamanho(); i++) {
			campo[linha][i] = navio;
		}
		
		return true;
	}//fim insereNavio
	
	public void insereAlvejado(int linha, int coluna) {
		campo[linha][coluna] = new Alvejado();
	}
	
	public int getObjetosCampo() {
		return objetosCampo;
	}
	
	public void addObjetosCampo(int valor) {
		this.objetosCampo += valor;
	}
	
}
