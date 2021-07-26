package vn.techmaster.bookstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import vn.techmaster.bookstore.model.Book;
import vn.techmaster.bookstore.model.Car;

@Controller
public class HomeController {
  // Đọc giá trị từ application.properties
  @Value("${spring.application.name}")
  private String appName;
  static final String APP_NAME = "appName";
  static final String BOOKS = "books";
  static final String CARS ="cars";

  @GetMapping(value = "/")
  public String getHome(Model model) {
    model.addAttribute(APP_NAME, appName);
    return "home";
  }

  @GetMapping(value = "/about")
  public String getAbout(Model model) {
    model.addAttribute(APP_NAME, appName);
    return "about";
  }


  // Trả về books là mảng của String
  @GetMapping(value = "/book")
  public String getBook(Model model) {
    String[] bookCollection ={"Deep Work","Nhà Giả Kim ","Cafe cùng Tony","Tôi đi code dạo"};
    model.addAttribute(BOOKS, bookCollection);
    model.addAttribute(APP_NAME, appName);
    return "book";
  }

  // Trả về books là mảng của đối tượng kiểu Book
  @GetMapping(value = "/book2")
  public String getBook2(Model model) {
    Book[] bookCollection = { 
      new Book(1, "Cafe cùng Tony", "Tony"),
      new Book(2, "Dế Mèn Phiêu Lưu Ký", "Tô Hoài")
    };

    model.addAttribute(BOOKS, bookCollection);
    model.addAttribute(APP_NAME, appName);
    return "book2";
  }

  @GetMapping(value = "/car")
  public String getCar(Model model) {
    Car[] carCollection = { 
      new Car(1,"Vios 1.5G CVT","Toyota",570),
      new Car(2, "Yaris 1.5G CVT", "Toyata", 668),
      new Car(3,"Altis 2.0V Sport","Toyata",932),
      new Car(4,"Altis 2.0V Luxury","Toyata",889),
      new Car(5,"Camry 2.5Q","Toyata",1235),
      new Car(6,"Innova 2.0V","Toyata",989),
      new Car(7,"Innova Venturer","Toyota",879),
      new Car(8,"Fortuner 2.8AT 4X4 Legender","Toyota",1429),
      new Car(9,"Land Cruiser V8","Toyota",1179),
      new Car(10,"Hilux 2.8G 4×4 AT Adventure","Toyota",913), 
    };

    model.addAttribute(CARS, carCollection);
    return "car";
  }

  // Trả về books là mảng của đối tượng kiểu Book, thêm ảnh cho từng sách
  @GetMapping(value = "/book3")
  public String getBook3(Model model) {
    Book[] bookCollection = { 
      new Book(1, "Cafe cùng Tony", "Tony"),
      new Book(2, "Dế Mèn Phiêu Lưu Ký", "Tô Hoài")
    };

    model.addAttribute(BOOKS, bookCollection);
    model.addAttribute(APP_NAME, appName);
    return "book3";
  }

  // Trả về books là mảng của đối tượng kiểu Book, thêm ảnh cho từng sách, CSS đẹp
  @GetMapping(value = "/book4")
  public String getBook4(Model model) {
    Book[] bookCollection = { 
      new Book(1, "Cafe cùng Tony", "Tony"),
      new Book(2, "Dế Mèn Phiêu Lưu Ký", "Tô Hoài")
    };

    model.addAttribute(BOOKS, bookCollection);
    model.addAttribute(APP_NAME, appName);
    return "book4";
  }
}