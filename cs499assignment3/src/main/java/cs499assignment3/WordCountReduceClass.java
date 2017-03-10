package cs499assignment3;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReduceClass extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	@Override
	protected void reduce(Text text, Iterable<FloatWritable> values,
			Reducer<Text, FloatWritable, Text, FloatWritable>.Context context) throws IOException, InterruptedException {

		float sum = 0;
		int counter = 0;
		float average = 0;
		Iterator<FloatWritable> i = values.iterator();
		
		while(i.hasNext()) {
			sum += i.next().get();
			counter ++;
		}
		
		average = sum/counter;

		context.write(text, new FloatWritable(average));
	}

}