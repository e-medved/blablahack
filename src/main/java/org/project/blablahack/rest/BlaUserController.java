package org.project.blablahack.rest;

import org.project.blablahack.model.BlaUser;
import org.project.blablahack.service.BlaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlaUserController {

  @Autowired
  BlaUserService userService;

  @RequestMapping("/users/")
  public ResponseEntity<BlaUser> getUserByHash(@RequestParam(value = "hash", defaultValue = "") String blaHash){
    BlaUser user = userService.get(blaHash);
    if (user != null)
      return new ResponseEntity<BlaUser>(user, HttpStatus.OK);
    else
      return new ResponseEntity<BlaUser>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ResponseEntity<BlaUser> saveBlaUsers(@RequestBody BlaUser user){
    userService.save(user);

    return new ResponseEntity<BlaUser>(user, HttpStatus.OK);
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ResponseEntity<List<BlaUser>> saveBlaUsers(@RequestBody List<BlaUser> users){
    userService.save(users);

    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
