package com.bankfixedtermaccountvip.repository;

import com.bankfixedtermaccountvip.model.FixedTermVipModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IFixedTermVipRepository extends ReactiveMongoRepository<FixedTermVipModel, String> {
	
  @Query(value = "{'accountNumber' : ?0 }")
  Mono<FixedTermVipModel> findByAccountNumber(String accountNumber);
  
}
