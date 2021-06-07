public class Cliente extends Pessoa {
      
	public ContaCliente conta;

	/* Construtor da classe Cliente*/
	public Cliente(String nome, String cpf, Endereco endereco, String telefone){
		super(nome, cpf, endereco, telefone);
	}
	
	/* Método que chama o método da classe ContaCliente 
	 * para vincular a compra na conta do cliente */
	public void realizaCompra(Compra compra){
		this.conta.adicionaCompra(compra);
	}
	
}
