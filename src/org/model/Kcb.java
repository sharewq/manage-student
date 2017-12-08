package org.model;
public class Kcb implements java.io.Serializable {
	private String kch;
	private String kcm;
	private Short kxxq;
	private Short xs;
	private int xf;
	public Kcb() {
	}
	public Kcb(String kcm, Short kxxq, Short xs, int xf) {
		this.kcm = kcm;
		this.kxxq = kxxq;
		this.xs = xs;
		this.xf = xf;
	}
	public String getKch() {
		return this.kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public String getKcm() {
		return this.kcm;
	}

	public void setKcm(String kcm) {
		this.kcm = kcm;
	}

	public Short getKxxq() {
		return this.kxxq;
	}

	public void setKxxq(Short kxxq) {
		this.kxxq = kxxq;
	}

	public Short getXs() {
		return this.xs;
	}

	public void setXs(Short xs) {
		this.xs = xs;
	}

	public int getXf() {
		return this.xf;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

}