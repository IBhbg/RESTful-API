package com.demo;

import com.ProductManagerLinkedList;
import pro.Product;

/**
 * The methods for my CRUD operations in RESTful api
 * are used in the app class. They are called by the object of
 *  ProductManagerLinkedList.
 * Nothing is used for Benchmarking etc.
 * This class is ran later by a Java agent which later shows
 * application ID (PID) and the the energy it consumed in joules.
 *
 */
public class app {
    public static void main(String[] args) {
        // Create an instance of ProductManagerLinkedList
        ProductManagerLinkedList productManager = new ProductManagerLinkedList();

        // Call the methods on the ProductManagerLinkedList instance
        productManager.initializeProducts();

        /**
         * Add method is called by ProductManagerLinkedList Object
         * Example: Add a new product
         */
        Product newProduct = new Product(4, "New Product", 40000);
        productManager.add(newProduct);

        /**
         * Get method is called by ProductManagerLinkedList Object
         * Example: Get a product by ID
         */
        Product retrievedProduct = productManager.get(2);
        if (retrievedProduct != null) {
            System.out.println("Retrieved Product: " + retrievedProduct);
        } else {
            System.out.println("Product not found.");
        }

        /**
         * Update method is called by ProductManagerLinkedList Object
         * Example: Update a product
         */
        Product updatedProduct = new Product(1, "Updated Product", 15000);
        if (productManager.update(updatedProduct)) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found for updating.");
        }

        /**
         * Delete method is called by ProductManagerLinkedList Object
         * Example: Delete a product
         */
        int productIdToDelete = 3;
        if (productManager.delete(productIdToDelete)) {
            System.out.println("Product with ID " + productIdToDelete + " deleted successfully.");
        } else {
            System.out.println("Product not found for deletion.");
        }

        /**
         * getAll method is called by ProductManagerLinkedList Object
         * Example: Get all products
         */
        System.out.println("All Products: " + productManager.getAll());
    }
}
