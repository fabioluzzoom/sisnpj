package bean;

import java.sql.Timestamp;

public class TramitacaoBean {
	
	private int idTramitacao;
	
	private Timestamp dataTramitacao;
	
	private String textoTramitacao;
	
	private PessoaBean pessoa;

	public int getIdTramitacao() {
		return idTramitacao;
	}

	public void setIdTramitacao(int idTramitacao) {
		this.idTramitacao = idTramitacao;
	}

	public Timestamp getDataTramitacao() {
		return dataTramitacao;
	}

	public void setDataTramitacao(Timestamp dataTramitacao) {
		this.dataTramitacao = dataTramitacao;
	}

	public String getTextoTramitacao() {
		return textoTramitacao;
	}

	public void setTextoTramitacao(String textoTramitacao) {
		this.textoTramitacao = textoTramitacao;
	}

	public PessoaBean getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}

}
