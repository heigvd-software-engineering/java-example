package ch.heigvd.examples.calcite.function.schema.table;

import org.apache.calcite.DataContext;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.ScannableTable;
import org.apache.calcite.schema.impl.AbstractTable;

import java.util.List;

public class ListTable extends AbstractTable implements ScannableTable {
    private final RelDataType rowType;
    private final List<Object[]> data;

    public ListTable(RelDataType rowType, List<Object[]> data) {
        this.rowType = rowType;
        this.data = data;
    }

    @Override public Enumerable<Object[]> scan(final DataContext root) {
        return Linq4j.asEnumerable(data);
    }

    @Override public RelDataType getRowType(final RelDataTypeFactory typeFactory) {
        return rowType;
    }
}
