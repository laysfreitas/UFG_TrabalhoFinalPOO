package projectfinalpoo;

import java.util.Date;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args){
		
		Loja loja1 = null;
		Endereco end1 = null;
		Endereco end2 = null;
		Funcionario f1 = null;
		Shopping shop1 = null;
		Cliente c1 = null;
		Produto p1 = null;
		
		Date data = new Date();
		System.out.println("Data Agora: "+data);
		
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		JOptionPane.showConfirmDialog(null, "Cadastro Shopping");
		String cnpjshop = JOptionPane.showInputDialog("CNPJ:");
		String nomeshop = JOptionPane.showInputDialog("Nome:");
		
		JOptionPane.showConfirmDialog(null,"Digite o endereço do Shopping!");
		
		String rua = JOptionPane.showInputDialog("Rua:");
		String bairro = JOptionPane.showInputDialog("Bairro:");
		String numero = JOptionPane.showInputDialog("Numero:");
		int number = Integer.parseInt(numero);
		String cep = JOptionPane.showInputDialog("CEP:");
		String complemento = JOptionPane.showInputDialog("Complemento:");
		
		end1 = new Endereco(rua,bairro,number,cep,complemento);
		shop1 = new Shopping(cnpjshop,nomeshop,end1);
		
		String escolha = JOptionPane.showInputDialog("1 - Cadastro Loja\n 2- Comprar Produto\n");
		int choice = Integer.parseInt(escolha);
		
		if(choice==1) {
			JOptionPane.showConfirmDialog(null, "Cadastrar Loja");
			
			String cnpjloja = JOptionPane.showInputDialog("CNPJ da Loja:");
			String nomeloja = JOptionPane.showInputDialog("Nome da Loja:");
			String codigoloja = JOptionPane.showInputDialog("Código da Loja:");
			int cod = Integer.parseInt(codigoloja);
			
			loja1 = new Loja(nomeloja,cnpjloja,cod);
			shop1.cadastrarLoja(loja1);
			
			String escolha1 = JOptionPane.showInputDialog("1 - Cadastro Funcionario\n 2- Cadastro Cliente\n 3- Cadastro Produto\n");
			int choice1 = Integer.parseInt(escolha1);
			
			if(choice1 == 1) {
				end2 = new Endereco("Av. Neddermeyer","Cidade Jardim",522,"74450210","Quadra 224, Lote 08");
				f1 = new Funcionario("Laura Bianca","800.069.057-25",end2,"(62)99325-4871");
				f1.setLoja(loja1);
				loja1.cadastrarFuncionarioLoja(f1);
			}else if(choice1 == 2) {
				end2 = new Endereco("Av. Esquina","Cidade Jardim",698,"7450625",null);
				c1 = new Cliente("Laura Bianca","800.069.057-25",end2,"(62)99325-4871");
			}else {
				
				JOptionPane.showConfirmDialog(null, "Cadastrar produto");
				String nomeprod = JOptionPane.showInputDialog("Nome do Produto:");
				String codigoproduto = JOptionPane.showInputDialog("Codigo do produto:");
				int codprod = Integer.parseInt(codigoproduto);
				String descricao = JOptionPane.showInputDialog("Descrição do produto:");
				String valorproduto = JOptionPane.showInputDialog("Valor do produto:");
				double valor = Double.parseDouble(valorproduto);
				String qtdproduto = JOptionPane.showInputDialog("Quatidade do produto:");
				int qtd = Integer.parseInt(qtdproduto);

				
				p1 = new Produto(nomeprod,codprod,descricao,valor,qtd);
			}
		}else {
			
			String codigocompra = JOptionPane.showInputDialog("Código da Loja:");
			int codcompra = Integer.parseInt(codigocompra);
			Compra compra1 = new Compra(codcompra,data,f1);
		}	

		ContaCliente conta1 = new ContaCliente(c1,data,loja1);
		
		loja1.cadastrarProdutos(p1);
		
		
		Compra compra1 = new Compra(1,data,f1);
		
		compra1.adicionaProdutos(p1,2);
		
		conta1.adicionaCompra(compra1);
		
		System.out.println(df.format(compra1.valorCompra()));
		
		System.out.println(compra1.emitirComprovante());
		
		System.out.println(loja1.consultaProduto(p1));
		
	}

}
