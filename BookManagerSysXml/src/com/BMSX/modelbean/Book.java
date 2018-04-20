package com.BMSX.modelbean;

public class Book {
	private String bno;
	private String bname;
	private String bprice;
	private String baccount;
	private String bimagepath;
	private String bauthor;
	private String bdes;
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public String getBaccount() {
		return baccount;
	}
	public void setBaccount(String baccount) {
		this.baccount = baccount;
	}
	public String getBimagepath() {
		return bimagepath;
	}
	public void setBimagepath(String bimagepath) {
		this.bimagepath = bimagepath;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBdes() {
		return bdes;
	}
	public void setBdes(String bdes) {
		this.bdes = bdes;
	}
	public Book(String bno, String bname, String bprice, String baccount, String bimagepath, String bauthor,
			String bdes) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.bprice = bprice;
		this.baccount = baccount;
		this.bimagepath = bimagepath;
		this.bauthor = bauthor;
		this.bdes = bdes;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bno=" + bno + ", bname=" + bname + ", bprice=" + bprice + ", baccount=" + baccount
				+ ", bimagepath=" + bimagepath + ", bauthor=" + bauthor + ", bdes=" + bdes + "]";
	}
	
	
	
}
