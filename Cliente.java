public class Cliente extends Pessoa {

	public Compra compra;
	public ContaCliente conta;

	public Cliente(String nome, String cpf, Endereco endereco, String telefone, ContaCliente conta){
		super(nome, cpf, endereco, telefone);
		this.conta = conta;
	}
	public void realizaCompra(Compra compra){
		conta.adicionaCompra(compra);
	}
	
	public void clienteEConta(ContaCliente conta) {
		this.conta = conta;
	}

}