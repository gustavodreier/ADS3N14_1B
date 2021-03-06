import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {

	private File arquivo = new File( "listaDeContatos.txt");
	
	public void teste() throws IOException {
		//testa se arquivo existe, senao existe permite a criacao do arquivo ou encerra
		if (arquivo.exists()) {
			//System.out.println("arquivo existe!");
		} else {
			System.out.println("arquivo n�o existe. Deseja criar um novo arquivo?"
					+ "\nDigite 's' para sim ou outro valor para encerrar.");
			Scanner leitor = new Scanner(System.in);
			String resposta = leitor.next();
			leitor.close();
			if (resposta.equalsIgnoreCase("s")) {
			
				arquivo.createNewFile();
			} else {
				System.out.println("O programa ser� encerrado.");
				System.exit(0);
			}
		
		}//fim if
		
	}//fim teste
	
	public void manipulaArquivo() throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileReader("listaDeContatos.txt"));
		
		String saida = "nome:\t\ttelefone: \n";
		
		while (sc.hasNextLine()) {
			saida += sc.nextLine() + "\t";
			saida += sc.nextLine() + "\n";
			
		}
		sc.close();
		System.out.print(saida);
		
	}//fim manipula arquivo
	
	
	
}//fim classe arquivo
