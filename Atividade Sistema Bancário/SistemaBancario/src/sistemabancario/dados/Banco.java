package sistemabancario.dados;

/**
 * @author Fabrício de Araújo Santana
 * @since 01/07/2024
 */
public enum Banco {
	// Valores instanciados;
	ITAU("Itaú"),
	NUBANK("Nubank"),
	SANTANDER("Santander"),
	BRADESCO("Bradesco"),
	CAIXA_ECONOMICA_FEDERAL("Caixa"),
	PAGBANK("PagBank"),
	C6BANK("C6 Bank");
	
	// Atributo
	private String nome;
	
	// Construtor para criar os enum com o nome;
	private Banco(String nome) {
		this.nome = nome;
	}
	
	// Pegar o nome salvo do enum;
	public String getNome() {
		return nome;
	}
}
