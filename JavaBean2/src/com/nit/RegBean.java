package com.nit;

import java.io.Serializable;

public class RegBean implements Serializable {
	private String uname, pword, repword, fname, lname, addr, mid;
	private long phno;

	public RegBean() {
	}

	public void SetUname(String Uname) {
		this.uname = Uname;
	}

	public String getUname() {
		return uname;
	}

	public void SetPword(String Pword) {
		this.pword = Pword;
	}

	public String getPword() {
		return pword;
	}

	public void SetFname(String fname) {
		this.fname = fname;
	}

	public String getFname() {
		return pword;
	}
	
	
	public void SetLname(String lname) {
		this.lname = lname;
	}

	public String getLname() {
		return lname;
	}
	
	
	public void SetAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr() {
		return addr;
	}
	
	
	
	public void SetPhno(long phno) {
		this.phno = phno;
	}

	public long getPhno() {
		return phno;
	} 
	
	public void SetMid(String mid) {
		this.mid = mid;
	}

	public String getMid() {
		return mid;
	} 
	

}
