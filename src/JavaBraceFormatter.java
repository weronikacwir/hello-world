

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Converts Java source code from the next-line brace style
 * to end-of-line brace style.
 * 
 * Takes name of a Java source file as input.
 * 
 * @author weron
 *
 */
public class JavaBraceFormatter {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println
				("Usage: this program takes name of java source file as input.");
			System.exit(1);
		}
		
		String srcFileName = args[0];
		if(!srcFileName.matches(".*.java")) {
			System.out.println
				(srcFileName + " does not appear to be a Java source file.");
			System.exit(2);
		}
		
		// The original file:
		File srcFile = new File(srcFileName);
			
		// The output will be written here:
		File temp = new File("lab02_3_q_10_temp.java");
				
		try {
			Scanner reader = new Scanner(srcFile);
			PrintWriter writer = new PrintWriter(temp);
			
			while(reader.hasNextLine()) {
				// Read a line of code from the source file.
				String line = reader.nextLine();
				
				// if the next line consists of "{" with white space on either side...
				if (reader.hasNext(Pattern.compile("\\{", Pattern.COMMENTS))) {
					// put " {" at the end of this line...
					writer.println(line + " {");
					// and advance past the next line.
					reader.nextLine();
				}
				// Otherwise... 
				else {
					// just print the line as is.
					writer.println(line);	
				}
				writer.flush();
			}
			
			reader.close();
			writer.close();
			
			// Delete the original file...
			srcFile.delete();
			
			// And give its name to the temp file
			temp.renameTo(srcFile);
		}
		catch(FileNotFoundException fnfe) {
			System.out.println
				(srcFile.getAbsolutePath() + "does not exist.");
			
		}
		
	}

}
