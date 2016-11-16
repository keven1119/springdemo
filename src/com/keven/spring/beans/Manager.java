package com.keven.spring.beans;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by keven on 16/11/15.
 */
public class Manager extends AbstractController {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        user.printInfo();
        return null;
    }

//    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
//        user.printInfo();
//        return null;
//    }
}
