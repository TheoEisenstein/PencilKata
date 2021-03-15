package pencilKata;

import java.util.ArrayList;

public class Pencil {

	public ArrayList<String> paper = new ArrayList<String>();
	private int durability = 0;
	private String dullText = "";
	

	public int getDurability() {
		
		if (paper.isEmpty()) {
			return 40000;
		}
		String writingAnalysis = paper.toString().substring(1, paper.toString().length() - 1).replaceAll(" ", "");
		for (int i = 0; i < writingAnalysis.length(); i++) {
			if (Character.isUpperCase(writingAnalysis.charAt(i))) {
				durability = durability + 2;
			}
			if (Character.isLowerCase(writingAnalysis.charAt(i))) {
				durability = durability + 1;

			}

		}
		return 40000 - durability;
	}

	public String getWriting() {
		String existingText = "";
		
		if(!paper.isEmpty()) {
			for (int i = 0; i <paper.size();i++) {
				existingText = existingText+(paper.get(i)+" ");
			}
			return existingText.substring(0,existingText.length()-1);
		}
			
		return paper.toString();

	}

	public String write(String input) {
		
		if(durability==-1) {
			for(int i = 0; i <input.length();i++) {
				dullText = dullText+" ";
			}
		
			paper.add(dullText);
			return paper.toString();
		}
		
		paper.add(input);
		return paper.toString();
		
	}

	public int setDurability(int inputDurability) {
		durability = -1;
		return -1;
		
	}

}
