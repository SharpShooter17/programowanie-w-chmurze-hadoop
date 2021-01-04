package pl.lodz.bartoszujazdowski.hadoopjob.data;

import java.util.Objects;

public class Fingers {

    private static final String[] names = {"first", "second", "third", "fourth", "fifth"};

    private Double first;

    private Double second;

    private Double third;

    private Double fourth;

    private Double fifth;

    public Fingers(Double first, Double second, Double third, Double fourth, Double fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public Fingers() {
    }

    public String getName(int fingerIndex) {
        return names[fingerIndex - 1];
    }

    public Double getValue(int fingerIndex) {
        switch (fingerIndex) {
            case 1: return getFirst();
            case 2: return getSecond();
            case 3: return getThird();
            case 4: return getFourth();
            case 5: return getFifth();
            default: return null;
        }
    }

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Double getThird() {
        return third;
    }

    public void setThird(Double third) {
        this.third = third;
    }

    public Double getFourth() {
        return fourth;
    }

    public void setFourth(Double fourth) {
        this.fourth = fourth;
    }

    public Double getFifth() {
        return fifth;
    }

    public void setFifth(Double fifth) {
        this.fifth = fifth;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof Fingers) ) return false;
        Fingers fingers = (Fingers) o;
        return Objects.equals(getFirst(), fingers.getFirst()) &&
                Objects.equals(getSecond(), fingers.getSecond()) &&
                Objects.equals(getThird(), fingers.getThird()) &&
                Objects.equals(getFourth(), fingers.getFourth()) &&
                Objects.equals(getFifth(), fingers.getFifth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond(), getThird(), getFourth(), getFifth());
    }

}
