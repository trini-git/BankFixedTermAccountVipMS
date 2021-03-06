package com.bankfixedtermaccountvip.service;

import com.bankfixedtermaccountvip.model.BankAccount;
import com.bankfixedtermaccountvip.model.FixedTermVipModel;
import com.bankfixedtermaccountvip.repository.IFixedTermVipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FixedTermVipService implements IFixedTermVipService {
  
  @Autowired
  IFixedTermVipRepository iFixedTermVipRepository;
  
  @Autowired
  @Qualifier("bankAccountMain")
  WebClient client;
  
  BankAccount bankAccount = new BankAccount();
  
  /* Microservice that connects insertBankSavingAccount */
  public Mono<BankAccount> insertBankAccount(BankAccount bankAccount) {
    return client.post()
        .uri("/insert")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(BodyInserters.fromObject(bankAccount))
        .retrieve()
        .bodyToMono(BankAccount.class)
        .switchIfEmpty(Mono.empty());
  }
  
  /* Microservice that connects insertBankSavingAccount */
  public Mono<BankAccount> updateAmount(BankAccount bankAccount) {
    return client.put()
        .uri("/update-amount")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .syncBody(bankAccount)
        .retrieve()
        .bodyToMono(BankAccount.class)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<FixedTermVipModel> insertFixedTermVipAccount(FixedTermVipModel fixedTermVipModel) {
    
    bankAccount.setId(fixedTermVipModel.getId());
    bankAccount.setAccountNumber(fixedTermVipModel.getAccountNumber());
    bankAccount.setType(fixedTermVipModel.getType());
    bankAccount.setStartingAmount(fixedTermVipModel.getStartingAmount());
    bankAccount.setCurrentAmount(fixedTermVipModel.getCurrentAmount());
    bankAccount.setFinalMonthAmount(fixedTermVipModel.getFinalMonthAmount());
    bankAccount.setChargeAmount(fixedTermVipModel.getChargeAmount());
    bankAccount.setMaxOfMovement(fixedTermVipModel.getMaxOfMovement());
    bankAccount.setNumberOfMovement(fixedTermVipModel.getNumberOfMovement());
    bankAccount.setNumberOfMovement(fixedTermVipModel.getNumberOfMovement());
    bankAccount.setCreatedAt(fixedTermVipModel.getCreatedAt());
    bankAccount.setStatus(fixedTermVipModel.getStatus());
    bankAccount.setBank(fixedTermVipModel.getBank());
    
    return insertBankAccount(bankAccount).flatMap(x -> {
    	return iFixedTermVipRepository.save(fixedTermVipModel);
    });
    
  }

  @Override
  public Mono<FixedTermVipModel> findByAccountNumber(String accountNumber) {
    
    return iFixedTermVipRepository.findByAccountNumber(accountNumber);
  }

  @Override
  public Mono<FixedTermVipModel> updateAmountRetire(FixedTermVipModel newFixedTermVipModel) {
    
    return iFixedTermVipRepository.findByAccountNumber(newFixedTermVipModel.getAccountNumber())
      .flatMap(oldFixedTermVipModel -> {
        
        bankAccount.setAccountNumber(oldFixedTermVipModel.getAccountNumber());
        
        if (newFixedTermVipModel.getCurrentAmount() <= oldFixedTermVipModel.getCurrentAmount()) {
          
          if (oldFixedTermVipModel.getNumberOfMovement() < oldFixedTermVipModel.getMaxOfMovement()) {
            
            oldFixedTermVipModel.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount() - newFixedTermVipModel.getCurrentAmount());
            oldFixedTermVipModel.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement() + 1);
            bankAccount.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount());
            bankAccount.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement());
            return updateAmount(bankAccount).flatMap(x -> {
              return iFixedTermVipRepository.save(oldFixedTermVipModel);
            }); 
                                    
          } else {
            
            if (oldFixedTermVipModel.getCurrentAmount() >= newFixedTermVipModel.getCurrentAmount() + oldFixedTermVipModel.getChargeAmount()){
              
              oldFixedTermVipModel.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount() - (newFixedTermVipModel.getCurrentAmount() + oldFixedTermVipModel.getChargeAmount()));
              oldFixedTermVipModel.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement() + 1);
              bankAccount.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount());
              bankAccount.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement());
              return updateAmount(bankAccount).flatMap(y -> {
                return iFixedTermVipRepository.save(oldFixedTermVipModel);
              }); 
            }
                        
          }
                    
        }
        
        return Mono.empty();
      });
  }

  @Override
  public Mono<FixedTermVipModel> updateAmountDeposite(FixedTermVipModel newFixedTermVipModel) {
    
    return iFixedTermVipRepository.findByAccountNumber(newFixedTermVipModel.getAccountNumber())
        .flatMap(oldFixedTermVipModel -> {
          
          bankAccount.setAccountNumber(oldFixedTermVipModel.getAccountNumber());
                              
            if(oldFixedTermVipModel.getNumberOfMovement() < oldFixedTermVipModel.getMaxOfMovement()) {
              
              oldFixedTermVipModel.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount() + newFixedTermVipModel.getCurrentAmount());
              oldFixedTermVipModel.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement() + 1);
              bankAccount.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount());
              bankAccount.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement());
              return updateAmount(bankAccount).flatMap(x -> {
                return iFixedTermVipRepository.save(oldFixedTermVipModel);
              }); 
                          
            }else {
              
              oldFixedTermVipModel.setCurrentAmount((oldFixedTermVipModel.getCurrentAmount() + newFixedTermVipModel.getCurrentAmount()) - oldFixedTermVipModel.getChargeAmount());
              oldFixedTermVipModel.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement() + 1);
              bankAccount.setCurrentAmount(oldFixedTermVipModel.getCurrentAmount());
              bankAccount.setNumberOfMovement(oldFixedTermVipModel.getNumberOfMovement());
              return updateAmount(bankAccount).flatMap(x -> {
                return iFixedTermVipRepository.save(oldFixedTermVipModel);
              }); 
            }
          
        });
  }

@Override
public Mono<FixedTermVipModel> updateAmount(FixedTermVipModel fixedTermVipModel) {
	
	return iFixedTermVipRepository.findByAccountNumber(fixedTermVipModel.getAccountNumber())
			.flatMap(x -> {
				x.setCurrentAmount(fixedTermVipModel.getCurrentAmount());
				return iFixedTermVipRepository.save(x);
			});
}

@Override
public Mono<FixedTermVipModel> findByDocument(String document) {
	
	return iFixedTermVipRepository.findByDocument(document);
}

@Override
public Mono<FixedTermVipModel> updateAtmAmountDepositeFtv(FixedTermVipModel fixedTermVipModel) {
	
	return iFixedTermVipRepository.findByAccountNumber(fixedTermVipModel.getAccountNumber())
			.flatMap(x -> {
				x.setCurrentAmount(fixedTermVipModel.getCurrentAmount());
				return iFixedTermVipRepository.save(x);
			});
}

@Override
public Mono<FixedTermVipModel> updateAtmAmountRetireFtv(FixedTermVipModel fixedTermVipModel) {
	
	return iFixedTermVipRepository.findByAccountNumber(fixedTermVipModel.getAccountNumber())
			.flatMap(x -> {
				x.setCurrentAmount(fixedTermVipModel.getCurrentAmount());
				return iFixedTermVipRepository.save(x);
			});
}
    
}
