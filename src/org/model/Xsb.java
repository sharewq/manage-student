package org.model;

import java.util.Date;
public class Xsb implements java.io.Serializable {
	private String xh;
	private Zyb zyb;
	private String xm;
	private Byte xb;
	private Date cssj;
	private Integer zxf;
	private String bz;
	private byte[] zp;
	public Xsb() {
	}
	public Xsb(Zyb zyb, String xm, Byte xb, Date cssj, Integer zxf, String bz,
			byte[] zp) {
		this.zyb = zyb;
		this.xm = xm;
		this.xb = xb;
		this.cssj = cssj;
		this.zxf = zxf;
		this.bz = bz;
		this.zp = zp;
	}
	public String getXh() {
		return this.xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public Zyb getZyb() {
		return this.zyb;
	}

	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Byte getXb() {
		return this.xb;
	}

	public void setXb(Byte xb) {
		this.xb = xb;
	}

	public Date getCssj() {
		return this.cssj;
	}

	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}

	public Integer getZxf() {
		return this.zxf;
	}

	public void setZxf(Integer zxf) {
		this.zxf = zxf;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public byte[] getZp() {
		return this.zp;
	}

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

}