package cs499assignment3;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {
	
	


	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		if(o1.getRank() > o2.getRank()){
			return -1;
		}else if (o1.getRank() < o2.getRank()){
			return 1;
		}
		return 0;
	}
}
