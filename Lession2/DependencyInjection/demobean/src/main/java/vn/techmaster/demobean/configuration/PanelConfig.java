package vn.techmaster.demobean.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.bean.Led;
import vn.techmaster.demobean.bean.Oled;

@Configuration
public class PanelConfig {
  @Bean
  public Led led() {
    return new Led();
  }

  @Bean
   public Oled oled() {
    return new Oled();
  }
}
