package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class BalancedSymbolCheckerTests {
	
	@Test
	void class1()
	{
		String f = "/src/assign06/Class1.java";
		
		System.out.println(BalancedSymbolChecker.checkFile(f));
	}
	
}