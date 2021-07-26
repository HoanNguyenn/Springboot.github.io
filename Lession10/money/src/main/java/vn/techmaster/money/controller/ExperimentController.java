package vn.techmaster.money.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.money.model.Currency;
import vn.techmaster.money.model.CurrencyRate;
import vn.techmaster.money.request.MoneyConvertRequest;
import vn.techmaster.money.service.MoneyConverter;

@Controller
@RequestMapping("/exp")
public class ExperimentController {

  @Autowired
  private MoneyConverter moneyConverter;
  
  @GetMapping("/select")
  public String renderSelect(Model model) {
    model.addAttribute("moneyConvertRequest", new MoneyConvertRequest());

    ArrayList<Currency> currencies = new ArrayList<>();
    currencies.add(new Currency("USD", "US Dollar"));
    currencies.add(new Currency("THB", "Thai Bath"));
    currencies.add(new Currency("KRW", "South Korea Won"));
    currencies.add(new Currency("VND", "Vietnamese Dong"));
    model.addAttribute("currencies", currencies);  //trả về danh sách mã 3 ký tự của tiền tệ và tên tiền tệ
    return "select";    
  }

  @PostMapping("/convert")
  public String renderConvert(Model model, @ModelAttribute("moneyConvertRequest") MoneyConvertRequest moneyConvertRequest) {
    model.addAttribute("moneyConvertRequest", moneyConvertRequest);
    List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();

    model.addAttribute("currencies", currencies);

    var amountConvert = moneyConvertRequest.getAmount() / moneyConvertRequest.getToCurrency() * moneyConvertRequest.getFromCurrency();

    model.addAttribute("amountConvert", amountConvert);
    return "convert";
  }

}
