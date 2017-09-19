import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChoosingWords {

	public static Scanner openWords(String filename) {

		File f = new File(filename);
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			return null;
		}
		return input;
	}

	public static PrintWriter openDictionary(String filename) {

		File f = new File(filename);
		PrintWriter output = null;
		try {
			output = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			return null;
		}
		return output;
	}

	public static void writeJava(Scanner input, PrintWriter output) {
		while (input.hasNextLine()) {

			String word = input.nextLine().toUpperCase();

			if (word.length() >= 3 && word.length() <= 5) {
				output.println("\t\t\"" + word + "\",");
			}
		}

	}
	
	public static void writeJavaHeader(PrintWriter output) {
		output.println("public class RamblecsDictionary\n{");
		output.println("out\tprivate String[] words = \n\t{");
	}
	
	public static void writeJavaFooter(PrintWriter output) {
		output.println("\t};\n}");
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Not enough files provided");
			System.exit(1);
		}
		Scanner in = openWords(args[0]);
		if (in == null)
			System.exit(1);

		PrintWriter out = openDictionary(args[1]);
		writeJavaHeader(out);
		writeJava(in, out);
		writeJavaFooter(out);

		in.close();
		out.close();
	}

}
