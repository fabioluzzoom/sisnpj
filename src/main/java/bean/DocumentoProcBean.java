package bean;

public class DocumentoProcBean {
	
	private int idDocumentoProc;
	
	private ProcessoBean processo;
	
	private TipoDocBean tipoDoc;
	
	private byte documento;

	public int getIdDocumentoProc() {
		return idDocumentoProc;
	}

	public void setIdDocumentoProc(int idDocumentoProc) {
		this.idDocumentoProc = idDocumentoProc;
	}

	public ProcessoBean getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}

	public TipoDocBean getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocBean tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public byte getDocumento() {
		return documento;
	}

	public void setDocumento(byte documento) {
		this.documento = documento;
	}

}
