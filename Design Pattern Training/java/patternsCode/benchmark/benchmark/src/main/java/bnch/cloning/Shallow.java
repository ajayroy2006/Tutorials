package bnch.cloning;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Shallow {
  List<C1> obs = new LinkedList<>();

  @Setup
  public void initialize() {
    IntStream.range(0, 1_000_000).forEach(i -> obs.add(new C1()));
  }

  @Benchmark
  public List<C1> cloneAllObjects() {
    return obs.stream().map(c -> c.callClone()).collect(Collectors.toList());
  }
}
