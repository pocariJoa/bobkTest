package com.hanul.book;

public class bookDTO {
	private String	booktitle       ;
	private String	bookwriter      ;
	private String	bookisbn        ;
	private String	bookcompany     ;
	private int	bookcost        ;
	private int	bookqty         ;
	private int	bookprice       ;
	
	//디폴트 생성자 메소드
	public bookDTO() {}
	
	public bookDTO(String booktitle, String bookwriter, String bookisbn, String bookcompany, int bookcost,
			int bookqty) {
		super();
		this.booktitle = booktitle;
		this.bookwriter = bookwriter;
		this.bookisbn = bookisbn;
		this.bookcompany = bookcompany;
		this.bookcost = bookcost;
		this.bookqty = bookqty;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookwriter() {
		return bookwriter;
	}

	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public String getBookcompany() {
		return bookcompany;
	}

	public void setBookcompany(String bookcompany) {
		this.bookcompany = bookcompany;
	}

	public int getBookcost() {
		return bookcost;
	}

	public void setBookcost(int bookcost) {
		this.bookcost = bookcost;
	}

	public int getBookqty() {
		return bookqty;
	}

	public void setBookqty(int bookqty) {
		this.bookqty = bookqty;
	}

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	
	
	
	
	
	
}
