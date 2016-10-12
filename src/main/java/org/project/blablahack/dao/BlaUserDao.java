package org.project.blablahack.dao;


import org.project.blablahack.model.BlaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BlaUserDao {
  @Autowired
  private MongoOperations mongoOperations;

  public void save(BlaUser user){
    mongoOperations.save(user);
  }

  public BlaUser get(String userHash) {
    return mongoOperations.findOne(Query.query(Criteria.where("balHash").is(userHash)), BlaUser.class);
  }

  public void remove(String userHash) {
    mongoOperations.remove(Query.query(Criteria.where("balHash").is(userHash)), BlaUser.class);
  }


}
