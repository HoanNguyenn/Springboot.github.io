package vn.techmaster.bookstore.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @ResponseBody // trả về dữ liệu trong trường body
  @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
  public String getHome() {
    return "This is My Book Store";
  }

  @ResponseBody
  @GetMapping(value = "/about", produces = MediaType.TEXT_HTML_VALUE)
  public String getAbout() {
    return "About page";
  }

  @ResponseBody
  @GetMapping(value = "/car", produces = MediaType.TEXT_HTML_VALUE)
  public String getCar() {
    try {
      File file = ResourceUtils.getFile("classpath:btvn.csv");
      return new String(Files.readAllBytes(file.toPath()));
    } catch (FileNotFoundException e) {
      return "File Not Found";
    } catch (IOException e) {
      return "IO Exception Error";
    }

  }
}
