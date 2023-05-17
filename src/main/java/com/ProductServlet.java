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

   // private List<Product> products = new ArrayList<>();
    private ProductManagerArrayList ArrayListDataStructure;

    public ProductServlet() {



        ArrayListDataStructure = new ProductManagerArrayList();
        /*
        ArrayListDataStructure.add(new Product(1, "Product 11", 10));
        ArrayListDataStructure.add(new Product(2, "Product 2", 20));
        ArrayListDataStructure.add(new Product(3, "Product 3", 30));

         */
/*
        // Populate the list of products
        products.add(new Product(1, "Product 1", 10));
        products.add(new Product(2, "Product 2", 20));
        products.add(new Product(3, "Product 3", 30));

 */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Set the response type to JSON
            response.setContentType("application/json");

            // Convert the list of products to JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(ArrayListDataStructure.getAll());

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
            //ProductManagerArrayList productManagerObj = mapper.readValue(request.getReader(),  ProductManagerArrayList.class);


            // Validate the product data
            if (product.getId() <= 0 || product.getName().isEmpty() || product.getPrice() <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product data");
                return;
            }



            // Add the product to the list
           // products.add(product);
            ArrayListDataStructure.add(product);

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

            // Find the index of the product in the list
            int index = -1;
            for (int i = 0; i < ArrayListDataStructure.size(); i++) {
                if (ArrayListDataStructure.getID(product) == product.getId()) {
                    index = i;
                    break;
                }
            }

            // Update the product in the list
            if (index != -1) {
                ArrayListDataStructure.update(product);

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


}

