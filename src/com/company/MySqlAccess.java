package com.company;

import java.sql.*;

public class MySqlAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void setConnection() throws SQLException {
        this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store","root", "Incicas.123");
        this.statement = connect.createStatement();
    }

    //START OF CRUD OPERATIONS
    public void create() throws SQLException {
        setConnection();
        String insertSqlQuery = "INSERT INTO customers (customer_id, first_name, last_name, address, city, state, points) values (default, 'Beniamin','Incicas','nr 172', 'Sintea Mare', 'RO', 1500)";
        preparedStatement = connect.prepareStatement(insertSqlQuery);
        int rowsInserted = statement.executeUpdate(insertSqlQuery);
        System.out.println(rowsInserted + " rows updated");
        if (rowsInserted != 0) {
            System.out.println("A new user was inserted successfully!");
        }
        System.out.println();
    }

    public void read() throws SQLException {
        setConnection();
        String readDatabaseSqlQuery = "select * from customers";
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(readDatabaseSqlQuery);
        System.out.println("Read table: ");
        while (resultSet.next()) {
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString(3);
            String birth_date = resultSet.getString("birth_date");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            int points = resultSet.getInt("points");

            String output = "User:  " + first_name + " , " + last_name + " , " + birth_date + " , " + address + " , " + city + ", "+state+" , "+points+";";
            System.out.printf((output) + "%n", first_name, last_name, birth_date, address, city, state, points);
        }
        System.out.println();
    }

    public void update() throws SQLException {
        setConnection();
        String updateSqlQuery = "UPDATE customers SET first_name = 'Emanuel' WHERE first_name = 'Beniamin'";
        preparedStatement = connect.prepareStatement(updateSqlQuery);
        int rowsUpdated = statement.executeUpdate(updateSqlQuery);
        System.out.println(rowsUpdated + " rows updated");
        if (rowsUpdated != 0) {
            System.out.println("A new user was updated successfully!");
        }
        System.out.println();
    }

    public void delete() throws SQLException {
        setConnection();
        String deleteSqlQuery= "DELETE FROM customers WHERE first_name ='Emanuel' ";
        preparedStatement = connect.prepareStatement(deleteSqlQuery);
        int rowsDeleted = statement.executeUpdate(deleteSqlQuery);
        System.out.println(rowsDeleted + " rows deleted");
        if (rowsDeleted != 0) {
            System.out.println("A new user was deleted successfully!");
        }
        System.out.println();
    }

    private void close() {  //close the resultSet
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


