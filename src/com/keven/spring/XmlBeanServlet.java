package com.keven.spring;

import com.keven.spring.beans.Manager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by keven on 16/11/15.
 */
@WebServlet(name = "XmlBeanServlet")
public class XmlBeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Resource resource = new ClassPathResource("applicationContext.xml");
//        System.out.println("resource path==>" + resource.getURI());
//
//        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
//        Test test  = (Test) xmlBeanFactory.getBean("test");
//
//        System.out.println("test name ===>" + test.getName());



        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Manager user = (Manager) classPathXmlApplicationContext.getBean("manager");
        try {
            user.handleRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("ClassPath test name ===>" + test.getName());

//        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext(request.getContextPath() + "/web/res/applicationContextFile.txt");
//
//        Test test = (Test) fileSystemXmlApplicationContext.getBean("test");
//
//        System.out.println("file test name ===>" + test.getName());
    }
}
