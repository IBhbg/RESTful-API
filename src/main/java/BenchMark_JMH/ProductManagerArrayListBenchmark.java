package BenchMark_JMH;

import com.ProductManagerArrayList;
import org.openjdk.jmh.annotations.*;
import pro.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
public class ProductManagerArrayListBenchmark {

    private ProductManagerArrayList productManager;

    @Setup
    public void setup() {
        productManager = new ProductManagerArrayList();
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

    @Benchmark
    public int sizeBenchmark() {
        return productManager.size();
    }

    @Benchmark
    public int getIDBenchmark() {
        Product product = new Product(1, "Product 1", 10000);
        return productManager.getID(product);
    }

    @Benchmark
    public void setBenchmark() {
        Product product = new Product(1, "Updated Product", 20000);
        productManager.set(1, product);
    }
}
