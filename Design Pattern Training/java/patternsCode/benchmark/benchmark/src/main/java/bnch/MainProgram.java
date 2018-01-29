package bnch;
public class MainProgram {
    public static void main(String[] ignore) throws Exception {
    }
}
/* To generate the jar file
       gradle clean benchmarks
   To run the program
       java -jar build/libs/benchmark-1.0-benchmarks.jar ".*bnch.*" -wi 5 -i 10 -f 1
   	
   -wi warmup iterations
   -i iterations
   -f forks on a single benchmark
 */
