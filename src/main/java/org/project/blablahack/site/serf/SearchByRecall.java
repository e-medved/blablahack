package org.project.blablahack.site.serf;

import org.project.blablahack.model.BlaUser;
import org.springframework.stereotype.Service;

/**
 * Created by root on 1/12/17.
 */
@Service("searchByRecallPolicy")
public class SearchByRecall extends SerfLogin {

  public SearchByRecall(BlaUser blaUser) {
    super(blaUser);
  }

  @Override
  public void serf() {
    //login
    super.serf();

  }
}
