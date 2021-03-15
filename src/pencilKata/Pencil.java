package pencilKata;

import java.util.ArrayList;

public class Pencil {

	public ArrayList<String> paper = new ArrayList<String>();

	public int getDurability() {
		
		return 40000;
	}

	public String getWriting() {
		
		return "Food";
		
	}

	public String write(String input) {
		
		paper.add(input);
		return paper.toString();
		
	}


}
