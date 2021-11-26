package com.example.facebook_mini_week6.servlet;

import com.example.facebook_mini_week6.dao.PostDao;
import com.example.facebook_mini_week6.dao.UserSignUpDao;
import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.Post;
import com.example.facebook_mini_week6.model.UserSignUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;



@WebServlet(name = "PostServlet", value = "/PostServlet")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String message = request.getParameter("message");

       HttpSession httpSession = request.getSession();

       PostDao post = new PostDao(DbConnection.INSTANCE.getConnection());

       UserSignUp userSignUp = (UserSignUp) httpSession.getAttribute("user");

       Post poster = new Post(userSignUp.getUserID(), message);
        post.createPost(poster);

       response.sendRedirect("homepage.jsp");



        }
}

