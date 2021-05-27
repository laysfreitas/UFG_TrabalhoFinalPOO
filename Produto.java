import java.util.Date;

public class Produto {
	public String nome;
	public String marca;
	public String categoria;
	public int numero;
	public String descrição;
	public double valor;
	public Date garantia;
	public int quantidade;  
	
	public Produto(String nome, int numero, String marca, String categoria, String descrição, double valor, Date garantia, int quantidade) {
		this.nome = nome;
		this.numero = numero;
		this.marca = marca;
		this.categoria = categoria;
		this.descrição = descrição;
		this.valor = valor;
		this.garantia = garantia;
		this.quantidade = quantidade;
	}
	
	public int getProduto() {
		return this.quantidade;
	}
	
}
