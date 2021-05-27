import java.util.ArrayList;

public ArrayList<Compra>compras = new ArrayList<Compra>();

	public Funcionario(String nome, String cpf, Endereço endereço, String telefone) {
		super(nome, cpf, endereço, telefone);
	}

public void realizaCompra(Compra compra){
    compras.add(compra);  
}
