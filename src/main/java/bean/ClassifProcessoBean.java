package bean;

public class ClassifProcessoBean {

	private int idClassif;
	
	private AreaBean Area;
	
	private String descricao;

	public int getIdClassif() {
		return idClassif;
	}

	public void setIdClassif(int idClassif) {
		this.idClassif = idClassif;
	}

	public AreaBean getArea() {
		return Area;
	}

	public void setArea(AreaBean area) {
		Area = area;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
