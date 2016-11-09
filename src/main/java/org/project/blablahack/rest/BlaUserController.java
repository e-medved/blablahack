package org.project.blablahack.rest;

import org.apache.log4j.Logger;
import org.project.blablahack.model.BlaUser;
import org.project.blablahack.model.BlaUserContainer;
import org.project.blablahack.service.BlaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class BlaUserController {

  private final Logger log = Logger.getLogger(org.project.blablahack.rest.BlaUserController.class.getName());

  @Autowired
  BlaUserService userService;

  //curl -I http://127.0.0.1:8080/users/UoYLcS9LVkUCvi36lnPeQg
  @GetMapping("/users/{hash}")
  public ResponseEntity<BlaUser> getUserByHash(@PathVariable("hash") String blaHash){
    BlaUser user = userService.get(blaHash);
    if (user != null) {
      log.info("Finded user with ID: " + blaHash);
      return new ResponseEntity<BlaUser>(user, HttpStatus.OK);
    }
    else {
      log.info("User with ID: " + blaHash + " not found");
      return new ResponseEntity<BlaUser>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value = "/users")
  public ResponseEntity<BlaUserContainer> saveBlaUsers(@RequestBody BlaUserContainer users, HttpServletRequest request){

    if (users == null && users.getUsers() != null)
      new ResponseEntity<>(users, HttpStatus.BAD_REQUEST);

    users.getUsers().forEach(u -> userService.save(u));

    log.info("Users saved succesfully [" + users.getUsers().size() + "] from: " + request.getRemoteAddr());
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
