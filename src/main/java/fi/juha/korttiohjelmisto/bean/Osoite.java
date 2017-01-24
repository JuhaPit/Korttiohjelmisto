package fi.juha.korttiohjelmisto.bean;

public class Osoite {

	private int id;
	private String henkilonNimi;
	private String osoite;
	private String postinro;
	private String postitmp;

	public Osoite() {
		super();
	}

	public Osoite(int id, String henkilonNimi, String osoite, String postinro,
			String postitmp) {
		super();
		this.id = id;
		this.henkilonNimi = henkilonNimi;
		this.osoite = osoite;
		this.postinro = postinro;
		this.postitmp = postitmp;
	}
	
	

	public Osoite(String henkilonNimi, String osoite, String postinro,
			String postitmp) {
		super();
		this.henkilonNimi = henkilonNimi;
		this.osoite = osoite;
		this.postinro = postinro;
		this.postitmp = postitmp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHenkilonNimi() {
		return henkilonNimi;
	}

	public void setHenkilonNimi(String henkilonNimi) {
		this.henkilonNimi = henkilonNimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getPostinro() {
		return postinro;
	}

	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}

	public String getPostitmp() {
		return postitmp;
	}

	public void setPostitmp(String postitmp) {
		this.postitmp = postitmp;
	}

	@Override
	public String toString() {
		return "Osoite [id=" + id + ", henkilonNimi=" + henkilonNimi
				+ ", osoite=" + osoite + ", postinro=" + postinro
				+ ", postitmp=" + postitmp + "]";
	}

}
