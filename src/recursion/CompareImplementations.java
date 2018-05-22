package recursion;
/**
 * Compares running time of naive and optimized implementations 
 * of some recursive methods.
 */
public class CompareImplementations {

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		
		//Print header
		System.out.printf("%-81s%s\n", "METHOD", "TIME IN NANOSECONDS");
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		//Compare powerN
		System.out.printf("%-75s", "Recursion.powerN(1.1, 5000): ");
		sw.start();
		Recursion.powerN(1.1, 5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "OptimizedRecursion.powerN(1.1, 5000): ");
		sw.start();
		OptimizedRecursion.powerN(1.1, 5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "Math.pow(1.1, 5000): ");
		sw.start();
		Math.pow(1.1, 5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();
		
		//Compare harmonicSum
		System.out.printf("%-75s", "Recursion.harmonicSum(5000): ");
		sw.start();
		Recursion.harmonicSum(5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "OptimizedRecursion.harmonicSum(5000): ");
		sw.start();
		OptimizedRecursion.harmonicSum(5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();		
		
		//Compare reverseDisplay
		System.out.printf("%-65s", "Recursion.reverseDisplay(Integer.MAX_VALUE): ");
		sw.start();
		Recursion.reverseDisplay(Integer.MAX_VALUE);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-65s", "OptimizedRecursion.reverseDisplay(Integer.MAX_VALUE): ");
		sw.start();
		OptimizedRecursion.reverseDisplay(Integer.MAX_VALUE);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();			

		//Compare recursiveContains
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			sb.append('a');
		}
		String s = sb.toString();
		System.out.println("(Note: s is a string of 1000 characters 'a')");
		
		System.out.printf("%-75s", "Recursion.recursiveContains('b', s): ");
		sw.start();
		Recursion.recursiveContains('b', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "OptimizedRecursion.recursiveContains('b', s): ");
		sw.start();
		OptimizedRecursion.recursiveContains('b', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "s.contains('b' + \"\"): ");
		sw.start();
		s.contains('b' + "");
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();
		
		//Compare recursiveAllCharactersSame
		System.out.println("(Note: s is a string of 1000 characters 'a')");
		
		System.out.printf("%-75s", "Recursion.recursiveAllCharactersSame(s): ");
		sw.start();
		Recursion.recursiveAllCharactersSame(s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "OptimizedRecursion.recursiveAllCharactersSame(s): ");
		sw.start();
		OptimizedRecursion.recursiveAllCharactersSame(s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();	
		
		//Compare recursiveCount
		System.out.println("(Note: s is a string of 1000 characters 'a')");
		
		System.out.printf("%-75s", "Recursion.recursiveCount('a', s): ");
		sw.start();
		Recursion.recursiveCount('a', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		
		System.out.printf("%-75s", "OptimizedRecursion.recursiveCount('a', s): ");
		sw.start();
		OptimizedRecursion.recursiveCount('a', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();	
	}

}

class StopWatch {
	private long startTime;
	private long endTime;
	
	StopWatch() {
		startTime = System.nanoTime();
	}
	
	long getStartTime() {
		return startTime;
	}
	
	long getEndTime() {
		return endTime;
	}
	
	void start() {
		startTime = System.nanoTime();
	}
	
	void stop() {
		endTime = System.nanoTime();
	}
	
	long getElapsedTime() {
		return endTime - startTime;
	}
}

