package cs499assignment3;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapClass extends Mapper<LongWritable, Text, Text, FloatWritable> {

	private static final FloatWritable one = new FloatWritable(1);
	private Text movie = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FloatWritable>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String[] token = line.split(",");
		
		
		FloatWritable val = new FloatWritable(Float.parseFloat(token[2]));
		
		String tokenizer = token[0];
		movie.set(tokenizer);
		context.write(movie, val);

//		while(st.hasMoreTokens()) {
//			word.set(st.nextToken());
//			context.write(word, one);
//		}
	}

}