package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;

	@Column(name = "iso_code")
	private String isoCode;

	@Column(name = "name")
	private String name;
	
	public String getIsoCode() {
		return isoCode;
	}
	
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
