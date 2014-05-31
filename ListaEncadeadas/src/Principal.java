import java.io.IOException;


public class Principal {

	public static void main(String[] args) throws IOException {
		
		/*
		1. Implementar uma aplicação de lista telefônica.!
		2. A aplicação deve, ao ser inicializada ler um arquivo do disco com os nomes e
		telefones dos contatos da agenda.!
		3. Deve ser permitido ao usuário inserir e remover novos contatos.!
		4. Novos contatos devem ser gravados sempre no final do arquivo de dados.!
		5. Para navegar na lista de contatos, o usuário pode:!
			5.1. Digitar a primeira letra do nome.!
			5.2. Avançar para o próximo contato.!
			5.3. Voltar para o contato anterior.!
		6. A lista de contatos deve ser exibida em ordem alfabética para o usuário.!
		7. Não podem ser utilizadas classes do pacote java.util, com exceção da classe
		java.util.Scanner.!
		8. O arquivo de dados deve conter pelo menos 20 registros.!
		9. O sistema não deve impor um número máximo de registros, no entanto, deve se
		proteger de problemas como “falta de memória”.!
		10. Divida as classes em pacotes lógicos (estruturas, modelo, programa, aplicações, etc).!
		*/
		
		Arquivo file = new Arquivo();
		file.teste();
		
		file.manipulaArquivo();
		
		
		
		
		
	}

}
