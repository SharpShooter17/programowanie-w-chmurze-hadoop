package pl.lodz.bartoszujazdowski.hadoopjob.config;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FingersReducer extends Reducer<FingersWritable, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(FingersWritable key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        List<Double> valuesList = StreamSupport.stream(values.spliterator(), false)
                .map(DoubleWritable::get).collect(Collectors.toList());

        double avg = valuesList.stream().mapToDouble(value -> value).sum() / valuesList.size();
        double sd = Math.sqrt(valuesList.stream().mapToDouble(value -> (Math.pow((value - avg), 2))).sum() / valuesList.size());

        context.write(new Text(key.toString()), new DoubleWritable(sd));
    }

}