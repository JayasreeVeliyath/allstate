/**
 * 
 */
package com.allstate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * @author jayasreeveliyath
 *
 */
public class ConcurrencyAPIExample {

  /**
   * @param args
   * @throws ExecutionException 
   * @throws InterruptedException 
   */
  public static void main(String[] args) {
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      System.out.println("This is a different thread than main.");
    });

    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
