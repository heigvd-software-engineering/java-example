package ch.heigvd.examples.calcite.loader.schema.table;

import org.apache.calcite.DataContext;
import org.apache.calcite.linq4j.AbstractEnumerable;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.schema.ScannableTable;

import java.util.List;

public class PlayerTableImpl extends PlayerTable implements ScannableTable {

    public PlayerTableImpl(List<PlayerDataType> data) {
        super(data);
    }


    @Override
    public Enumerable<Object[]> scan(DataContext dataContext) {
        return new AbstractEnumerable() {
            @Override
            public Enumerator<Object[]> enumerator() {
                return Linq4j.transform(PlayerDataType.enumerator(getData()),
                        s -> new Object[] {s.getId(),s.getName(),s.getLevel()});
            }
        };
    }
}