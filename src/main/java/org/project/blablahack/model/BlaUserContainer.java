package org.project.blablahack.model;

import java.util.ArrayList;
import java.util.List;


public class BlaUserContainer {
  private List<BlaUser> users;

  public BlaUserContainer(){
    users = new ArrayList<>();
  }

  public BlaUserContainer(List<BlaUser> users){
    this.users = users;
  }

  public List<BlaUser> getUsers() {
    return users;
  }

  public void setUsers(List<BlaUser> users) {
    this.users = users;
  }
}
