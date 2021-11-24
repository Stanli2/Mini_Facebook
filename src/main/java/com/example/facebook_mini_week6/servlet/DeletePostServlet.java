package com.example.facebook_mini_week6.servlet;

import com.example.facebook_mini_week6.dao.PostDao;
import com.example.facebook_mini_week6.dao.UserSignUpDao;
import com.example.facebook_mini_week6.dbconnection.DbConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePostServlet", value = "/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            PrintWriter out = response.getWriter()) {
//                response.setContentType("text/plain");
//                response.setCharacterEncoding("UTF-8");
//            // post id from client
//            int postId = Integer.parseInt(request.getParameter("postId"));
//
//            //get current user in session
//            HttpSession session = request.getSession();
//            UserSignUpDao user = (UserSignUpDao) session.getAttribute("user");
//
//            //comment DOA
//            PostDao postDao = new PostDao(DbConnection.INSTANCE.getConnection());
//
////            if(postDao.deletePost(user.getUser_Id, postId)){
////                response.getWriter().write("Success deleting post");
////            }else{
////                response.getWriter().write("Failed do delete post or you don't have access to delete this post");
////            }
////
////        }catch (Exception e) {
////            e.printStackTrace();
////        }
//    } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }
//}
    }
}