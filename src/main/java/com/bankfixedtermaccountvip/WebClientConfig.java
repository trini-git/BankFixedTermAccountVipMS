package com.bankfixedtermaccountvip;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
  @Value("${config.base.webclient.bankaccountmain}")
  private String url;
  
  @Bean
  @Qualifier("bankAccountMain")
  public WebClient bankAccountMainWebClient() {
    return WebClient.create(url);
    //return WebClient.create("http://zuul-server:8020/api/bankAccountMain");
  }
}
