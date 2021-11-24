package com.example.facebook_mini_week6.model;

import lombok.Data;

@Data
public class UserSignUp {

    private int user_id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String dob;
    private String gender;

    public UserSignUp(String firstname, String lastname, String email, String password, String dob, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public UserSignUp() {
    }



        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    public int getUserID() {
        return user_id;
    }
}
