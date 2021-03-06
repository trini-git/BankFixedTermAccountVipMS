package com.bankfixedtermaccountvip.controller;

import com.bankfixedtermaccountvip.model.FixedTermVipModel;
import com.bankfixedtermaccountvip.service.FixedTermVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
//@RequestMapping("/fix-term-vip")
public class FixedTermVipController {
  
  @Autowired
  FixedTermVipService fixedTermVipService;
  
  @GetMapping("/find-by/{accountNumber}")
  public Mono<FixedTermVipModel> findByAccountNumber(@PathVariable String accountNumber) {

    return fixedTermVipService.findByAccountNumber(accountNumber);
  }
  
  @GetMapping("/find-by-document/{document}")
  public Mono<FixedTermVipModel> findByDocument(@PathVariable String document) {

    return fixedTermVipService.findByDocument(document);
  }
  
  @PostMapping("/insert")
  public Mono<FixedTermVipModel> insertFixedTermVipAccount(
      @RequestBody FixedTermVipModel fixedTermVipModel) {

    return fixedTermVipService.insertFixedTermVipAccount(fixedTermVipModel);
  }
  
  @PutMapping("/update-retire")
  public Mono<FixedTermVipModel> updateAmountRetire(
      @RequestBody FixedTermVipModel fixedTermVipModel) {
    
    return fixedTermVipService.updateAmountRetire(fixedTermVipModel);
  }
  
  @PutMapping("/update-deposite")
  public Mono<FixedTermVipModel> updateAmountDeposite(
      @RequestBody FixedTermVipModel fixedTermVipModel) {
    
    return fixedTermVipService.updateAmountDeposite(fixedTermVipModel);
  }
  
  @PutMapping("/update")
  public Mono<FixedTermVipModel> updateAmount(
      @RequestBody FixedTermVipModel fixedTermVipModel) {
    
    return fixedTermVipService.updateAmount(fixedTermVipModel);
  }
  
  @PutMapping("/update-atm-amount-deposite-ftv")
  public Mono<FixedTermVipModel> updateAtmAmountDepositeFtv(
      @RequestBody FixedTermVipModel fixedTermVipModel) {
    
    return fixedTermVipService.updateAtmAmountDepositeFtv(fixedTermVipModel);
  }
  
  @PutMapping("/update-atm-amount-retire-ftv")
  public Mono<FixedTermVipModel> updateAtmAmountRetireFtv(
      @RequestBody FixedTermVipModel fixedTermVipModel) {
    
    return fixedTermVipService.updateAtmAmountRetireFtv(fixedTermVipModel);
  }
  
}
