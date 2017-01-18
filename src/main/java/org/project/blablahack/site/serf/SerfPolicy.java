package org.project.blablahack.site.serf;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.project.blablahack.model.BlaUser;

/**
 * Created by root on 1/12/17.
 */
public abstract class SerfPolicy {

  protected WebDriver driver;
  protected BlaUser blaUser;

  public SerfPolicy(BlaUser blaUser) {
    this.driver = new FirefoxDriver();
    this.blaUser = blaUser;
  }

  abstract public void serf();
}
