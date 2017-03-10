package cs499assignment3;
import java.util.Comparator;

public class MyComparator implements Comparator<Movie> {
	
	
	public int compare(Movie o1, Movie o2){
		if(o1.getRating() > o2.getRating()){
			return -1;
		}else if (o1.getRating() < o2.getRating()){
			return 1;
		}
		return 0;
	}
	

}
