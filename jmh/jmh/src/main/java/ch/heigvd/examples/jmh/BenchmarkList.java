package ch.heigvd.examples.jmh;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(1)
public abstract class BenchmarkList {

  /**
   * From the command line: $ mvn clean install $ java -jar target/benchmarks.jar BenchmarkList
   *
   * @param args
   * @throws RunnerException
   */
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(BenchmarkArrayList.class.getSimpleName())
        .forks(0)
        .mode(Mode.SingleShotTime)
        .warmupIterations(0)
        .measurementIterations(1)
        .build();
    new Runner(opt).run();
  }

  @Param({"10", "100", "1000", "10000", "100000"})
  public int size;

  public List<Integer> list;

  public abstract void setup();

  @Benchmark
  @BenchmarkMode(Mode.SingleShotTime)
  @Warmup(iterations = 3)
  @Measurement(iterations = 10)
  public void add() {
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.SingleShotTime)
  @Warmup(iterations = 3)
  @Measurement(iterations = 10)
  public void get() {
    for (int i = 0; i < size; i++) {
      list.get(i);
    }
  }
}
