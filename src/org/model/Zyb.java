package org.model;
import java.util.HashSet;
import java.util.Set;
public class Zyb implements java.io.Serializable {
	private Integer id;
	private String zym;
	private Integer rs;
	private String fdy;
	public Zyb() {
	}
	public Zyb(String zym) {
		this.zym = zym;
	}
	public Zyb(String zym, Integer rs, String fdy) {
		this.zym = zym;
		this.rs = rs;
		this.fdy = fdy;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getZym() {
		return this.zym;
	}

	public void setZym(String zym) {
		this.zym = zym;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public String getFdy() {
		return this.fdy;
	}

	public void setFdy(String fdy) {
		this.fdy = fdy;
	}
}