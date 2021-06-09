package projectfinalpoo;

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
        
        public void setEndereco(Endereco endereco){
            this.endereco = endereco;
        }
	public void setTelefone(String telefone){
            this.telefone = telefone;
        }
	public String getTelefone() {
		return this.telefone;
	}
}
