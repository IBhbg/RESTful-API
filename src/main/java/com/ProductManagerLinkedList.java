package com;

import pro.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductManagerLinkedList {
    private List<Product> products = new LinkedList<Product>();

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
}
