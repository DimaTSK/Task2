package readfilelist;

public class ValueMap {
    private String first;
    private String second;

    public ValueMap(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getSecond() {
        return second;
    }
    @Override
    public String toString() {

        return getFirst() + " " + getSecond() +
                "\n";
    }

    public String getFirst() {
        return first;
    }

    public ValueMap(String first) {
        this.first = first;
    }
}
