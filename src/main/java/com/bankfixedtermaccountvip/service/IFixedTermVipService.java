package com.bankfixedtermaccountvip.service;

import com.bankfixedtermaccountvip.model.FixedTermVipModel;

import reactor.core.publisher.Mono;

public interface IFixedTermVipService {
	
	Mono<FixedTermVipModel> insertFixedTermVipAccount(FixedTermVipModel fixedTermVipModel);
	Mono<FixedTermVipModel> findByAccountNumber(String accountNumber);
	Mono<FixedTermVipModel> updateAmountRetire(FixedTermVipModel fixedTermVipModel);
	Mono<FixedTermVipModel> updateAmountDeposite(FixedTermVipModel fixedTermVipModel);
	
	/*To update the amount from ExtensivePay Microservice*/
	Mono<FixedTermVipModel> updateAmount(FixedTermVipModel fixedTermVipModel); 
	
	Mono<FixedTermVipModel> findByDocument(String document);
}
