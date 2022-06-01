package ch.heigvd.examples.jmh;

import java.util.ArrayList;
import org.openjdk.jmh.annotations.Setup;


public class BenchmarkArrayList extends BenchmarkList {

  @Setup
  public void setup() {
    list = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
  }

}
