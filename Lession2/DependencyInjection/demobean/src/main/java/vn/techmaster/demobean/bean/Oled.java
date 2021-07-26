package vn.techmaster.demobean.bean;

import vn.techmaster.demobean.interfaces.Panel;

public class Oled implements Panel {

  @Override
  public String panel() {
    return "Oled";
  }  
}