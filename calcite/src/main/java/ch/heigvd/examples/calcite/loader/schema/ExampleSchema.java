package ch.heigvd.examples.calcite.loader.schema;

import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.impl.AbstractSchema;

public class ExampleSchema extends AbstractSchema {
    private SchemaPlus rootSchema;

    public ExampleSchema(SchemaPlus rootSchema) {
        this.rootSchema = rootSchema;
    }

    public SchemaPlus getRootSchema() {
        return rootSchema;
    }
}
