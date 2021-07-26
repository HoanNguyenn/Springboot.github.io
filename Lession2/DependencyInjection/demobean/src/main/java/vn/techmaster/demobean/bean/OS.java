package vn.techmaster.demobean.bean;

public class OS {
  private String model;

  public String getModel() {
    return model;
  }

  public OS(String model) {
    this.model = model;
  }

  @Override
  public String toString() {
    return model;
  }
}