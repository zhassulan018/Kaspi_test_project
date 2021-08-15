package model;

import entity.Application;
import utility.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationModel {

    public static List<Application> findByIIN(String iin){
        List<Application> applications = new ArrayList<>();
        Connection connection = null;

        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("Select * from Application where iin=?");
            statement.setString(1,iin);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Application application = new Application();
                application.setApplicationNumber(result.getLong(1));
                application.setIin(result.getLong(2));
                application.setDate(result.getDate(3));
                application.setTotalMoney(result.getLong(4));
                application.setTerm(result.getInt(5));
                application.setStatus(result.getString(6));
                applications.add(application);
            }
            connection.commit();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applications;
    }

    public static void save(Application application) throws Exception {
        Connection connection = null;
        String sql = "INSERT INTO Application(iin,date,total_money,term,status) " +
                "VALUES (?,?,?,?,?)";
        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, application.getIin());
            statement.setDate(2,application.getDate());
            statement.setLong(3,application.getTotalMoney());
            statement.setInt(4,application.getTerm());
            statement.setString(5,application.getStatus());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
