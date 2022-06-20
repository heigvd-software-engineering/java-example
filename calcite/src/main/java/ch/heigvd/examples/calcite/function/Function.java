package ch.heigvd.examples.calcite.function;

import ch.heigvd.examples.calcite.function.schema.function.AggFunction;
import ch.heigvd.examples.calcite.function.schema.table.ListTable;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.*;
import org.apache.calcite.schema.impl.*;
import org.apache.calcite.sql.type.SqlTypeName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class Function {
    private static final List<Object[]> DATA = Arrays.asList(
            new Object[]{1, 1, 1, 0},
            new Object[]{1, 1, 2, 1},
            new Object[]{1, 1, 3, 2},

            new Object[]{2, 1, 1, 0},
            new Object[]{2, 2, 1, 1},
            new Object[]{2, 3, 1, 2}
    );

    public static void main(String...args) throws Exception {


        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RelDataTypeFactory.Builder trajType = new RelDataTypeFactory.Builder(typeFactory);

        Properties info = new Properties();
        // https://calcite.apache.org/javadocAggregate/org/apache/calcite/config/Lex.html#JAVA
        info.setProperty("lex", "MYSQL");
        Connection connection = DriverManager.getConnection("jdbc:calcite:",info);
        CalciteConnection calciteConnection =
                connection.unwrap(CalciteConnection.class);

        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        SchemaPlus schema = rootSchema.add("s", new AbstractSchema());

        trajType.add("id",SqlTypeName.VARCHAR);
        trajType.add("lat",SqlTypeName.INTEGER);
        trajType.add("lon",SqlTypeName.INTEGER);
        trajType.add("time",SqlTypeName.INTEGER);

        ListTable trajTable = new ListTable(trajType.build(),DATA);
        rootSchema.add("Traj",trajTable);


        final AggregateFunction aggregateFunction = AggregateFunctionImpl.create(AggFunction.class);
        //Aggregate function is added to the root schema !
        rootSchema.add("AGG", aggregateFunction);


        String sql = "SELECT AGG(Lat,lon) FROM Traj GROUP BY id" ;
        ResultSet resultSet = connection.createStatement().executeQuery(sql.toUpperCase());
        StringBuilder b = new StringBuilder();
        while (resultSet.next()) {
            b.append(resultSet.getString(1)).append("\n");
        }
        System.out.println(b);

        resultSet.close();
    }
}