import java.io.IOException;


public class Principal {

	public static void main(String[] args) throws IOException {
		
		/*
		1. Implementar uma aplica��o de lista telef�nica.!
		2. A aplica��o deve, ao ser inicializada ler um arquivo do disco com os nomes e
		telefones dos contatos da agenda.!
		3. Deve ser permitido ao usu�rio inserir e remover novos contatos.!
		4. Novos contatos devem ser gravados sempre no final do arquivo de dados.!
		5. Para navegar na lista de contatos, o usu�rio pode:!
			5.1. Digitar a primeira letra do nome.!
			5.2. Avan�ar para o pr�ximo contato.!
			5.3. Voltar para o contato anterior.!
		6. A lista de contatos deve ser exibida em ordem alfab�tica para o usu�rio.!
		7. N�o podem ser utilizadas classes do pacote java.util, com exce��o da classe
		java.util.Scanner.!
		8. O arquivo de dados deve conter pelo menos 20 registros.!
		9. O sistema n�o deve impor um n�mero m�ximo de registros, no entanto, deve se
		proteger de problemas como �falta de mem�ria�.!
		10. Divida as classes em pacotes l�gicos (estruturas, modelo, programa, aplica��es, etc).!
		*/
		
		Arquivo file = new Arquivo();
		file.teste();
		
		file.manipulaArquivo();
		
		
		
		
		
	}

}
