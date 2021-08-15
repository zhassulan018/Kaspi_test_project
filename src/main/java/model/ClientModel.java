package model;

import entity.Client;
import utility.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientModel {

    public static Client findByIin(Long iin) {
        Client client = null;
        Connection connection = null;

        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("Select * from Client where iin=?");
            statement.setString(1,String.valueOf(iin));
            ResultSet result = statement.executeQuery();
            while(result.next()){
                client = new Client();
                client.setIin(result.getLong(1));
                client.setFirstname(result.getString(2));
                client.setLastname(result.getString(3));
                client.setFathername(result.getString(4));
                client.setPhone(result.getString(5));
                client.setBirthday(result.getDate(6));
                client.setSex(result.getString(7));
                client.setDocumentNumber(result.getLong(8));
                client.setDepartmentGiven(result.getString(9));
                client.setGivenDate(result.getDate(10));
                client.setUntilDate(result.getDate(11));
                client.setSalary(result.getLong(12));
                client.setExpenditure(result.getLong(13));
            }
            connection.commit();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public static void save(Client client) throws Exception {
        Connection connection = null;
        String sql = "INSERT INTO Client(iin,firstname,lastname,fathername,phone," +
                "birthday,sex,document_number,department_given," +
                "given_date,until_date,salary,expenditure) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, client.getIin());
            statement.setString(2,client.getFirstname());
            statement.setString(3,client.getLastname());
            statement.setString(4,client.getFathername());
            statement.setString(5,client.getPhone());
            statement.setDate(6,client.getBirthday());
            statement.setString(7,client.getSex());
            statement.setLong(8,client.getDocumentNumber());
            statement.setString(9,client.getDepartmentGiven());
            statement.setDate(10,client.getGivenDate());
            statement.setDate(11,client.getUntilDate());
            statement.setLong(12,client.getSalary());
            statement.setLong(13,client.getExpenditure());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(Client client) throws Exception {
        Connection connection = null;
        String sql = "update client set firstName=?, lastName=?, fathername=?,phone =?,birthday=?,sex =?,document_number =?," +
                "department_given=?,given_date=?,until_date=?,salary=?,expenditure=? where iin = ?";

        try{
            connection = ConnectionDB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,client.getFirstname());
            statement.setString(2,client.getLastname());
            statement.setString(3,client.getFathername());
            statement.setString(4,client.getPhone());
            statement.setDate(5,client.getBirthday());
            statement.setString(6,client.getSex());
            statement.setLong(7,client.getDocumentNumber());
            statement.setString(8,client.getDepartmentGiven());
            statement.setDate(9,client.getGivenDate());
            statement.setDate(10,client.getUntilDate());
            statement.setLong(11,client.getSalary());
            statement.setLong(12,client.getExpenditure());
            statement.setLong(13,client.getIin());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
