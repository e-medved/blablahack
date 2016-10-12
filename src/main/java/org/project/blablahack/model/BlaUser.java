package org.project.blablahack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class BlaUser {
  @Id
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
