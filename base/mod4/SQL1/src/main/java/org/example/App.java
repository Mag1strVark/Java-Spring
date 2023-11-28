package org.example;

import java.sql.SQLException;

public class App 
{
    public static void main(String[] args) {
        DB db = new DB();

        try {
            db.createTables();
            db.insertData();
            db.displayOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
