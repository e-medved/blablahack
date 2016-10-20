package org.project.blablahack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class BlaUser {
  @Id
  private String blaHash;
  private String phone;

  public BlaUser(String blaHash, String phone) {
    this.blaHash = blaHash;
    this.phone = phone;
  }

  public BlaUser(){}

  public String getBlaHash() {
    return blaHash;
  }

  public String getPhone() {
    return phone;
  }
}
