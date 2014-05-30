package mensagens;

public class Menu {

	String mensagem;
	
	public Menu() {
		this.mensagem = "";
	}
	
	public void menuInicial() {
		
		mensagem = "#!#!#!#!#!#!#!#!#!#!#!#!#!\n"
				 + "#!#!Agenda de Contatos#!#!\n"
				 + "#!#!#!#!#!#!#!#!#!#!#!#!#!\n"
				 + "Selecione uma opcao:\n"
				 + "1 - Inserir contato.\n"
				 + "2 - Remover contato.\n"
				 + "3 - Consultar contato.\n"
				 + "4 - travessia e buscas.\n"
				 + "5 - Sair.";
		
		System.out.println(mensagem);
	}
	
	public void menuInserir() {
		
		mensagem = "#!#!#!#!#!#!#!#!#!#!#!#!#!\n"
				 + "#!#!#Inserir Contato:!#!#!\n"
				 + "#!#!#!#!#!#!#!#!#!#!#!#!#!\n"
				 + "Digite o nome do contato "
				 + "que deseja inserir:\n";
		
		System.out.println(mensagem);
	}
	
	public void menuInserirTelefone() {
		
		mensagem = "Digite o telefone do contato "
				 + "que deseja inserir:\n";
		
		System.out.println(mensagem);
	}
	
}
