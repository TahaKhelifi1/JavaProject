package pratiquons;

public class vol {
	private String numero_vol;
	private String ville_depart;
	private String ville_arrivee;
	
	public vol(String numero_vol,String ville_depart,String ville_arrivee) {
		this.numero_vol= numero_vol;
		this.ville_depart=ville_depart;
		this.ville_arrivee=ville_arrivee;
	}
	public String getNumero_vol() {
		return numero_vol;
	}
	public String getVille_depart() {
		return ville_depart;
	}
	public String getVille_arrivee() {
		return ville_arrivee;
	}
	public void setNumero_vol(String numero_vol) {
		this.numero_vol= numero_vol;
	}
	public void setVille_depart(String ville_depart) {
		this.ville_depart=ville_depart;
	}
	public void setVille_arrivee(String ville_arrivee) {
		this.ville_arrivee=ville_arrivee;
	}
	
	public String toString() {
		return "Vol de numero: "+ numero_vol + "ville de depart: "+ ville_depart + "ville d'arrivee: " + ville_arrivee ;  
	}
	
	

}
