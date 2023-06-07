package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.UserDAO;
import com.app.pojo.User;


@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/getUser")
    public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        User user = ac.getBean(User.class);
        UserDAO dao = ac.getBean(UserDAO.class);
        user = dao.getUser(id);
        if (user == null) {
            // Handle the case when user is not found, e.g., show an error page or message
            return new ModelAndView("errorPage", "errorMessage", "Invalid user ID");
        } else {
            // Pass the user object to the edit form JSP page
            return new ModelAndView("editUserForm", "user", user);
        }
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        // Update the user details in the database using userDAO or appropriate service class
        userDAO.updateUser(user);
        return new ModelAndView("confirmationPage");
    }
}
