package ch.heigvd.examples.calcite.function;

public class Trajectoire {
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
