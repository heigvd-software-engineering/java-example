package ch.heigvd.examples.calcite.function.schema.function;

public class AggFunction {
    public String init() {
        return "";
    }

    public String add(String accumulator, int lat, int lon) {
        return accumulator + String.format("(%d,%d)", lat, lon);
    }

    public String merge(String rhs, String lhs) {
        return String.format("%s,%s", lhs, rhs);
    }

    public String result(String accumulator) {
        return String.format("[%s]", accumulator);
    }
}
