package model;

public class Pontos {

	private int pontos;
	
	public Pontos() {
		pontos = 15;
	}
	
	public void addPontos() {
		
		pontos += 3;
		
	}
	
	public void destAddPontos() {
		pontos += 5;
		
	}
	
	public void remPontos() {
		
		pontos -= 1;
		
	}
	
	public int getPontos() {
		
		return pontos;
		
	}
	
}
