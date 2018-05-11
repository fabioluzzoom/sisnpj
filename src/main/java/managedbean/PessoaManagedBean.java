package managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.PessoaBean;

@ManagedBean(name = "PessoaMB")
@SessionScoped
public class PessoaManagedBean {

	private PessoaBean cliente = new PessoaBean();
	public PessoaBean cliente2 = new PessoaBean();
	public PessoaBean cliente3 = new PessoaBean();
	private List<PessoaBean> clientes = new ArrayList<PessoaBean>();

	
	public List<PessoaBean> adicionarCliente() {
		
		System.out.println(cliente.getNome());

		clientes.add(cliente);

		cliente = new PessoaBean();

		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).getNome());
		}
		System.out.println(clientes.size());
		
		return clientes;

	}

	public void doSalvarCliente() {
		System.out.println(clientes.isEmpty());
		for (PessoaBean cliente : clientes) {
			System.out.println(clientes.size());
		}
	}

	public PessoaBean getCliente() {
		return cliente;
	}

	public void setCliente(PessoaBean cliente) {
		this.cliente = cliente;
	}

	public List<PessoaBean> getClientes() {
		return clientes;
	}

	public void setClientes(List<PessoaBean> clientes) {
		this.clientes = clientes;
	}


}