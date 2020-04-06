package itExerciciDominiVideos;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private String url;
	private String titol;
	private List<String> tags = new ArrayList<String>();	
	
	public Video(String url, String titol, List<String> tags) {
		super();
		this.url = url;
		this.titol = titol;
		this.tags = tags;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
	
}
