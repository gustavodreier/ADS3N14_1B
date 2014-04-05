package controlador;

public class Jogada {
	
	private int linha;
	private int coluna;
	
	public void novaJogada(char linha, int coluna) {
		
		this.linha = converteLinha(linha);
		this.coluna = converteColuna(coluna);
		
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
		
	public int converteLinha(char linha) {
		switch (linha) {
		case 'a':
		case 'A':
			return 0;
		case 'b':
		case 'B':
			return 1;
		case 'c':
		case 'C':
			return 2;
		case 'd':
		case 'D':
			return  3;
		case 'e':
		case 'E':
			return 4;
		case 'f':
		case 'F':
			return 5;
		case 'g':
		case 'G':
			return 6;
		case 'h':
		case 'H':
			return 7;
		case 'i':
		case 'I':
			return 8;
		case 'j':
		case 'J':
			return 9;
		default:
			System.out.println("Valor invalido o programa será encerrado.");
			System.exit(0);
		return -1;
		}//fim switch
		
		
	
	}//fim converte coluna
	
	public int converteColuna(int coluna) {
		return (coluna - 1);
	}//fim converte linha
	
}
