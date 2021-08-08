package readfilelist;

public class Line {
    private int Id;
    private String value;

    public Line(int id, String value) {
        Id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return getId() + "," + getValue() +
                "\n";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

