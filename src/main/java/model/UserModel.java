package model;

import entity.User;
import utility.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

    public static User findByLogin(String login) {
        User user = null;
        Connection connection = null;

        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("Select * from User where login=?");
            statement.setString(1,login);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                user = new User();
                user.setLogin(result.getString(1));
                user.setPassword(result.getString(2));
            }
            connection.commit();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
