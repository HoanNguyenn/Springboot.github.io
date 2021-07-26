package vn.techmaster.demobean.bean;

public class Panel {
  private String model;

  public String getModel() {
    return model;
  }

  public Panel(String model) {
    this.model = model;
  }

  @Override
  public String toString() {
    return model;
  }
}