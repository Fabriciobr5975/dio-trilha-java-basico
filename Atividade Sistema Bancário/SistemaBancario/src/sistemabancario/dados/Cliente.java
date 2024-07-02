package sistemabancario.dados;

/**
 * @author Fabrício de Araújo Santana
 * @since 01/07/2024
 */
public class Cliente {
	// Atributos;
	private String nome;
	private int idade;
	private String endereco;
	
	// Construtor para instancia um objeto através dos atributos abaixo;
	public Cliente(String nome, int idade, String endereco) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	// Pega o nome do usuário;
	public String getNome() {
		return nome;
	}

	// Pega a idade do usuário;
	public int getIdade() {
		return idade;
	}
	
	// Pega a idade do usuário;
	public String getEndereco() {
		return endereco;
	}
}
