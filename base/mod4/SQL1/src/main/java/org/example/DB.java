package org.example;

import java.sql.*;

class DB {
    private final String HOST = "localhost";
    private final String PORT = "5433";
    private final String DB_NAME = "sql-test";
    private final String LOGIN = "root";
    private final String PASS = "root";
    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("org.postgresql.Driver");
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void createTables() throws SQLException, ClassNotFoundException {
        String createItemsTableSql = "CREATE TABLE IF NOT EXISTS items (" +
                "id SERIAL PRIMARY KEY," +
                "title VARCHAR(100) NOT NULL," +
                "price INTEGER NOT NULL," +
                "category VARCHAR(50) NOT NULL" +
                ")";

        String createOrdersTableSql = "CREATE TABLE IF NOT EXISTS orders (" +
                "id SERIAL PRIMARY KEY," +
                "user_id INTEGER NOT NULL," +
                "item_id INTEGER NOT NULL" +
                ")";

        String createUsersTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY," +
                "login VARCHAR(150) NOT NULL," +
                "pass VARCHAR(32) NOT NULL" +
                ")";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(createItemsTableSql);
        statement.executeUpdate(createOrdersTableSql);
        statement.executeUpdate(createUsersTableSql);
    }

    public void insertData() throws SQLException, ClassNotFoundException {
        String insertItemsSql = "INSERT INTO items (title, price, category) VALUES (?, ?, ?)";
        String insertUserSql = "INSERT INTO users (login, pass) VALUES (?, ?)";
        String insertOrderSql = "INSERT INTO orders (user_id, item_id) VALUES (?, ?)";

        PreparedStatement insertItemsStatement = getDbConnection().prepareStatement(insertItemsSql);
        insertItemsStatement.setString(1, "Кружка Мужская");
        insertItemsStatement.setInt(2, 300);
        insertItemsStatement.setString(3, "cups");
        insertItemsStatement.executeUpdate();

        insertItemsStatement.setString(1, "Кепка красная");
        insertItemsStatement.setInt(2, 150);
        insertItemsStatement.setString(3, "hats");
        insertItemsStatement.executeUpdate();

        PreparedStatement insertUserStatement = getDbConnection().prepareStatement(insertUserSql);
        insertUserStatement.setString(1, "john");
        insertUserStatement.setString(2, "some_pass");
        insertUserStatement.executeUpdate();

        PreparedStatement insertOrderStatement = getDbConnection().prepareStatement(insertOrderSql);
        insertOrderStatement.setInt(1, 1);
        insertOrderStatement.setInt(2, 2);
        insertOrderStatement.executeUpdate();
    }

    public void displayOrders() throws SQLException, ClassNotFoundException {
        String selectOrdersSql = "SELECT u.login, i.title FROM orders o" +
                " JOIN users u ON u.id = o.user_id" +
                " JOIN items i ON i.id = o.item_id";

        PreparedStatement selectStatement = getDbConnection().prepareStatement(selectOrdersSql);
        ResultSet resultSet = selectStatement.executeQuery();

        System.out.println("All Orders:");
        while (resultSet.next()) {
            String login = resultSet.getString("login");
            String itemTitle = resultSet.getString("title");
            System.out.println(login + " - " + itemTitle);
        }
    }
}
