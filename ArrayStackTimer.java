package assign06;

public class ArrayStackTimer {

	public static <E> void main(String[] args) {

		final int timesToLoop = 1000000; 
		
		for (int n = 100000; n <= timesToLoop; n += 100000)
		{
			ArrayStack<String> myStack = new ArrayStack<>(); 

			long startTime, midpointTime, stopTime;


		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();


		for (int i = 1000; i <= timesToLoop; i += 10)
		{
			myStack.push("hello"); 
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		for (int i = 0; i < timesToLoop; i++) {

		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (double) timesToLoop;
		System.out.println("push " + " " + n + "\t" + averageTime);
		}
		
		/**
		 * Testing peek
		 */
		
		
		for (int n = 100000; n <= timesToLoop; n += 100000)
		{
			ArrayStack<String> myStack = new ArrayStack<>(); 

			long startTime, midpointTime, stopTime;
			
			for (int i = 0; i < timesToLoop; i++)
			{
				myStack.push("hello"); 
				
			}


		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();
		
		for (int i = 1000; i <= timesToLoop; i += 10)
		{
			myStack.peek(); 
		}


		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		for (int i = 0; i < timesToLoop; i++) {

		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (double) timesToLoop;
		System.out.println("peek " + n + "\t" + averageTime);
		}
		
		/** 
		 * Testing pop
		 */
		
		for (int n = 100000; n <= timesToLoop; n += 100000)
		{
			ArrayStack<String> myStack = new ArrayStack<>(); 

			long startTime, midpointTime, stopTime;
			
			for (int i = 0; i < timesToLoop; i++)
			{
				myStack.push("hello"); 
				
			}


		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();
		
		for (int i = 1000; i <= timesToLoop; i += 10)
		{
			myStack.pop(); 
		}


		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		for (int i = 0; i < timesToLoop; i++) {

		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (double) timesToLoop;
		System.out.println("pop " + n + "\t" + averageTime);
		}
		
	}
}

