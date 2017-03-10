package cs499assignment3;

public class Movie {
	
	private int title;
	private float rating;
	
	public Movie(int titleN, float ratingN){
		title = titleN;
		rating = ratingN;
	}
	
	
	public int getTitle(){
		return title;
	}
	
	public float getRating(){
		return rating;
	}
	
//	public void setTitle(String ntitle){
//		title = ntitle;
//	}
//	
//	public void setRating(Float nrating){
//		rating = nrating;
//	}
}
