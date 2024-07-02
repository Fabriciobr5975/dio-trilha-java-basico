package sistemabancario.conta;

/**
 * @author Fabrício de Araújo Santana
 * @since 01/07/2024
 */
public abstract class Conta {
	// Atributos;
	protected int agencia;
	protected int numero;
	protected double saldo;
	private static final int AGENCIA_PADRAO = 1;
	private static int sequencial = 1;

	// Métodos abstratos;
	protected abstract void sacar(double valor); // Método para realizar o saque;

	protected abstract void depositar(double valor); // Método para realizar o deposito;

	protected abstract void transferencia(double valor, Conta contaDestino); // Método para realizar a transferência;

	protected abstract void imprimirExtratoBancario(); // Método para para imprimir o extrato da conta;

	// Construtor para iniciar os objetos Conta com a agência e um número sequência;
	public Conta() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = sequencial++;
	}
}
