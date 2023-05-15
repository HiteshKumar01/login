package com.login.JdbcDao;

import java.io.IOException;
import java.sql.*;

public class JdbcDao {

    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/login_register?useSSL=false";
    //allowPublicKeyRetrieval=true&
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASS="root";


    //query for registration
    private static final String INSERT_QUERY="INSERT INTO login_reg (name, email, password,confirm_password) VALUES (?, ?, SHA1(?),SHA1(?))";

    //query for validation during login
    private static final String SELECT_QUERY="SELECT * FROM login_reg WHERE email = ? and password = SHA1(?)";


    //method used during registration
    public void insertRecord(String name,String email,String password,String confirm_password) throws IOException{

        //establish a connection
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);

             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_QUERY)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,confirm_password);

            System.out.println(preparedStatement);
            //executing the query
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);

        }
    }

    //method used for validation during login
    public Boolean validate(String email,String password) throws IOException{
        try(Connection connection=DriverManager
                .getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASS);

        PreparedStatement preparedStatement=connection.prepareStatement(SELECT_QUERY)){
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            System.out.println(preparedStatement);
            //executing the query
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t=ex.getCause();
                while(t!=null){
                    System.out.println("Cause-" + t);
                    t=t.getCause();
                }
            }
        }
    }

}