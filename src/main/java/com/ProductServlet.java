package com;
import com.fasterxml.jackson.databind.ObjectMapper;
import pro.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductManagerLinkedList linkedListDataStructure;

    public ProductServlet() {
        linkedListDataStructure = new ProductManagerLinkedList();

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Set the response type to JSON
            response.setContentType("application/json");

            // Convert the list of products to JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(linkedListDataStructure.getAll());

            // Write the JSON to the response body
            response.getWriter().write(json);
        } catch (Exception e) {
            // Handle exceptions
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Read the product from the request body
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(request.getReader(), Product.class);

            // Validate the product data
            if (product.getId() <= 0 || product.getName().isEmpty() || product.getPrice() <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product data");
                return;
            }

            // Add the product to the list
            linkedListDataStructure.add(product);

            // Set the response type to JSON
            response.setContentType("application/json");

            // Convert the product to JSON
            String json = mapper.writeValueAsString(product);

            // Write the JSON to the response body
            response.getWriter().write(json);
        } catch (Exception e) {
            // Handle exceptions
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Read the product from the request body
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(request.getReader(), Product.class);

            // Validate the product data
            if (product.getId() <= 0 || product.getName().isEmpty() || product.getPrice() <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product data");
                return;
            }

            // Find the product in the list and update it
            if (linkedListDataStructure.update(product)) {
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
        } catch (Exception e) {
            // Handle exceptions
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Read the product ID from the request parameter
            int id = Integer.parseInt(request.getParameter("id"));

            // Delete the product from the list
            if (linkedListDataStructure.delete(id)) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Product not found
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle exceptions
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
