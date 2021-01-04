package pl.lodz.bartoszujazdowski.hadoopjob.config;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FingersWritable implements WritableComparable<FingersWritable> {

    private final Text series = new Text();

    private final Text side = new Text();

    private final Text sample = new Text();

    private final Text fingerIndex = new Text();

    public static FingersWritable getInstance(String series, String side, String sample, String fingerIndex) {
        FingersWritable instance = new FingersWritable();
        instance.series.set(series);
        instance.side.set(side);
        instance.sample.set(sample);
        instance.fingerIndex.set(fingerIndex);
        return instance;
    }

    @Override
    public int compareTo(FingersWritable o) {
        int seriesCompareResult = series.compareTo(o.series);
        if ( seriesCompareResult == 0 ) {
            int sideCompareResult = side.compareTo(o.side);
            if ( sideCompareResult == 0 ) {
                return fingerIndex.compareTo(o.fingerIndex);
            } else {
                return sideCompareResult;
            }
        } else {
            return seriesCompareResult;
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        series.write(dataOutput);
        side.write(dataOutput);
        sample.write(dataOutput);
        fingerIndex.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        series.readFields(dataInput);
        side.readFields(dataInput);
        sample.readFields(dataInput);
        fingerIndex.readFields(dataInput);
    }

    public Text getSeries() {
        return series;
    }

    public Text getSide() {
        return side;
    }

    public Text getSample() {
        return sample;
    }

    public Text getFingerIndex() {
        return fingerIndex;
    }

    @Override
    public boolean equals(Object object) {
        if ( object instanceof FingersWritable ) {
            FingersWritable fingersWritable = (FingersWritable) object;
            return series.equals(fingersWritable.series) && side.equals(fingersWritable.side)
                    && sample.equals(fingersWritable.sample) && fingerIndex.equals(fingersWritable.fingerIndex);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return series.hashCode();
    }

    @Override
    public String toString() {
        return side + "-" + series + "-" + fingerIndex;
    }

}
