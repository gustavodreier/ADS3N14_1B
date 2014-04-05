package visao;

public class VisaoCampo {
	
	// "." indica posicao livre
	// "O" indica um navio
	// "-" indica mar
	
	char campo[][] = new char[10][10];
	
	public VisaoCampo() {
		
		//inicia com todos campos livres
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				
				campo[i][j] = '.';
				
			}
		}
	}
	
	public void imprimeCampo() {
		
		String saida = "\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\n\n";
		
		//para cada linha
		for (int i = 0; i < 10; i++) {
			
			switch (i) {
			case 0:
				saida += "A\t";
				break;
			case 1:
				saida += "B\t";
				break;
			case 2:
				saida += "C\t";
				break;
			case 3:
				saida += "D\t";
				break;
			case 4:
				saida += "E\t";
				break;
			case 5:
				saida += "F\t";
				break;
			case 6:
				saida += "G\t";
				break;
			case 7:
				saida += "H\t";
				break;
			case 8:
				saida += "I\t";
				break;
			case 9:
				saida += "J\t";
				break;
			default:
				System.out.println("Errou!");
				break;
			}
			
			//para cada coluna j da linha i
			for (int j = 0; j < 10; j++) {
			
				if (j != 9) {
					saida += campo[i][j]+"\t";
				} else {
					saida += campo[i][j]+"\n\n";
				}

			}
			
		}
		
		System.out.print(saida);
		
		
	}//fim imprime 
	

	public void alteraCampo(char dado, int linha, int coluna) {
		
		campo[linha][coluna] = dado;
		
	}
}
