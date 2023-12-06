package com;

import pro.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductManagerHashSet {
    private Set<Product> products = new HashSet<Product>();

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
        products.remove(product);
        products.add(product);
    }

    public void delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
    }

    public Set<Product> getAll() {
        return products;
    }
}

