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
public class ConcurrencyAPI_ThenCombineExample {

  /**
   * @param args
   * @throws ExecutionException 
   * @throws InterruptedException 
   */
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    System.out.println("Get screen width(in inches).");
    CompletableFuture<Double> widthInInchesFuture = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return 11.57;
    });

    System.out.println("Get screen height(in inches).");
    CompletableFuture<Double> heightInInchesFuture = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return 6.51;
    });

    //Calculate screen size of laptop.
    CompletableFuture<Double> combinedFuture =
        widthInInchesFuture.thenCombine(heightInInchesFuture, (widthInInches, heightInInches) -> {
          return Math.sqrt((widthInInches * widthInInches) + (heightInInches * heightInInches));
        });

    System.out.println("Screen size is: " + combinedFuture.get());

  }
}
