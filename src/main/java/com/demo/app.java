package com.demo;
import com.temp.ProductManagerBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class app {
    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                //.include(ProductManagerArrayListBenchmark.class.getSimpleName())
                //.include(ProductManagerLinkedListBenchmark.class.getSimpleName())
                .include(ProductManagerBenchmark.class.getSimpleName())  // ProductManagerLinkedList as data manager
               // .forks(1)
                .build();

        new Runner(options).run();
    }
}
