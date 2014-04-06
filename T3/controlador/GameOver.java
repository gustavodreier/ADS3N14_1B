package controlador;

import visao.Mensagens;
import modelo.CampoDados;
import modelo.Pontos;

public class GameOver {

	private boolean fim = false;
	
	public boolean isGameOver(CampoDados campo, Pontos pontos) {
		Mensagens m = new Mensagens();
		if (campo.getObjetosCampo() == 0) {
			fim = true;
			m.venceu(pontos.getPontos());
			//System.exit(0);
		} else if (pontos.getPontos() == 0) {
			fim = true;
			m.perdeu(pontos.getPontos());
			//System.exit(0);
		}
		return fim;
	}
	
}
