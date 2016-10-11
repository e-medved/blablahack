package org.project.blablahack.model;


public class BlaUser {
  private String balHash;
  private String phone;

  public BlaUser(String balHash, String phone) {
    this.balHash = balHash;
    this.phone = phone;
  }

  public String getBalHash() {
    return balHash;
  }

  public String getPhone() {
    return phone;
  }
}
