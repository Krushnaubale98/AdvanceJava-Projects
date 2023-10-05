package test;

public class BookBean {

	private String bcode, bname, bauthor;
	private float bprice;
	private int bqty;

	public BookBean() {
	}

	
	@Override
	public String toString() {
		return  bcode + " \t\t" + bname + "\t\t " + bauthor + "\t\t " + bprice
				+ "\t\t" + bqty ;
	}


	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {

		this.bauthor = bauthor;
	}

	public float getBprice() {
		return bprice;
	}

	public void setBprice(float bprice) {
		this.bprice = bprice;
	}

	public int getBqty() {
		return bqty;
	}

	public void setBqty(int bqty) {
		this.bqty = bqty;
	}

}
