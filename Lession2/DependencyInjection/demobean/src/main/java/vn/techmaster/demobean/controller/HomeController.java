package vn.techmaster.demobean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.demobean.bean.Car;
import vn.techmaster.demobean.bean.Tivi;

@Controller
public class HomeController {

  @Autowired
  Car mycar; //Lấy bean có tên là car

  @Autowired
  Tivi myTivi; 

  @ResponseBody
  @GetMapping(value = "/", produces=MediaType.TEXT_HTML_VALUE)
  public String getHome() {
    return mycar.toString();
  }

  @ResponseBody
  @GetMapping(value = "/tivi", produces=MediaType.TEXT_HTML_VALUE)
  public String getTivi() {
    return myTivi.toString();
  }
}
