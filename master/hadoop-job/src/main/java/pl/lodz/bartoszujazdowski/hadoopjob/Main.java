package pl.lodz.bartoszujazdowski.hadoopjob;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import pl.lodz.bartoszujazdowski.hadoopjob.config.FingersMapper;
import pl.lodz.bartoszujazdowski.hadoopjob.config.FingersReducer;
import pl.lodz.bartoszujazdowski.hadoopjob.config.FingersWritable;

public class Main {

    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance(new Configuration());

        job.setJobName("hadoop-job");
        job.setJarByClass(Main.class);
        job.setMapperClass(FingersMapper.class);
        job.setReducerClass(FingersReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        job.setMapOutputKeyClass(FingersWritable.class);
        job.setMapOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        if ( job.waitForCompletion(true) ) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

}


