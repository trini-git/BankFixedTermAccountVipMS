package com.bankfixedtermaccountvip.model;

public class Client {
  
  private String id;

  private String document;

  private String name;

  private String lastName;
  
  private String typeClient;

  private String status;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTypeClient() {
    return typeClient;
  }

  public void setTypeClient(String typeClient) {
    this.typeClient = typeClient;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
}
