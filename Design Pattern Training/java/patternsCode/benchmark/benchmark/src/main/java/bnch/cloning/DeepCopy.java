package bnch.cloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
public class DeepCopy {
  List<C1> obs = new LinkedList<>();

  @Setup
  public void initialize() {
    IntStream.range(0, 1_000_000).forEach(i -> obs.add(new C1()));
  }

  @SuppressWarnings("unchecked")
  @Benchmark
  public List<C1> SerializeDeserializeAllObjects()
      throws IOException, ClassNotFoundException {
    return (List<C1>) new ObjectInputStream(
        new ByteArrayInputStream(writeObjectsToArray())).readObject();
  }

  private byte[] writeObjectsToArray() throws IOException {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
      out.writeObject(obs);
      out.flush();
    }
    return bout.toByteArray();
  }
}
