package ch.heigvd.examples.calcite.loader.schema.table;


import org.apache.calcite.adapter.java.AbstractQueryableTable;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.linq4j.QueryProvider;
import org.apache.calcite.linq4j.Queryable;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.impl.AbstractTableQueryable;
import org.apache.calcite.sql.type.SqlTypeName;

import java.util.List;


public abstract class PlayerTable extends AbstractQueryableTable {

    private RelDataType rowType;

    private List<PlayerDataType> data;


    public PlayerTable(List<PlayerDataType> data) {

        //Here should be a PlayerDataType.class but the generated code does not provide the constructor and then the request throw an error
        super(Object[].class);
        this.rowType = constructType();
        this.data = data;
    }


    private RelDataType constructType(){
        RelDataTypeFactory.Builder typeBuilder = new RelDataTypeFactory.Builder( new JavaTypeFactoryImpl());

        typeBuilder.add("id", SqlTypeName.INTEGER);
        typeBuilder.add("name",SqlTypeName.VARCHAR);
        typeBuilder.add("level",SqlTypeName.INTEGER);

        return typeBuilder.build();
    }

    @Override
    public RelDataType getRowType(RelDataTypeFactory relDataTypeFactory) {
        return rowType;
    }

    @Override public Queryable<Object[]> asQueryable(QueryProvider queryProvider,
                                                     SchemaPlus schema, String tableName) {
        return new AbstractTableQueryable<Object[]>(queryProvider, schema, this, tableName) {
            @Override
            public Enumerator<Object[]> enumerator() {
                return Linq4j.transform(PlayerDataType.enumerator(getData()),
                        s -> new Object[] {s.getId(),s.getName(),s.getLevel()});
            }
        };
    }

    public List<PlayerDataType> getData() {
        return data;
    }
}

