package ch.heigvd.examples.calcite.loader.factory;

import ch.heigvd.examples.calcite.common.schema.table.PlayerTable;
import ch.heigvd.examples.calcite.common.schema.table.PlayerTableImpl;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.TableFactory;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

import static ch.heigvd.examples.calcite.common.Data.PLAYER_DATA;


public class PlayerTableFactory implements TableFactory<PlayerTable> {


    @Override
    // The Map<String, Object> operands is the Java representation of the operands key in the model.json
    public PlayerTable create(SchemaPlus schemaPlus, String name, Map<String, Object> operands, @Nullable RelDataType relDataType) {

        // Here we can put an advanced mechanism to load data to the table. Like read a local or remote file on a S3 or connect to a no sql database
        return new PlayerTableImpl(PLAYER_DATA);
    }
}