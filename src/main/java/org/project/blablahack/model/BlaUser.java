package org.project.blablahack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class BlaUser {
  @Id
  private String blaHash;
  private String phone;
  private String login;
  private String password;

  public BlaUser(String blaHash, String phone, String login, String password) {
    this.blaHash = blaHash;
    this.phone = phone;
    this.login = login;
    this.password = password;
  }

  public BlaUser(){}

  public String getBlaHash() {
    return blaHash;
  }

  public String getPhone() {
    return phone;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }
}
