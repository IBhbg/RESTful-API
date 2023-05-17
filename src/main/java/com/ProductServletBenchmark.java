package com;
/*
import org.openjdk.jmh.annotations.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServletBenchmark {

    @State(Scope.Benchmark)
    public static class ServletState {
        private ProductServlet servlet;
        private HttpServletRequest request;
        private HttpServletResponse response;

        @Setup(Level.Iteration)
        public void setup() {
            servlet = new ProductServlet();
            request = null;  // new  MockHttpServletRequest();
            response = null; //new MockHttpServletResponse();
        }
    }

    @Benchmark
    public void doGetBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doGet(state.request, state.response);
    }

    @Benchmark
    public void doPostBenchmark(ServletState state) throws ServletException, IOException {
        state.servlet.doPost(state.request, state.response);
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
*/