import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat("###.##");
		
		Endereco end1 = new Endereco("Rua Pedro Araujo Lima","Capuava",127,"74450190","Quadra 21, Lote 15");	
		Shopping shop1 = new Shopping("12365478925","Portal Shopping",end1);
		
		Loja loja1 = new Loja("Riachuello","126985473",1);
		Loja loja2 = new Loja("Marisa","852369741",2);
		Loja loja3 = new Loja("Renner","15896324",3);
		
		Endereco end2 = new Endereco("Av. Neddermeyer","Cidade Jardim",522,"74450210","Quadra 224, Lote 08");
		Endereco end3 = new Endereco("Av. Esquina","Cidade Jardim",698,"7450625",null);
		
		Funcionario f1 = new Funcionario("Laura Bianca","800.069.057-25",end2,"(62)99325-4871");
		Funcionario f2 = new Funcionario("Lays Melo","780.158.057-00",end3,"(62)95248-3600");
		
		f1.setLoja(loja1);
		f2.setLoja(loja2);
		
		Cliente c1 = new Cliente("Laura Bianca","800.069.057-25",end2,"(62)99325-4871");
		
		shop1.cadastrarLoja(loja1);
		shop1.cadastrarLoja(loja2);
		shop1.cadastrarLoja(loja3);
		
		loja1.cadastrarFuncionarioLoja(f1);
		loja2.cadastrarFuncionarioLoja(f2);
		
		
		Date data = new Date();
		System.out.println("Data Agora: "+data);
		
		ContaCliente conta1 = new ContaCliente(c1,data,loja1);
		ContaCliente conta2 = new ContaCliente(c1,data,loja2);
		
		Produto p1 = new Produto("Blusa",100,"amarela",24.56,5);
		Produto p2 = new Produto("Camiseta Sr.K",112,"branca",49.99,10);
		Produto p3 = new Produto("Sapato",100,"Salto alto preto",112.00,2);
		
		loja1.cadastrarProdutos(p1);
		loja2.cadastrarProdutos(p2);
		loja1.cadastrarProdutos(p3);
		
		Compra compra1 = new Compra(1,data,f1);
		Compra compra2 = new Compra(2,data,f2);
		
		compra1.adicionaProdutos(p1,2);
		compra2.adicionaProdutos(p2,3);
		compra1.adicionaProdutos(p3,1);
		
		conta1.adicionaCompra(compra1);
		conta2.adicionaCompra(compra2);
	
		compra1.vendaProduto(p1,2);
		compra2.vendaProduto(p2,3);
		compra1.vendaProduto(p3,1);
		
		System.out.println(df.format(compra1.valorCompra()));
		System.out.println(df.format(compra2.valorCompra()));
		
		System.out.println(compra1.emitirComprovante());
		System.out.println(compra2.emitirComprovante());
		
		System.out.println(loja1.consultaProduto(p1));
		System.out.println(loja2.consultaProduto(p2));
		System.out.println(loja1.consultaProduto(p3));
		
	}

}
