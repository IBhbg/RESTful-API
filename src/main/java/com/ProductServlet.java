package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import pro.Product;

@WebServlet("/")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private List<Product> products = new ArrayList<Product>();

    public ProductServlet() {
        // Populate the list of products
        products.add(new Product(1, "Product 1", 10));
        products.add(new Product(2, "Product 2", 20));
        products.add(new Product(3, "Product 3", 30));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response type to JSON
        response.setContentType("application/json");

        // Convert the list of products to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(products);

        // Write the JSON to the response body
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read the product from the request body
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(request.getReader(), Product.class);

        // Add the product to the list
        products.add(product);

        // Set the response type to JSON
        response.setContentType("application/json");

        // Convert the product to JSON
        String json = mapper.writeValueAsString(product);

        // Write the JSON to the response body
        response.getWriter().write(json);
       }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read the product from the request body
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(request.getReader(), Product.class);

        // Find the index of the product in the list
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                index = i;
                break;
            }
        }

        // Update the product in the list
        if (index != -1) {
            products.set(index, product);

            // Set the response type to JSON
            response.setContentType("application/json");

            // Convert the product to JSON
            String json = mapper.writeValueAsString(product);

            // Write the JSON to the response body
            response.getWriter().write(json);
        } else {
            // Product not found
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathParts = req.getRequestURI().split("/");
        if (pathParts.length < 3) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String idParam = pathParts[2];

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        boolean found = false;
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                found = true;
                break;
            }
        }

        if (found) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }



}
