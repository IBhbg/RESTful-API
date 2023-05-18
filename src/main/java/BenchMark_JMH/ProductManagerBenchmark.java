package BenchMark_JMH;

import com.ProductManagerLinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import pro.Product;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Benchmark)
public class ProductManagerBenchmark {

    private List<Product> products;
    private ProductManagerLinkedList linkedListDataStructure;
    private ObjectMapper objectMapper;

    @Setup
    public void setup() {
        products = new LinkedList<>();
        linkedListDataStructure = new ProductManagerLinkedList();
        objectMapper = new ObjectMapper();

        // Initialize the product list
        for (int i = 1; i <= 3; i++) {
            Product product = new Product(i, "Product " + i, i * 10000);
            products.add(product);
        }
    }

    @Benchmark
    public String getAllProducts() throws IOException {
        return objectMapper.writeValueAsString(products);
    }

    @Benchmark
    public String addProduct() throws IOException {
        Product product = new Product(products.size() + 1, "Product " + (products.size() + 1), (products.size() + 1) * 10000);
        linkedListDataStructure.add(product);
        return objectMapper.writeValueAsString(product);
    }


    @Benchmark
    public String updateProduct() throws IOException {
        int Product = 0;
        int productId = // Choose an existing product ID to update
                Product; Product product = new Product(productId, "Updated Product", 9999);
        linkedListDataStructure.update(product);
        return objectMapper.writeValueAsString(product);
    }


    @Benchmark
    public boolean deleteProduct() {
        int productId = 0; // Choose an existing product ID to delete
        return linkedListDataStructure.delete(productId);
    }

}
