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
        return "ResultLine{" + "Id=" + this.getId() +
                ", value='" + this.getValue() + '\'' +
                "secondValue='" + secondValue + '\'' +
                '}';
    }
    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

}