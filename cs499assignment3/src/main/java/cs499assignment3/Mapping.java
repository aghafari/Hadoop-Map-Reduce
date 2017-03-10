package cs499assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Mapping {
	private HashMap<Integer, String> map;
	
	public Mapping(){
		File file = new File("/home/ashkan/workspace/cs499assignment3/data.txt");
		map = new HashMap<Integer, String>();
		
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				map.put(sc.nextInt(), sc.nextLine());
	
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<Integer, String> getMap(){
		return map;
	}
}
