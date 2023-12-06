package com.temp;

import com.ProductManagerLinkedList;
import org.openjdk.jmh.annotations.*;
import pro.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
public class ProductManagerLinkedListBenchmark {

    private ProductManagerLinkedList productManager;

    @Setup
    public void setup() {
        productManager = new ProductManagerLinkedList();
    }

    @Benchmark
    public void addBenchmark() {
        Product product = new Product(4, "Product 4", 40000);
        productManager.add(product);
    }

    @Benchmark
    public Product getBenchmark() {
        return productManager.get(2);
    }

    @Benchmark
    public void updateBenchmark() {
        Product product = new Product(2, "Updated Product", 50000);
        productManager.update(product);
    }

    @Benchmark
    public void deleteBenchmark() {
        productManager.delete(3);
    }

    @Benchmark
    public List<Product> getAllBenchmark() {
        return productManager.getAll();
    }

}
