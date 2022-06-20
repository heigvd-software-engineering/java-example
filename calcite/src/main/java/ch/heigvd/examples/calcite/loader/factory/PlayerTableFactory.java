package ch.heigvd.examples.calcite.loader.factory;

import ch.heigvd.examples.calcite.loader.schema.table.PlayerDataType;
import ch.heigvd.examples.calcite.loader.schema.table.PlayerTable;
import ch.heigvd.examples.calcite.loader.schema.table.PlayerTableImpl;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.TableFactory;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class PlayerTableFactory implements TableFactory<PlayerTable> {

    public static final List<PlayerDataType> PLAYER_DATA = Arrays.asList(
            new PlayerDataType(1, "Wizard", 5),
            new PlayerDataType(2, "Hunter", 7)

    );


    @Override
    // The Map<String, Object> operands is the Java representation of the operands key in the loader.json
    public PlayerTable create(SchemaPlus schemaPlus, String name, Map<String, Object> operands, @Nullable RelDataType relDataType) {

        // Here we can put an advanced mechanism to load data to the table. Like read a local or remote file on a S3 or connect to a no sql database
        return new PlayerTableImpl(PLAYER_DATA);
    }
}