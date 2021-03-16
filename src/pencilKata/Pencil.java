package pencilKata;

import java.util.ArrayList;

public class Pencil {

	public ArrayList<String> paper = new ArrayList<String>();
	private int durability = 40000;
	private int requiredDurability;
	private String dullText = "";
	private int spaces = 0;
	private int lengthPencil = 4;
	private int eraserDurability = 50;

	public int writingAnalysis(String input) {
		String inputSpaceless = input.replaceAll(" ", "");
		requiredDurability = 0;
		for (int i = 0; i < inputSpaceless.length(); i++) {
			if (Character.isUpperCase(inputSpaceless.charAt(i))) {
				requiredDurability = requiredDurability + 2;
			}
			if (Character.isLowerCase(inputSpaceless.charAt(i))) {
				requiredDurability = requiredDurability + 1;

			}
		}
		return requiredDurability;
	}

	public int getDurability() {

		if (paper.isEmpty()) {
			return durability;
		}

		requiredDurability = writingAnalysis(paper.get(0).toString());
		return (durability - requiredDurability);

	}

	public String getWriting() {
		String existingText = "";

		if (!paper.isEmpty()) {
			for (int i = 0; i < paper.size(); i++) {
				existingText = existingText + (paper.get(i) + " ");
			}
			return existingText.substring(0, existingText.length() - 1);
		}

		return paper.toString();

	}

	public String write(String input) {

		if (durability <= 0) {
			for (int i = 0; i < input.length(); i++) {
				dullText = dullText + " ";
			}

			paper.add(dullText);
			return paper.toString();
		}

		if (writingAnalysis(input) > durability) {
			spaces = requiredDurability - durability;
			String spaceToAdd = "";
			for (int j = 0; j < spaces; j++) {
				spaceToAdd = spaceToAdd + " ";
			}
			paper.add(input.substring(0, durability) + spaceToAdd);
			return paper.toString();
		}

		paper.add(input);
		return paper.toString();

	}

	public int setDurability(int inputDurability) {
		durability = inputDurability;
		return durability;

	}

	public int sharpen() {

		if (lengthPencil < 1) {

			return getDurability();
		}
		lengthPencil--;
		durability = 40000;
		return durability;

	}

	public int setLength(int length) {
		lengthPencil = length;
		return length;

	}

	public int getLength() {

		return lengthPencil;
	}

	public String eraseTarget(String toErase) {
		String writing = getWriting();
		if (toErase.length() > eraserDurability)
			toErase = toErase.substring(eraserDurability);
		int eraseStart = writing.lastIndexOf(toErase);
		int eraseSpace = toErase.length();
		String theReplaceSpace = "";
		for (int i = 0; i < eraseSpace; i++) {
			theReplaceSpace = theReplaceSpace + " ";
		}

		paper.clear();
		writing = writing.substring(0, eraseStart) + theReplaceSpace + writing.substring(eraseStart + eraseSpace);
		paper.add(writing);
		return writing;

	}

	public String erase(int numToErase) {
		String writing = getWriting();
		if (numToErase > eraserDurability)
			numToErase = eraserDurability;
		String theReplaceSpace = "";
		for (int i = 0; i < numToErase; i++) {
			theReplaceSpace = theReplaceSpace + " ";
		}

		paper.clear();
		writing = writing.substring(0, writing.length() - numToErase) + theReplaceSpace;
		paper.add(writing);
		eraserDurability -= numToErase;
		return writing;

	}

	public int getEraserDurability() {
		return eraserDurability;
	}

	public int setEraserDurability(int input) {
		eraserDurability = input;
		return eraserDurability;

	}

	public String editText(String string) {
		String writing = getWriting();
		int editStart = writing.indexOf("  "); //Weak
		paper.clear();
		writing = writing.substring(0, editStart + 1) + string + writing.substring(editStart + string.length());
		paper.add(writing);
		return writing;

	}

}
