package com.example.facebook_mini_week6.servlet;

import com.example.facebook_mini_week6.dao.PostDao;
import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdatePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        HttpSession httpSession = request.getSession();

        String message = request.getParameter("message");
        int post_id = Integer.parseInt(request.getParameter("post_id"));

        Post post = new Post(message);

        //from post database
        PostDao postDatabase = new PostDao(DbConnection.INSTANCE.getConnection());

        if(postDatabase.updatePost(post_id, post)){
            out.println("File uploaded to this directory");
            httpSession.setAttribute("message", "successful");
        }else{
            out.print("500 error");
            httpSession.setAttribute("message", "Error uploading data");
        }

        response.sendRedirect("homepage.jsp");

    }catch (Exception e){
        e.printStackTrace();
    }
    }
}

