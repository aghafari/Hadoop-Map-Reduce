package cs499assignment3;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UserCountMapClass extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private static final IntWritable one = new IntWritable(1);
	private Text user = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String[] token = line.split(",");
		
		
		
		String tokenizer = token[0];
		user.set(tokenizer);
		context.write(user, one);

//		while(st.hasMoreTokens()) {
//			word.set(st.nextToken());
//			context.write(word, one);
//		}
	}
		
}
