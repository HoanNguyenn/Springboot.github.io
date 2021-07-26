package vn.techmaster.demobean.bean;

import vn.techmaster.demobean.interfaces.Panel;

public class Led implements Panel {

  @Override
  public String panel() {
    return "led";
  }  
}