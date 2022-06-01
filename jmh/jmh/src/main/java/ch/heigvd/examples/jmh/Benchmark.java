package ch.heigvd.examples.jmh;

import java.util.Random;

public class Benchmark {

  public static void main(String... args) {
    long t1 = System.nanoTime();
    var rnd = new Random();
    for (int i = 0; i < 1_000_000; i++) {
      rnd.nextInt();
    }
    long t2 = System.nanoTime();
    System.out.println(t2 - t1);
  }

}
