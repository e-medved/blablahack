package org.project.blablahack.site.serf;

import org.openqa.selenium.By;
import org.project.blablahack.model.BlaUser;

/**
 * Created by root on 1/18/17.
 */
public class SerfLogin extends SerfPolicy {

  public SerfLogin(BlaUser blaUser) {
    super(blaUser);
  }

  @Override
  public void serf() {
    driver.findElement(By.xpath(""));

  }
}
