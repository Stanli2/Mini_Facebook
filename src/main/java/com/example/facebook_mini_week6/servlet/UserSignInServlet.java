package com.example.facebook_mini_week6.servlet;

import com.example.facebook_mini_week6.dao.UserSignUpDao;
import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.UserSignUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserSignInServlet", value = "/UserSignInServlet")
public class UserSignInServlet extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        //get request data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(email + password);

        //from user DOA
        UserSignUpDao userDatabase = new UserSignUpDao(DbConnection.INSTANCE.getConnection());
        UserSignUp user = null;

            user = userDatabase.loginUser(email, password);
        System.out.println(user);

        if(user != null){
            httpSession.setAttribute("user", user);
            response.sendRedirect("homepage.jsp");
        }else{
            httpSession.setAttribute("Registration Error", "User not found, Enter Correct Password or Email");
            response.sendRedirect("index.jsp");
        }
    }
}
