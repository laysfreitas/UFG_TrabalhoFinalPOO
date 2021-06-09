package projectfinalpoo;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Shopping{
	private String cnpj;
	public String nome;
	public Endereco endereco;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Loja>lojas = new ArrayList<Loja>();
        
        File arqShopp = new File("shopping.txt");
        File arqFunc = new File("funcionariosShopping.txt");
        File arqLoja = new File("lojasShopping.txt");
	
	/* Método cosntrutor do Shopping*/
	public Shopping(String cnpj, String nome, Endereco endereco) throws IOException {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome = nome;
                salvaShopping();
	}
        /* Método que salva shopping no arquivo*/
        public void salvaShopping() throws IOException{
            FileWriter fw = new FileWriter(arqShopp);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("CNPJ: " + this.cnpj);
            pw.flush();
            pw.println("NOME: " + this.nome);
            pw.flush();
            pw.println("ENDEREÇO: " + this.endereco);
            pw.flush();
            fw.close();
            pw.close();
        }
        /* Método que altera Shopping*/
        public void alteraShopping(String nome, Endereco endereco) throws IOException{
            this.nome = nome;
            this.endereco = endereco;
            salvaShopping();
        }
        /* Método que imprime Shopping*/
        public void imprimeShopping() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("shopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        
	public String getCNPJ() {
		return this.cnpj;
	}
        
	/* Método para cadastrar loja */
	public void cadastrarLoja(Loja loja) throws IOException {
		lojas.add(loja);
                salvarLojas(lojas);
	}
	
	/* Método para cadastrar funcionário */
	public void cadastrarFuncionario(Funcionario funcionario) throws IOException {
            int dep;
            double salario;
        
            dep = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de dependentes", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
            salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
            funcionario.setDependentes(dep);
            funcionario.setSalario(salario);
            funcionario.setShopping(this);
            funcionarios.add(funcionario);
            salvarFuncionarios(funcionarios);
	}
	
	/* Método que demite funcionário */
	public void demiteFuncionario(Funcionario funcionario) throws IOException {
		
		for(int i = 0 ; i < funcionarios.size() ; i++) {
			if((funcionario.getCPF()).equals(funcionarios.get(i).getCPF())) {
				funcionarios.remove(i);
			}
		}
                salvarFuncionarios(funcionarios);
		
	}
        /* Método que altera funcionário*/
        public void alteraFuncionario(Funcionario f) throws IOException{
            int i;
            for(i=0; i<funcionarios.size();i++){
                if(funcionarios.get(i).getCPF().equals(f.getCPF())){
                    funcionarios.get(i).setSalario(5000);
                }
            }
            salvarFuncionarios(funcionarios);
        }
        /* Método que salva funcionário em arquivo*/
        public void salvarFuncionarios(ArrayList<Funcionario> func) throws IOException{
            if(arqFunc.exists())
                arqFunc.delete();
            else{
                File arqFunc = new File("funcionariosShopping.txt"); 
            }
            FileWriter fw = new FileWriter(arqFunc, true);
            PrintWriter pw = new PrintWriter(fw);

            int i;

            for(i=0; i<func.size(); i++){
                pw.println("Funcionário " + (i+1) + ":" + func.get(i));
                pw.flush();
            }
            pw.close();
            
        }
        public void mostrarFuncionarios() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("funcionariosShopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        
        public void desligaLoja(Loja loja) throws IOException{
            int i;
            for(i=0; i<lojas.size(); i++){
                if(lojas.get(i).numero==loja.numero){
                    lojas.remove(i);
                }
            }
            salvarLojas(lojas);
        }
        
        public void salvarLojas(ArrayList<Loja> lojas) throws IOException{
            if(arqLoja.exists())
                arqLoja.delete();
            else{
                File arqLoja = new File("lojasShopping.txt"); 
            }
            FileWriter fw = new FileWriter(arqLoja, true);
            PrintWriter pw = new PrintWriter(fw);

            int i;

            for(i=0; i<lojas.size(); i++){
                pw.println("Loja " + (i+1) + ":" + lojas.get(i));
                pw.flush();
            }
            pw.close();
        }
        
        public void imprimeLojas() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("lojasShopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        
	
}
