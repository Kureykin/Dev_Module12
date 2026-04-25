package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   private static DatabaseConnection databaseConnection = new DatabaseConnection();
   private String url = "jdbc:h2:./resources/db/test.db";

   private DatabaseConnection() {

   }

   public static DatabaseConnection getDatabase() {
      return databaseConnection;
   }

   public Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url, "SA", null);
   }
}
