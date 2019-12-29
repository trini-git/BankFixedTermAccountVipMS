package com.bankfixedtermaccountvip.model;

public class BankAccount {
  
  private String id;

  private String accountNumber;

  private String type;

  private Double startingAmount;

  private Double currentAmount;

  private Double finalMonthAmount;

  private Double chargeAmount;

  private int maxOfMovement;

  private int numberOfMovement;

  private String createdAt;

  private String status;
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double getStartingAmount() {
    return startingAmount;
  }

  public void setStartingAmount(Double startingAmount) {
    this.startingAmount = startingAmount;
  }

  public Double getCurrentAmount() {
    return currentAmount;
  }

  public void setCurrentAmount(Double currentAmount) {
    this.currentAmount = currentAmount;
  }

  public Double getFinalMonthAmount() {
    return finalMonthAmount;
  }

  public void setFinalMonthAmount(Double finalMonthAmount) {
    this.finalMonthAmount = finalMonthAmount;
  }

  public Double getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(Double chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public int getMaxOfMovement() {
    return maxOfMovement;
  }

  public void setMaxOfMovement(int maxOfMovement) {
    this.maxOfMovement = maxOfMovement;
  }

  public int getNumberOfMovement() {
    return numberOfMovement;
  }

  public void setNumberOfMovement(int numberOfMovement) {
    this.numberOfMovement = numberOfMovement;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
