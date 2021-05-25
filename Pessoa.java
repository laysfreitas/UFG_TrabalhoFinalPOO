
public abstract class Pessoa {
	public String nome;
	private String cpf;
	private Endereço endereço;
	private String telefone;
	
	public Pessoa(String nome, String cpf, Endereço endereço, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereço = endereço;
		this.telefone = telefone;
	}
	
}
