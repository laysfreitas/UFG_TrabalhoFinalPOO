
public abstract class Pessoa {
	public String nome;
	private String cpf;
	private Endere�o endere�o;
	private String telefone;
	
	public Pessoa(String nome, String cpf, Endere�o endere�o, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endere�o = endere�o;
		this.telefone = telefone;
	}
	
}
