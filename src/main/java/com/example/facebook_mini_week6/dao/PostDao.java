package com.example.facebook_mini_week6.dao;

import com.example.facebook_mini_week6.dbconnection.DbConnection;
import com.example.facebook_mini_week6.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostDao {

    public PostDao(Connection connection) {

    }

    public boolean createPost(Post post){


        String query = "insert into post(userid, message) " +
                    "values (?,?)";

        boolean result = false;

        System.out.println("Message: "+post.getMessage());
        System.out.println(post);

            try(Connection connection = DbConnection.INSTANCE.getConnection()) {


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, post.getUserid());
            preparedStatement.setString(2, post.getMessage());

                result = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean updatePost(int post_id, Post newPost){

        String query = "update posts set message = ? where post_id = ?";

        boolean success = false;


            try(Connection connection = DbConnection.INSTANCE.getConnection()) {

                PreparedStatement prepared = connection.prepareStatement(query);

                prepared.setInt(1, post_id);
                prepared.setString(2, newPost.getMessage());


                 int result = prepared.executeUpdate();

                if(result > 0) {
                success = true;
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean deletePost(int post_id){
        boolean success =  false;

            String query = "delete from posts where post_id= ?";

            try(Connection connection = DbConnection.INSTANCE.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(query);
            prepared.setInt(1, post_id);
            int result = prepared.executeUpdate();

            if(result > 0) {
                success = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
}
