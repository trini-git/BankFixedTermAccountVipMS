package com.bankfixedtermaccountvip;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  @Qualifier("bankAccountMain")
  public WebClient bankAccountMainWebClient() {
    return WebClient.create("http://localhost:8020/api/bankAccountMain/");
  }
}
