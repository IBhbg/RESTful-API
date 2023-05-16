package com;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openjdk.jmh.annotations.*;
import org.springframework.mock.web.MockHttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.mock.web.MockHttpServletResponse;
import pro.Product;

public class ProductServletBenchmark {

    @State(Scope.Benchmark)
    public static class ServletState {
        private ProductServlet servlet;
        private HttpServletRequest request;
        private HttpServletResponse response;

        @Setup(Level.Iteration)
        public void setup() {
            servlet = new ProductServlet();
            request = new  MockHttpServletRequest();
            response = new MockHttpServletResponse();
        }
    }

    @Benchmark
    public void doGetBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doGet(state.request, state.response);
    }
/*
    @Benchmark
    public void doPostBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doPost(state.request, state.response);
    }
*/
@Benchmark
public void doPostBenchmark() throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://localhost:8089/rest-api-0.0.1-SNAPSHOT/"); // Replace with the appropriate URL

    // Set the JSON content in the request body
    String jsonContent = "{\"id\": 4, \"name\": \"Product 4\", \"price\": 40}";
    StringEntity entity = new StringEntity(jsonContent);
    entity.setContentType("application/json");
    httpPost.setEntity(entity);

    // Execute the HTTP request
    CloseableHttpResponse response = httpClient.execute(httpPost);

    // Handle the response as needed
    // ...

    // Clean up resources
    response.close();
    httpClient.close();
}

    @Benchmark
    public void doPutBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doPut(state.request, state.response);
    }

    @Benchmark
    public void doDeleteBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doDelete(state.request, state.response);
    }

    // MockHttpServletRequest and MockHttpServletResponse classes can be implemented to simulate the required functionality

}
