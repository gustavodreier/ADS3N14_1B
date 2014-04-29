package dados;

public class Pessoa {
	
	private String nome;
	private int telefone;
	
	public Pessoa(String nome, int telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public int getTelefone() {
		return telefone;
	}

}
