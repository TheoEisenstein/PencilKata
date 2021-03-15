package pencilKata;

import java.util.ArrayList;

public class Pencil {

	public ArrayList<String> paper = new ArrayList<String>();

	public int getDurability() {
		if(paper==null) {
			return 40000;
		}
		return 40000 - paper.toString().substring(1,paper.toString().length()-1).replaceAll(" ", "").length();
	}

	public String getWriting() {
		
		return paper.toString();
		
	}

	public String write(String input) {
		
		paper.add(input);
		return paper.toString();
		
	}


}
