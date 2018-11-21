package com.nit;

import java.io.Serializable;

public class LoginBean implements Serializable {
	 private String uname,pword;
	 LoginBean(){}
	 public void setUname(String uname) {
		 this.uname=uname;
	 }
	 public String getUname() {
		 return uname;
	 }
	 
	 public void setPword(String pword) {
		 this.pword=pword;
	 }
	 public String getPword() {
		 return pword;
	 }

}
