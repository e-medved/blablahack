package org.project.blablahack.mvc;

import org.project.blablahack.model.BlaUser;
import org.project.blablahack.service.BlaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by root on 11/1/16.
 */
@Controller
public class ViewController {


  @Autowired
  BlaUserService userService;

  //curl -I http://127.0.0.1:8080/users?id=84aeRZxOXxwOwly3V3l7Kw
  @RequestMapping(value = "/users")
  public String state(@RequestParam(value = "id") String userID, Model model){

    BlaUser user = userService.get(userID);

    model.addAttribute("phone", user.getPhone());

    return "state";
  }
}
