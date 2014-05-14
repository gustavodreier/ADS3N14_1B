package mensagens;

public class MensagemConsole {
	
	String mensagem; 

	public MensagemConsole() {
		this.mensagem = "";
	}
	
	public void imprimeMensagem(String mensagem) {
		this.mensagem = mensagem;
		System.out.println(mensagem);
	}
	
	
}
