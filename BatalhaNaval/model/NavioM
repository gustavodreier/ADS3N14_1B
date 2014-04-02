package model;

import java.util.Random;

public class NavioM {
	
	
	
	//1 tamanho 5
	public int PortaAviões() {
		
		return 5;
	}
	
	//2 tamanho 4
	public int destroyer() {
		
		return 4;
		
	}
	
	//2 tamanho 3
	public int fragata() {
		
		return 3;
		
	}
	
	//3 tamanho 2 
	public int torpedeiros() {
		
		return 2;
		
	}
	
	//5 tamanho 1
	public int submarino() {
		
		return 1;
		
	}
	
	public int geraLinha() {
		
		Random r = new Random();
		int linha = r.nextInt(10);
		return linha;
		
	}
	
	public int geraColuna(int tamanho) {
		
		Random r = new Random();
		//posicao inicial onde deve ser inserido
		int coluna = r.nextInt(11 - tamanho);
		return coluna;
		
	}
	
	//testa se cada posição é valida para inserir
	public void insert(int tamanho, CampoM campo) {
		
		int l = geraLinha();
		int c = geraColuna(tamanho);
		
		//verifica se não há navios na posição (0 significa que não)
		for (int i = c; i < c + tamanho; i++) {
			if (campo.pegaCampo(l, i) == 1) {
				//há um navio na posição, então deve inserir em outra posição
				insert(tamanho, campo);
				
			}
			//campo.
			
		}
		
		
	}

}
