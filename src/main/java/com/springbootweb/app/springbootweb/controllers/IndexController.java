package com.springbootweb.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


  // @RequestMapping(value = "/index", method = RequestMethod.GET)
  // @GetMapping(value = "/index")
  @GetMapping({ "/index", "/", "/home"})
  public String index() {
    return "index";
  }
  
}
