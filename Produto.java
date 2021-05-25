import java.util.Date;

public class Produto {
	public String nome;
	public String marca;
	public String categoria;
	public int numero;
	public String descrição;
	public double valor;
	public Date garantia;
	
	public Produto(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
}
