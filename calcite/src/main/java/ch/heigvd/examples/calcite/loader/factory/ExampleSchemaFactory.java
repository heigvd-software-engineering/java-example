package ch.heigvd.examples.calcite.loader.factory;

import ch.heigvd.examples.calcite.common.schema.ExampleSchema;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.util.Map;

public class ExampleSchemaFactory implements SchemaFactory {
    @Override
    // The Map<String, Object> operands is the Java representation of the operands key in the model.json
    public Schema create(SchemaPlus rootSchema, String name, Map<String, Object> operands) {
        return new ExampleSchema(rootSchema);
    }
}
