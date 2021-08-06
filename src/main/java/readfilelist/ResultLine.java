package readfilelist;

public class ResultLine extends Line {
    private String secondValue;

    public ResultLine(Line first, Line second) {
        super(first.getId(),first.getValue());
        this.secondValue = second.getValue();
    }
    public ResultLine(Line first) {
        super(first.getId(),first.getValue());

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getId()).append(",").append(getValue()).append(" ").append(getSecondValue());
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

}