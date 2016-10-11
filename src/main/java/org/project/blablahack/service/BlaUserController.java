package org.project.blablahack.service;

import org.project.blablahack.model.BlaUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlaUserController {

  @RequestMapping
  public BlaUser getUserByHash(@RequestParam(value = "hash", defaultValue = "") String blaHash){
    return new BlaUser("0xooooQ", "TODO");
  }

  @RequestMapping
  public void saveBlaUsers(){

  }
}
