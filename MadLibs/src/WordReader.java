import java.util.Scanner;

public class WordReader {

	private String outputFile = "output.txt";

	public static Scanner openFile(String filename) {

		File f = new File(filename);
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			return null;
		}
		return input;
	}

	public static PrintWriter canBeOpened(String filename, int part) {

		File f = new File(filename);
		PrintWriter output = null;
		try {
			output = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			PrintWriter out = new PrintWriter(outputFile);
			out.println("Part" + part + ": Unable to Open File")
			return null;
		}
		return output;
	}


	/*
	 * public static void writeJava(Scanner input, PrintWriter output) { while
	 * (input.hasNextLine()) {
	 * 
	 * String word = input.nextLine().toUpperCase();
	 * 
	 * if (word.length() >= 3 && word.length() <= 5) { output.println("\t\t\"" +
	 * word + "\","); } }
	 * 
	 * }
	 * 
	 * public static void writeJavaHeader(PrintWriter output) {
	 * output.println("public class RamblecsDictionary\n{");
	 * output.println("out\tprivate String[] words = \n\t{"); }
	 * 
	 * public static void writeJavaFooter(PrintWriter output) {
	 * output.println("\t};\n}"); }
	 */

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Not enough files provided");
			System.exit(1);
		}

		Scanner in = openFile(args[0]);
		if (in == null)
			System.exit(1);

		PrintWriter out = openDictionary(args[1]);

		part1();
		part2();
		

	}

	public static void part1() {
		canBeOpened(args[0], 1);
		Scanner p1 = openFile(args[0], 1);
		if (checkBraces(p1)) {
			output.println("Braces Balanced\n");
		} else {
			output.println("Braces Not Balanced\n");
		}
		
	}
	
	public static void part2(){
		canBeOpened(args[1], 2);
		Scanner p2 = openFile(args[1], 2);
		if compareFiles(){
			output.println("Files Identical\n");
		}
		else{
			output.println("Files Not Identical\n");
		}
	}
	
	public static void part3(){
		
	}
	
	public static boolean compareFiles(){
		
		
	}

	public static boolean checkBraces(Scanner in) {
		int openBrace = 0;
		int closedBrace = 0;
		
		while(in.hasNextLine()) {
			char[] c = in.nextLine().toCharArray();
			for (char c : s) {
				if (c== '{') {
					openBrace++;
				}
				else (c== '{'){
					closedBrace++;
				}
			}
	
		}
		if (openBrace == closedBrace){
			return true;
		}
		else
			return false;
		
	}

}
