package com.bankfixedtermaccountvip.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bankfixedtermaccountvip.model.FixedTermVipModel;

import reactor.core.publisher.Mono;

@Repository
public interface IFixedTermVipRepository extends ReactiveMongoRepository<FixedTermVipModel, String> {
	
  @Query(value = "{'accountNumber' : ?0 }")
  Mono<FixedTermVipModel> findByAccountNumber(String accountNumber);
  
  @Query(value="{'client.document' : ?0}")
  Mono<FixedTermVipModel> findByDocument(String document);
  
}
