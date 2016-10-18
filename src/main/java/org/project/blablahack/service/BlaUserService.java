package org.project.blablahack.service;

import org.project.blablahack.dao.BlaUserDao;
import org.project.blablahack.model.BlaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlaUserService {
  @Autowired
  BlaUserDao userDao;

  public BlaUser get(String hash){
    return userDao.get(hash);
  }

  public void save(BlaUser user){
    userDao.save(user);
  }

  public void save(List<BlaUser> users){
    userDao.save(users);
  }
}
