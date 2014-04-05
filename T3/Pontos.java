package modelo;

public class Pontos {
	
	int pontos;
	
	public Pontos() {
		this.pontos = 15;
	}
	
	public void disparo() {
		this.pontos -= 1;
	}
	
	public void acerto() {
		this.pontos += 3;
	}

	public void destroi() {
		this.pontos += 5;
	}
	
	public int getPontos() {
		return pontos;
	}
	
}
