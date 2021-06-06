public abstract class Pessoa {
	public String nome;
	private String cpf;
	private Endereco endereco;
	private String telefone;
	
	public Pessoa(String nome, String cpf, Endereco endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCPF() {
		return this.cpf;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
}