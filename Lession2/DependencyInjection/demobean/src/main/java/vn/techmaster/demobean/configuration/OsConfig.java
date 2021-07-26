package vn.techmaster.demobean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.techmaster.demobean.bean.OS;

@Configuration
public class OsConfig {
  @Bean
  public OS Normal() {
    return new OS("Normal");
  }

  @Bean(name = "IOS")
  public OS IOS() {
    return new OS("IOS");
  }

  @Bean(name = "Android")
  public OS Android() {
    return new OS("Android");
  }

  @Bean(name = "Flutter")
  public OS Flutter() {
    return new OS("Flutter");
  }
}
