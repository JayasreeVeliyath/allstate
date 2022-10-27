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
public class ConcurrencyAPI_ThenApplyExample {

  /**
   * @param args
   */
  public static void main(String[] args) {
    chainThenApplyExample();

  }

  static void chainThenApplyExample() {

    CompletableFuture<String> certificateIssuance = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Registered";
    }).thenApply(status -> {
      return status + " and Attended";
    }).thenApply(statusOfAttendance -> {
      return statusOfAttendance + ". Here is your certificate!";
    });
    try {
      System.out.println(certificateIssuance.get());
    } catch (InterruptedException | ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
