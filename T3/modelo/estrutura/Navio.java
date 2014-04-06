package modelo.estrutura;
import modelo.CampoDados;

abstract public class Navio extends Objeto{

	protected int tamanho;
	
	protected int refLinha;
	
	protected int refColuna;
	
	public int getTamanho() {
		return this.tamanho;
	}
	public int getRefLinha() {
		return refLinha;
	}
	public int getRefColuna() {
		return refColuna;
	}
	public void setRefLinha(int linha) {
		this.refLinha = linha;
	}
	public void setRefColuna(int coluna) {
		this.refColuna = coluna;
	}
	
	public boolean estaDestruido(CampoDados campo) {
		for (int i = refColuna; i < (refColuna + tamanho); i++) {
			//se existe pelo menos uma posição que não foi alvejada
			//o navio não foi destruido
			if(campo.getCampo(refLinha, i).getValor() != -1)
				return false;
		}
		
		return true;
		
	}//fim estaDestruido
	
}
