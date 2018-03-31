package com.example.serviceimpl;

import java.util.Date;

import com.example.constants.CommonConstants;
import com.example.model.CardDetail;
import com.example.service.ValidatorService;

public class CardValidatorServiceImpl implements ValidatorService{

	@Override
	public String validate(CardDetail card) throws Exception {
		String message = CommonConstants.VALIDCARD;
		
		if(null!=card){
			message = checkCardType(card.getCardType());
			if(CommonConstants.VALIDCARD.equalsIgnoreCase(message)){
				message = checkCardNumber(card);
			}
			else if(CommonConstants.VALIDCARD.equalsIgnoreCase(message)){
				message = checkCardExpiryDate(card.getExpiryDate());
			}
			else if(CommonConstants.VALIDCARD.equalsIgnoreCase(message)){
				message = checkBlackListCard(card.getExpiryDate());
			}
		}
		return message;
	}

	private String checkBlackListCard(Date expiryDate) {
		// TODO Auto-generated method stub
		return null;
	}

	private String checkCardExpiryDate(Date expiryDate) {
		
		return CommonConstants.VALIDCARD;
		
	}

	private String checkCardNumber(CardDetail card) {
		String formattedNumber = null;
		String cardNumber = null;
		String cardType = null;
		cardNumber = card.getCardNumber();
		cardType = card.getCardType();
		if(null!= cardNumber){
			formattedNumber = cardNumber.replaceAll("\\s", "");
			if(formattedNumber.length()<16){
				return CommonConstants.INVALIDCARD;
			} else if(!checkStartNumber(cardNumber.substring(0, 1),cardType)){
				return CommonConstants.INVALIDCARD;
			}
			
	}
		return CommonConstants.VALIDCARD;
	}

	private boolean checkStartNumber(String start,String type) {
		int startingNum = Integer.parseInt(start);
		if(CommonConstants.VISA.equalsIgnoreCase(type)){
			if(startingNum != 4){
				return false;
			}
		} else if(CommonConstants.MASTER.equalsIgnoreCase(type)){
			if(startingNum >= 51 && startingNum<=55){
				return false;
			}
		}
		return true;
	}

	private String checkCardType(String cardType) {
		if(!(CommonConstants.MASTER.equalsIgnoreCase(cardType)) && 
				!(CommonConstants.VISA.equalsIgnoreCase(cardType))){
			return CommonConstants.INVALIDCARD;
		}
		return CommonConstants.VALIDCARD;
	}

}
