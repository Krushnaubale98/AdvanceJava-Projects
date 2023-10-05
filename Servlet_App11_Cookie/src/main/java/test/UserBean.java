package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	private String uName, pWord, fName, lName, addr, mId;
	private long phNo;

	//constructor 

	public UserBean() {
	}

	//getter and setter method

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {

		this.uName = uName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}
}
