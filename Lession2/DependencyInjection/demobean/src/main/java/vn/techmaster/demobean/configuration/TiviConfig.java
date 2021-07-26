package vn.techmaster.demobean.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.bean.OS;
import vn.techmaster.demobean.bean.Tivi;

@Configuration
public class TiviConfig {
  @Autowired
  private ApplicationContext context;

  @Value("${osType}")
  private String osType;

  @Bean
  public Tivi tivi() {
    OS os;
    switch (osType) {
    case "Normal":
      os = (OS) context.getBean("Normal");
      break;
    case "IOS":
      os = (OS) context.getBean("IOS");
      break;
    case "Android":
      os = (OS) context.getBean("Android");
      break;
    case "Flutter":
      os = (OS) context.getBean("Flutter");
      break;
    default:
      os = (OS) context.getBean("Normal");
    }
    return new Tivi(os);
  }

}
