package sistemabancario.conta;

import sistemabancario.dados.Banco;
import sistemabancario.dados.Cliente;

/**
 * @author Fabrício de Araújo Santana
 * @since 01/07/2024
 */
public class ContaPoupanca extends Conta{
	// Objeto do tipo Cliente;
	Cliente usuario;
	
	// Construtor padrão;
	public ContaPoupanca() {
		
	}
	
	// Construtor para usado na criação da conta Poupança do usuário;
	public ContaPoupanca(double saldo, Cliente usuario) {
		this.saldo = saldo;
		this.usuario = usuario;
	}
	
	// Método para sacar o valor da conta;
	@Override
	public void sacar(double valor) {
		saldo -= valor;
		
	}

	// Método para realizar o deposito de novos valores na conta;
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	// Método para realizar a tranferência de uma conta para outra;
	@Override
	public void transferencia(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}

	// Método para imprimir o extrato;
	@Override
	public void imprimirExtratoBancario() {
		System.out.println("*---*---*---* Extrato Conta Poupança *---*---*---*");
		System.out.printf("Cliente: %s idade: %d%n", usuario.getNome(), usuario.getIdade());
		System.out.println("Banco: %s%n" + Banco.ITAU.getNome());
		System.out.printf("Número da conta: %d%n", this.numero);
		System.out.printf("Agência: %d%n", this.agencia);
		System.out.printf("Valor em conta: $%.2f%n", saldo);
		System.out.println("*----*----*----*----*----*----*----*----*----*----*");
	}
	
	
}
