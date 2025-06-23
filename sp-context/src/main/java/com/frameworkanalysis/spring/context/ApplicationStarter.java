package com.frameworkanalysis.spring.context;

import com.frameworkanalysis.spring.context.components.UserDetailsComponent;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ApplicationStarter {
    public static void main(String[] args) throws Exception {
        long start = System.nanoTime(); // ⏱️ Start timer

        var factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("userDetailsComponent", new RootBeanDefinition(UserDetailsComponent.class));
        var context = new GenericApplicationContext(factory);
        context.refresh();


        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");

        handler.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String message = context.getBean(UserDetailsComponent.class).getMessage();
                var input = new BufferedReader(new InputStreamReader(req.getInputStream()))
                        .lines()
                        .collect(Collectors.joining("\n"));
                resp.setContentType("text/json");
                resp.getWriter().write(input+"\n"+message);
            }
        }), "/hello");

        server.setHandler(handler);
        server.start();
        long end = System.nanoTime(); // ⏱️ End timer
        double durationMs = (end - start) / 1_000_000.0;

        System.out.printf("Startup completed in %.2f ms%n", durationMs);
        System.out.println("Server started at http://localhost:8080/hello");

        server.join();
        context.close();

    }
}

