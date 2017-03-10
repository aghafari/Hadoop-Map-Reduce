package cs499assignment3;

import java.io.IOException;
import java.util.Iterator;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UserCountReduceClass extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text text, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

		int sum = 0;

		Iterator<IntWritable> i = values.iterator();
		
		while(i.hasNext()) {
			sum += i.next().get();
		}
		
		

		context.write(text, new IntWritable(sum));
	}

}
