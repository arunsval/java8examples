package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.CardDetail;

@Service
public interface ValidatorService {
	String validate(CardDetail card) throws Exception;
}
