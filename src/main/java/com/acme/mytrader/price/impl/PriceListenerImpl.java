package com.acme.mytrader.price.impl;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;

public class PriceListenerImpl implements PriceListener {

  private final String stockToMonitor = "IBM";

  private void processPriceUpdate(String security, double price) {
    if (stockToMonitor.equalsIgnoreCase(security)) {
      if (price < 55.0) {
        new ExecutionService() {
          @Override
          public void buy(String security, double price, int volume) {
            System.out.println(
                "buy security:" + security + " price:" + price + " volume:" + volume);
          }

          @Override
          public void sell(String security, double price, int volume) {}
        }.buy(security, price, 100);
      }
    }
  }

  @Override
  public void priceUpdate(String security, double price) {
    this.processPriceUpdate(security, price);
  }
}
