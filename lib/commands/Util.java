package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}

	
	public static String[] readLines(String document) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(document));
		ArrayList<String> output = new ArrayList<String>();
		
		String inputString = reader.readLine();
		while(inputString != null) {
			output.add(inputString);
			inputString = reader.readLine();
		}
		reader.close();
		return output.toArray(new String[output.size()]);
	}
}
