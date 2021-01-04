package pl.lodz.bartoszujazdowski.hadoopjob.config;

import com.google.gson.Gson;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import pl.lodz.bartoszujazdowski.hadoopjob.data.Root;

import java.io.IOException;

public class FingersMapper extends Mapper<LongWritable, Text, FingersWritable, DoubleWritable> {

    private static final Gson gson = new Gson();

    @Override
    @SuppressWarnings("unchecked")
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        Root root = gson.fromJson(value.toString(), Root.class);

        for ( int i = 1; i <= 5; i++ ) {
            context.write(
                    FingersWritable.getInstance(
                            root.getSeries().toString(),
                            root.getSide(),
                            root.getSample().toString(),
                            root.getFeatures2D().getName(i)
                    ),
                    new DoubleWritable(root.getFeatures2D().getValue(i))
            );
        }
    }

}
