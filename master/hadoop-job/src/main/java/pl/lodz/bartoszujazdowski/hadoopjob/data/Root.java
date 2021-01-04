package pl.lodz.bartoszujazdowski.hadoopjob.data;

import java.util.Objects;

public class Root {

    private String side;

    private Integer series;

    private Integer sample;

    private Fingers features2D;

    public Root(String side, Integer series, Integer sample, Fingers features2D) {
        this.side = side;
        this.series = series;
        this.sample = sample;
        this.features2D = features2D;
    }

    public Root() {
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Fingers getFeatures2D() {
        return features2D;
    }

    public void setFeatures2D(Fingers features2D) {
        this.features2D = features2D;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof Root) ) return false;
        Root that = (Root) o;
        return Objects.equals(getSide(), that.getSide()) &&
                Objects.equals(getSeries(), that.getSeries()) &&
                Objects.equals(getSample(), that.getSample()) &&
                Objects.equals(getFeatures2D(), that.getFeatures2D());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSide(), getSeries(), getSample(), getFeatures2D());
    }

}

