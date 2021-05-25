package com.example.CourseWork.web;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.dao.InMemoryDatabase;
import com.example.CourseWork.dao.InMemoryTestDao;
import com.example.CourseWork.service.FlatService;
import com.example.CourseWork.service.FlatServiceImplements;
import com.example.CourseWork.service.UserService;
import com.example.CourseWork.service.UserServiceImplements;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.function.UnaryOperator;

@WebListener
public class ApplicationContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        InMemoryDatabase database = new InMemoryDatabase();
        InMemoryTestDao.generateTo(database);
        DaoFactory daoFactory = database.getDaoFactory();

        FlatService flatService = new FlatServiceImplements(daoFactory);
        sce.getServletContext().setAttribute("flatService", flatService);

        UserService userService = new UserServiceImplements(daoFactory, UnaryOperator.identity());
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
