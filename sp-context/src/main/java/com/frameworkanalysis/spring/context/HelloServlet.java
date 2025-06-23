package com.frameworkanalysis.spring.context;

import com.frameworkanalysis.spring.context.components.UserDetailsComponent;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private final UserDetailsComponent userDetailsComponent;

    public HelloServlet(ApplicationContext context) {
        // Get Spring bean from context
        this.userDetailsComponent = context.getBean(UserDetailsComponent.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String message = userDetailsComponent.getMessage();
        resp.setContentType("text/plain");
        resp.getWriter().write(message);
    }
}
