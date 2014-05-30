package erros;

import java.util.Scanner;

import mensagens.MensagemConsole;

public class Erro {
	
	public int scannerInt(Scanner entrada) {
		int opcao;
		try {
			opcao = entrada.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			MensagemConsole mc = new MensagemConsole();
			mc.imprimeMensagem("Digite apenas valores inteiros.");
			entrada.nextLine();
			opcao = scannerInt(entrada);
		}
		return opcao;
	}//fim Scanner int
	
	public String scannerString(Scanner entrada) {
		String string;
		try {
			string = entrada.next();
		} catch (Exception e) {
			// TODO: handle exception
			MensagemConsole mc = new MensagemConsole();
			mc.imprimeMensagem("Valor invalido, tente novamente!.");
			entrada.nextLine();
			string = scannerString(entrada);
		}
		return string;
	}//fim Scanner int

}
