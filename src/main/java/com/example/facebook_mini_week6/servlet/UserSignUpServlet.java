package com.example.facebook_mini_week6.servlet;

import com.example.facebook_mini_week6.dao.UserSignUpDao;
import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.UserSignUp;
import com.example.facebook_mini_week6.utils.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserSignUpServlet", value = "/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();


        //fetch data from registration page
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

//         data validation
//        check length of data
        if (firstname.length() < 3) {
            httpSession.setAttribute("Registration Error", " firstname cannot be less than 3 character long");
            response.sendRedirect("index.jsp");
            return;
        }

        if (lastname.length() < 3) {
            httpSession.setAttribute("Registration Error", "surname cannot be less than 3 character long");
            response.sendRedirect("index.jsp");
            return;
        }


        if(password.length() < 7){
            httpSession.setAttribute("Registration Error", "password cannot be less than 7 character long");
            response.sendRedirect("index.jsp");
            return;
        }
        //================================== end of validation ====================================//

        //Password encryption
        password = PasswordHashing.encryptPassword(password);

        UserSignUp userModel = new UserSignUp(firstname, lastname, email, password, dob, gender);

        //from user DOA

        UserSignUpDao userSignUpDao = new UserSignUpDao(DbConnection.INSTANCE.getConnection());


        userSignUpDao.insertUser(userModel);


        response.sendRedirect("index.jsp");
    }
}

