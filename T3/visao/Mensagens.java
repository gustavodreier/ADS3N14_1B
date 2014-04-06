package visao;

public class Mensagens {
	
	public void alvejado() {
		
		System.out.println("Esta posiçãoo já foi alvejada. Favor escolha uma posiçãoo marcada com \".\"");
		
	}
	
	public void erro() {
		System.out.println("Que pena você acertou o mar!");
	}
	
	public void acertou(String navio) {
		System.out.println("Parabéns você acertou um " + navio + "!");
	}
	public void destruiu(String navio) {
		System.out.println("Parabéns você destruiu um " + navio + "!");
	}

	public void digiteLinha() {
		
		System.out.println("Digite o valor de uma linha com valores de \"A\" a \"J\":");
	}
	
	public void digiteColuna() {
		
		System.out.println("Digite o valor da coluna com valores de \"1\" a \"10\":");
	}
	public void erro1() {
		System.out.println("Valor inesperado! O jogo será encerrado!");
	}
	public void totalPontos(int pontos) {
		System.out.println("Total de pontos = " + pontos);
	}
	public void venceu(int pontos) {
		System.out.println("Parabéns você venceu!");
		System.out.println("Pontuação final = "+pontos);
	}
	public void perdeu(int pontos) {
		System.out.println("Você perdeu!");
		System.out.println("Pontuação final = "+pontos);
	}
	
}
