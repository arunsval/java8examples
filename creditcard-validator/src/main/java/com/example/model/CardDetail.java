package com.example.model;

import java.io.Serializable;
import java.util.Date;

public class CardDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cardNumber;
	private Date expiryDate;
	private String cardType;
	
	public CardDetail() {
		super();
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
}
