package com.example.springmvc;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyXml implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Crete Dispatcher Servlet here
        //Register Dispatcher Servlet with servlet context

    }
}
