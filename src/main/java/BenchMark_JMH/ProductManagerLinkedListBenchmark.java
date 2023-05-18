package BenchMark_JMH;

import com.ProductManagerLinkedList;
import org.openjdk.jmh.annotations.*;
import pro.Product;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ProductManagerLinkedListBenchmark {
    private ProductManagerLinkedList productManager;
    private Product sampleProduct;

    @Setup
    public void setup() {
        productManager = new ProductManagerLinkedList();
        sampleProduct = new Product(999, "Sample Product", 9999);
    }

    @Benchmark
    public void addProduct() {
        productManager.add(sampleProduct);
    }

    @Benchmark
    public void getProduct() {
        productManager.get(sampleProduct.getId());
    }

    @Benchmark
    public void updateProduct() {
        productManager.update(sampleProduct);
    }

    @Benchmark
    public void deleteProduct() {
        productManager.delete(sampleProduct.getId());
    }
}
