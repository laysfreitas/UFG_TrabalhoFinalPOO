import java.util.Date;

public class Produto {
	public String nome;
	public String marca;
	public String categoria;
	public int codigo;
	public String descrição;
	public double valor;
	public Date garantia;
	public int quantidade;  
	
	public Produto(String nome, int codigo, String marca, String categoria, String descrição, double valor, Date garantia, int quantidade) {
		this.nome = nome;
		this.codigo = codigo;
		this.marca = marca;
		this.categoria = categoria;
		this.descrição = descrição;
		this.valor = valor;
		this.garantia = garantia;
		this.quantidade = quantidade;
	}
	
	public int qtdProduto() {
		return this.quantidade;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
}