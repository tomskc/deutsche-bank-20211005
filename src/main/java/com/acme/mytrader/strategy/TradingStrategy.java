package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.impl.PriceListenerImpl;

/**
 *
 *
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

  public static void main(String[] args) throws InterruptedException {
    PriceListener ibmPriceListener = new PriceListenerImpl();
    new PriceSource() {
      @Override
      public void addPriceListener(PriceListener listener) {
        System.out.println("added PriceListener");
      }

      @Override
      public void removePriceListener(PriceListener listener) {}
    }.addPriceListener(ibmPriceListener);

    Thread.currentThread().join();
  }
}