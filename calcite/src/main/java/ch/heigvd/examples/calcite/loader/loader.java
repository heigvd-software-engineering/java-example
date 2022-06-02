package ch.heigvd.examples.calcite.loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class loader {

    public static void main(String[] args) throws SQLException {
        Properties info = new Properties();
        // https://calcite.apache.org/javadocAggregate/org/apache/calcite/config/Lex.html#JAVA
        info.setProperty("lex", "MYSQL");

        // The path of the model.json is based on the working directory
        Connection connection = DriverManager.getConnection("jdbc:calcite:model=./model.json", info);

        String sql = "SELECT * FROM player";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        StringBuilder b = new StringBuilder();
        while (resultSet.next()) {
            b.append(resultSet.getString(1)).append(", ");
            b.append(resultSet.getString(2)).append(", ");
            b.append(resultSet.getString(3)).append("\n");
        }
        System.out.println(b);


        resultSet.close();
    }
}
