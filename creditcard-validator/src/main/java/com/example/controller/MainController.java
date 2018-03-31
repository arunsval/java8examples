package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.CardDetail;
import com.example.service.ValidatorService;

@Controller
public class MainController {
	@Autowired
	ValidatorService validator;
	
	@PostMapping(value="/validateCard",consumes="application/json",produces="application/json")
	public ResponseEntity<String> processCardInfo(@RequestBody CardDetail card){
		String validationMessage = null;
		try {
			validationMessage = validator.validate(card);
			return new ResponseEntity<String>(validationMessage,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(validationMessage,HttpStatus.BAD_REQUEST);
		}
	}
	
}
