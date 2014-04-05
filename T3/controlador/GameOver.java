package controlador;

import modelo.CampoDados;
import modelo.Pontos;

public class GameOver {

	private boolean fim = false;
	
	public boolean isGameOver(CampoDados campo, Pontos pontos) {
		
		if (campo.getObjetosCampo() == 0) {
			fim = true;
			System.out.println("Parabéns você venceu!");
			System.exit(0);
		} else if (pontos.getPontos() == 0) {
			System.out.println("Você perdeu!");
			System.exit(0);
		}
		return fim;
	}
	
}
