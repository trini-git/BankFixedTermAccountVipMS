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
@RequestMapping("/fix-term-vip")
public class FixedTermVipController {
  
  @Autowired
  FixedTermVipService fixedTermVipService;
  
  @GetMapping("/find-by/{accountNumber}")
  public Mono<FixedTermVipModel> findByAccountNumber(@PathVariable String accountNumber) {

    return fixedTermVipService.findByAccountNumber(accountNumber);
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
  
}
