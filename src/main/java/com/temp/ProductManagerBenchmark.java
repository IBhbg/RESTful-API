package com.temp;

import com.ProductManagerLinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;
import jRAPL.EnergyDiff;
import jRAPL.EnergyMonitor;
import jRAPL.EnergyStats;
import jRAPL.SyncEnergyMonitor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import pro.Product;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Benchmark)
public class ProductManagerBenchmark extends EnergyMonitor {

    public static class DemoUtils{
        public static String csvPrimitiveArray(double[] a) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < a.length - 1; i++) {
                s.append(String.format("%.6f", a[i])).append(EnergyMonitor.getCSVDelimiter());
            }
            if (a.length > 0) {
                s.append(String.format("%.6f", a[a.length - 1]));
            }
            return s.toString();
        }

    }

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
/*
    @Benchmark
    public String getAllProducts() throws IOException {
        return objectMapper.writeValueAsString(products);
    }
*/
    @Benchmark
    public String addProduct() throws IOException, InterruptedException {
        // Add jRAPL.EnergyMonitor to the product list
        SyncEnergyMonitor monitor = new SyncEnergyMonitor();
        monitor.activate();

        System.out.println(" -- running with primitive array sample...");
        double[] _before = monitor.getPrimitiveSample();
        double[] _after;
        double[] _diff;
        Product product = null;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            product = new Product(products.size() + 1, "Product " + (products.size() + 1), (products.size() + 1) * 10000);
            linkedListDataStructure.add(product);
            _after = monitor.getPrimitiveSample();
            _diff = EnergyMonitor.subtractPrimitiveSamples(_after,_before);
            System.out.println(DemoUtils.csvPrimitiveArray(_diff));
            _before = _after;
        }

        return objectMapper.writeValueAsString(product);
    }

/*
    @Benchmark
    public String updateProduct() throws IOException {
        int Product = 0;
        int productId = // Choose an existing product ID to update
                Product;
        Product product = new Product(productId, "Updated Product", 9999);
        linkedListDataStructure.update(product);
        return objectMapper.writeValueAsString(product);
    }


    @Benchmark
    public void deleteProduct(Blackhole blackhole) {
        int productId = 0; // Choose an existing product ID to delete
        blackhole.consume(linkedListDataStructure.delete(productId));
    }
*/
}
