package ch.heigvd.examples.calcite.simple;

import ch.heigvd.examples.calcite.common.schema.table.PlayerDataType;
import ch.heigvd.examples.calcite.common.schema.table.PlayerTable;
import ch.heigvd.examples.calcite.common.schema.table.PlayerTableImpl;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.SchemaPlus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static ch.heigvd.examples.calcite.common.Data.PLAYER_DATA;


public class simple {

    public static void main(String[] args) throws SQLException {
        Properties info = new Properties();
        // https://calcite.apache.org/javadocAggregate/org/apache/calcite/config/Lex.html#JAVA
        info.setProperty("lex", "MYSQL");

        Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection =
                connection.unwrap(CalciteConnection.class);

        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        PlayerTable playerTable = new PlayerTableImpl(PLAYER_DATA);
        rootSchema.add("player", playerTable);

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
