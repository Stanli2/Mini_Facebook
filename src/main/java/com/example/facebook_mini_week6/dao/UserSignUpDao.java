package com.example.facebook_mini_week6.dao;

import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.UserSignUp;
import com.example.facebook_mini_week6.utils.PasswordHashing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignUpDao {


    public UserSignUpDao(Connection connection) {
    }

    // insert user
    public boolean insertUser(UserSignUp user) {

           String insertUserDetail = "INSERT INTO sign_up" + " ( firstname, lastname, email, password, dob, gender) VALUES "
                   + " (?, ?, ?, ?, ?, ?);";
        boolean set = false;
       try(Connection connection = DbConnection.INSTANCE.getConnection()){




           PreparedStatement preparedStatement = connection.prepareStatement(insertUserDetail);

           preparedStatement.setString(1, user.getFirstname());
           preparedStatement.setString(2, user.getLastname());
           preparedStatement.setString(3,user.getEmail());
           preparedStatement.setString(4, user.getPassword());
           preparedStatement.setString(5, user.getDob());
           preparedStatement.setString(6, user.getGender());

           preparedStatement.executeUpdate();
           set = true;


           preparedStatement.close();
       } catch (SQLException throwable) {
           throwable.printStackTrace();
       }
        return set;
    }

    // select user by id
    public UserSignUp loginUser(String email, String password) {
        UserSignUp userSignUp = null;

        String logUserIn = "";

        try(Connection connection = DbConnection.INSTANCE.getConnection()) {

            logUserIn = "select * from sign_up where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(logUserIn);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                userSignUp = new UserSignUp();

                userSignUp.setUser_id(resultSet.getInt("userId"));
                userSignUp.setFirstname(resultSet.getString("firstname"));
                userSignUp.setLastname(resultSet.getString("lastname"));
                userSignUp.setEmail(resultSet.getString("email"));
                userSignUp.setPassword(resultSet.getString("password"));
                userSignUp.setDob(resultSet.getString("dob"));
                userSignUp.setGender(resultSet.getString("gender"));


                String decryptPass = PasswordHashing.decryptPassword(resultSet.getString("password"));

                if(!decryptPass.equals(password)){
                    return null;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userSignUp;
    }


    // update user

//     public boolean updateUser(UserSignUp userSignUp) throws SQLException {
//          boolean rowUpdated = false;
//
//          String userUpdate = "";
//
//          try (
//                   userUpdate = "update users set firtname = ?, lastname = ?, email = ?, password = ?, date of birth = ?";
//                  PreparedStatement preparedStatement = this.connection.prepareStatement(userUpdate);
//               preparedStatement.setString(1, userSignUp.getFirstName());
//               preparedStatement.setString(2, userSignUp.getLastName());
//               preparedStatement.setString(3, userSignUp.getEmail());
//               preparedStatement.setString(4, userSignUp.getPassword());
//               preparedStatement.setDate(5, userSignUp.getDob());
//               preparedStatement.setLong(6, userSignUp.getUser_id());
//
//               rowUpdated = preparedStatement.executeUpdate() > 0;
//          }
//          return rowUpdated;
//     }


    // delete user

    public boolean deleteUser(String email) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = DbConnection.INSTANCE.getConnection()){

            String rowDelete = "delete from sign_up where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(rowDelete);
            preparedStatement.setString(1, email);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
