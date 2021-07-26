package vn.techmaster.money.request;

public class MoneyConvertRequest {
  private float amount;
  private float fromCurrency;
  private float toCurrency;

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public float getFromCurrency() {
    return fromCurrency;
  }

  public void setFromCurrency(float fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  public float getToCurrency() {
    return toCurrency;
  }

  public void setToCurrency(float toCurrency) {
    this.toCurrency = toCurrency;
  }
}
