// simple tuple implementation where x is the key, y is the value
public class Tuple<X, Y> {
    public final X key;
    public final Y value;

    public Tuple(X x, Y y) {
        this.key = x;
        this.value = y;
    }

    public String toString() {
        return "<" + key + ", " + value + ">";

    }
}