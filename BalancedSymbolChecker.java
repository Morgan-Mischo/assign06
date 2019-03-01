package assign06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker && Morgan Mischo && Casey Rand
 * @version ??
 */
public class BalancedSymbolChecker {

	/**
	 * Generates a message indicating whether the input file has unmatched
	 * symbols. (Use the helper methods below for constructing messages.)
	 * 
	 * @param filename - name of the input file to check
	 * @return a message indicating whether the input file has unmatched symbols
	 * @throws FileNotFoundException if the file does not exist
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		File f = new File(filename); 
		
		if (!f.isFile())
		{
			throw new FileNotFoundException (); 
		}
		
		ArrayStack<Character> myStack = new ArrayStack<Character>(); 
		
		Scanner lineScan = new Scanner (f); 
		int lineCount = 0;
		boolean commentsClosed = true;


		//Continue looping while there are lines to scan.
		while (lineScan.hasNextLine())
		{
			lineCount++;
			String newLine = lineScan.nextLine();
			System.out.println(newLine.length());
			for (int i = 0; i < newLine.length(); i++)
			{
				char nextChar = newLine.charAt(i);
				//Check for a comments thread
				if (i < newLine.length() - 2)
				{
					if (nextChar == '/' && newLine.charAt(i+1) == '*' && newLine.charAt(i+2) == '*')
						commentsClosed = false;
				}
				//Check if the open comments thread has closed
				if (i < newLine.length() - 1 && !commentsClosed)
				{
					if (nextChar == '*' && newLine.charAt(i+1) == '/')
						commentsClosed = true;
				}
				
				if (commentsClosed)
				{
					if (nextChar == '(' || nextChar == '{' || nextChar == '[' )
					{
						myStack.push(nextChar);
					}
					else if (nextChar == ')' || nextChar == '}' || nextChar == '}')
					{
						char expectedChar = myStack.pop();
						if(expectedChar == nextChar) 
						{
							//i + 1 can be used to effectively track column number
							return unmatchedSymbol(lineCount, i + 1, nextChar, expectedChar);
						}
					}
				}
			}
		}
		lineScan.close();
		
		if(!commentsClosed)
			return unfinishedComment();
		
		else if(!myStack.isEmpty())
			return unmatchedSymbolAtEOF(myStack.pop());
		
		else
			return allSymbolsMatch();
	}

	/**
	 * Use this error message in the case of an unmatched symbol.
	 * 
	 * @param lineNumber - the line number of the input file where the matching symbol was expected
	 * @param colNumber - the column number of the input file where the matching symbol was expected
	 * @param symbolRead - the symbol read that did not match
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Use this error message in the case of an unmatched symbol at the end of the file.
	 * 
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Use this error message in the case of an unfinished comment
	 * (i.e., a file that ends with an open /* comment).
	 * 
	 * @return the error message
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Use this message when no unmatched symbol errors are found in the entire file.
	 * 
	 * @return the success message
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}