package cs499assignment3;

public class User {
	private String id;
	private int rank;
	
	public User (String idN, int rankN){
		id = idN;
		rank = rankN;
	}
	
	public int getRank(){
		return rank;
	}
	
	public String getUser(){
		return id;
	}

}
