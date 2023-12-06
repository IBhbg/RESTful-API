package com;

import pro.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerArrayList {
    private List<Product> products;


    public ProductManagerArrayList(){
        /*
        initialize database
         */
        products = new ArrayList<Product>();
        /*
        Add data to database
         */
        initializeProducts();
    }

    public void initializeProducts() {
        for (int i = 1; i <= 3; i++) {
            Product product = new Product(i, "Product " + i, i * 10000);
            products.add(product);
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

    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return;
            }
        }
    }

    public void delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
    }

    public List<Product> getAll() {
        return products;
    }

    public int size() {
        return products.size();
    }
    public int getID(Product product) {
        return product.getId();
    }

    public void set(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }
}
