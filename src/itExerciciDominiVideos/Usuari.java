package itExerciciDominiVideos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuari {
	private String nom;
	private String cognom;
	private String password;
	private Date dataRegistre;
	private List<Video> videos = new ArrayList<Video>();
	
	public Usuari() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuari(String nom, String password) {
		super();
		this.nom = nom;
		this.password = password;
	}

	public Usuari(String nom, String cognom, String password, Date dataRegistre) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.password = password;
		this.dataRegistre = dataRegistre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(Date dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}	
	
	
	
}
