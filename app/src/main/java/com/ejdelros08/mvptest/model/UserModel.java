package com.ejdelros08.mvptest.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public class UserModel {

    @SerializedName("user_id")
    private int userId;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    private static UserModel serializeToModel(String json){

        Gson gson = new Gson();
        Type type = new TypeToken<UserModel>(){}.getType();

        return gson.fromJson(json, type);

    }

}
