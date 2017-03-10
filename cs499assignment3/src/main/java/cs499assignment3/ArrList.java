package cs499assignment3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrList {
	private ArrayList<Movie> list;
	private ArrayList<User> listTwo;
	
	public ArrList() {
		File file = new File("/home/ashkan/workspace/cs499assignment3/output.txt/part-r-00000");
		list = new ArrayList<Movie>();

		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				list.add(new Movie(sc.nextInt(), sc.nextFloat()));
				sc.nextLine();
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrList(String fileLoc){
		File file = new File(fileLoc);
		listTwo = new ArrayList<User>();

		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				listTwo.add(new User(sc.next(), sc.nextInt()));
				sc.nextLine();
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Movie> getList(){
		return list;
	}
	
	public ArrayList<User> getUserList(){
		return listTwo;
	}
	
}
