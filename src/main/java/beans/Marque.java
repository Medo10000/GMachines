package beans;

import java.util.Date;

public class Marque {
	private int idM;
    private String codeM;
    private String libelle;
    
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public String getCodeM() {
		return codeM;
	}
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Marque [codeM=" + codeM + "]";
	}
	public Marque(int idM, String codeM, String libelle) {
		super();
		this.idM = idM;
		this.codeM = codeM;
		this.libelle = libelle;
	}
	public Marque(String codeM, String libelle) {
		super();
		this.codeM = codeM;
		this.libelle = libelle;
	}
	
	

}
