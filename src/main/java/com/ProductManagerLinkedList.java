package com;

import pro.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductManagerLinkedList {
    private List<Product> products;
    
    
    public ProductManagerLinkedList(){
        products = new LinkedList<Product>();
        initializeProducts();
    }

    public void initializeProducts() {
        for (int i = 1; i <= 3; i++) {
            Product product = new Product(i, "Product " + i, i * 10000);
            add(product);
        }
    }


    public void add(Product product) {
        products.add(product);
    }

    public Product get(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return true; // Corrected: Return true after updating the product
            }
        }
        return false;
    }


    public boolean delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true; // Corrected: Return true after deleting the product
            }
        }
        return false;
    }


    public List<Product> getAll() {
        return products;
    }
}
