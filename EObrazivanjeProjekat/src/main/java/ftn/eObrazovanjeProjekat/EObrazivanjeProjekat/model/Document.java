package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class Document {

	
	@Column(name = "title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "url", unique = false, nullable = false)
	private String url;
	
	public Document() {
		super();
	}
	
	public Document(String title,String url) {
		super();
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}

