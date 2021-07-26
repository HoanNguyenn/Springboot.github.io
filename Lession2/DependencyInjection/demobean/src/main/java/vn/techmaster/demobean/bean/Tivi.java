package vn.techmaster.demobean.bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import vn.techmaster.demobean.interfaces.Panel;
public class Tivi {

    @Autowired
    @Qualifier("led")
    private Panel panel;

    @Autowired
    @Qualifier("Normal")
    private OS os;

    public Tivi(OS os) { 
        this.os = os;
      }

    @Override
    public String toString() {
        return "Tivi [panel=" + panel.panel() + ", os=" + os + "]";
    }
}
