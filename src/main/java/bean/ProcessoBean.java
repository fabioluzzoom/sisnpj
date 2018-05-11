package bean;

import java.sql.Timestamp;

public class ProcessoBean {
	
	private int idProcesso;
	
	private Timestamp dataHoraEntrada;
	
	private String vara;
	
	private String numProcessoVara;
	
	private String relatoFato;
	
	private String obsInicial;
	
	private String obsFinal;
	
	private int Situacao;
	
	private ClassifProcessoBean Classif;

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Timestamp getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Timestamp dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public String getVara() {
		return vara;
	}

	public void setVara(String vara) {
		this.vara = vara;
	}

	public String getNumProcessoVara() {
		return numProcessoVara;
	}

	public void setNumProcessoVara(String numProcessoVara) {
		this.numProcessoVara = numProcessoVara;
	}

	public String getRelatoFato() {
		return relatoFato;
	}

	public void setRelatoFato(String relatoFato) {
		this.relatoFato = relatoFato;
	}

	public String getObsInicial() {
		return obsInicial;
	}

	public void setObsInicial(String obsInicial) {
		this.obsInicial = obsInicial;
	}

	public String getObsFinal() {
		return obsFinal;
	}

	public void setObsFinal(String obsFinal) {
		this.obsFinal = obsFinal;
	}

	public int getSituacao() {
		return Situacao;
	}

	public void setSituacao(int situacao) {
		Situacao = situacao;
	}

	public ClassifProcessoBean getClassif() {
		return Classif;
	}

	public void setClassif(ClassifProcessoBean classif) {
		Classif = classif;
	}

}
