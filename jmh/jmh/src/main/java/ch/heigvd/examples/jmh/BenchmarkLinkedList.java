package ch.heigvd.examples.jmh;

import java.util.ArrayList;
import java.util.LinkedList;
import org.openjdk.jmh.annotations.Setup;


public class BenchmarkLinkedList extends BenchmarkList {
  
  @Setup
  public void setup() {
    list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
  }

}
