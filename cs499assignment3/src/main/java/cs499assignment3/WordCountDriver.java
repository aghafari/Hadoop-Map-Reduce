package cs499assignment3;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class WordCountDriver extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new WordCountDriver(), args);
		
		ArrList arrList = new ArrList();
		List<Movie> list = arrList.getList();
		Collections.sort(list, new MyComparator());

		ArrList arrListTwo = new ArrList("/home/ashkan/workspace/cs499assignment3/outputtwo.txt/part-r-00000");
		List<User> listTwo = arrListTwo.getUserList();
		Collections.sort(listTwo, new UserComparator());
		
		try (BufferedReader br = new BufferedReader(new FileReader("/home/ashkan/workspace/cs499assignment3/movie_titles.txt"));
			     BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values = line.split(",");
			        if (values.length >= 3)
			            bw.write(values[0] + ' ' + values[2] + '\n');
			    }
			}
		
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		Mapping map = new Mapping();
		myMap = map.getMap();
		
		for(int i = 0; i < 10; i++){
			System.out.println(myMap.get(list.get(i).getTitle()));
		}
		
		System.out.println();
		System.out.println("Top ten users with the most votes:");
		for(int j = 0; j < 10; j++){
			System.out.println(listTwo.get(j).getUser());
		}
		
		
		
		
		System.exit(exitCode);
	}

	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.printf("Usage: %s needs two arguments, input and output files\n", getClass().getSimpleName());
			return -1;
		}

		Job job = new Job();
		job.setJarByClass(WordCountDriver.class);
		job.setJobName("WordCounter");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setMapperClass(WordCountMapClass.class);
		job.setReducerClass(WordCountReduceClass.class);

		int returnValue = job.waitForCompletion(true) ? 0:1;

		if (job.isSuccessful()) {
			System.out.println("Job was successful");
		} else if(!job.isSuccessful()) {
			System.out.println("Job was not successful");
//			return returnValue;
		}
		
		
		Job userJob = new Job();
		userJob.setJarByClass(WordCountDriver.class);
		userJob.setJobName("UserCounter");

		FileInputFormat.addInputPath(userJob, new Path(args[0]));
		FileOutputFormat.setOutputPath(userJob, new Path("/home/ashkan/workspace/cs499assignment3/outputtwo.txt"));

		userJob.setOutputKeyClass(Text.class);
		userJob.setOutputValueClass(IntWritable.class);
		userJob.setOutputFormatClass(TextOutputFormat.class);

		userJob.setMapperClass(UserCountMapClass.class);
		userJob.setReducerClass(UserCountReduceClass.class);

		int returnValueTwo = userJob.waitForCompletion(true) ? 0:1;

		if (userJob.isSuccessful()) {
			System.out.println("Job was successful");
		} else if(userJob.isSuccessful()) {
			System.out.println("Job was not successful");
			
		}
		return returnValueTwo;
	}

}