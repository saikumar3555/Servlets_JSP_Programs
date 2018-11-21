package com.nit;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String PCode, PName;
	private float PPrice;
	private int PQty;

	public ProductBean() {
	}

	public void setPCode(String pcode) {
		this.PCode = pcode;
	}

	public String getPCode() {
		return PCode;
	}

	public void setPName(String pname) {
		this.PName = pname;

	}

	public String getPName() {
		return PName;
	}

	public void setPPrice(float pprice) {
		this.PPrice = pprice;

	}
	public float getPPrice() {
		return PPrice;
	}
	public void setPQty(int pqty) {
		this.PQty=pqty;
	}
	public int getPQty() {
		return PQty;
	}

}
