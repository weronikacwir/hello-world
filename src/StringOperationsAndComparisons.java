
public class StringOperationsAndComparisons {

	public static void main(String[] args) {
		
		System.out.println
			("---- assigment of identical literals --------------------------");
		String s1 = "Hello ";
		System.out.println
			("String s1 = \"Hello \";");
		String s2 = "Hello ";
		System.out.println
			("String s2 = \"Hello \";");
		printComparison(s1, s2);
		
		System.out.println
			("----- + versus concat() ---------------------------------------");
		s1 = s1 + "World";
		System.out.println
			("s1 = s1 + \"World\";");
		s2 = s2.concat("World");
		System.out.println
			("s2 = s2.concat(\"World\");");
		printComparison(s1, s2);
		
		System.out.println
			("----- back to the identical literal using substring() ---------");
		s1 = s1.substring(0,5);
		System.out.println
			("s1 = s1.substring(0,5);");
		s2 = s2.substring(0,5);
		System.out.println
			("s2 = s2.substring(0,5);");
		printComparison(s1, s2);
		
		System.out.println
			("----- start fresh with assignment of identical literal --------");
		s1 = "Hello ";
		System.out.println
			("s1 = \"Hello \";");
		s2 = "Hello ";
		System.out.println
			("s2 = \"Hello \";");
		printComparison(s1, s2);
		
		System.out.println
			("----- now modify both variables using + -----------------------");
		s1 = s1 + "World";
		System.out.println
			("s1 = s1 + \"World\";");	
		s2 = s2 + "World";
		System.out.println
			("s2 = s2 + \"World\";");	
		printComparison(s1, s2);	
		
		System.out.println
			("----- start fresh with assignment of identical literal --------");	
		s1 = "Hello ";
		System.out.println
			("String s1 = \"Hello \";");
		s2 = "Hello ";
		System.out.println
			("String s2 = \"Hello \";");
		printComparison(s1, s2);
		
		System.out.println
			("----- use substring() that returns the whole string -----------");
		s1 = s1.substring(0,s1.length());
		System.out.println
			("s1 = s1.substring(0,s1.length());");
		s2 = s2.substring(0,s2.length());
		System.out.println
			("s2 = s2.substring(0,s2.length());");
		printComparison(s1, s2);
		
		System.out.println
			("----- create one string from another using substring(0) --------");
		s1 = "Hello World";
		System.out.println
			("s1 = \"Hello World\";");
		s2 = s1.substring(0);
		System.out.println
			("s2 = s1.substring(0);");
		printComparison(s1, s2);		
		
		System.out.println
			("----- start fresh with assignment of identical literal --------");
		s1 = "Hello ";
		System.out.println
			("s1 = \"Hello \";");
		s2 = "Hello ";
		System.out.println
			("s2 = \"Hello \";");
		printComparison(s1, s2);		
		
		System.out.println
			("----- modify both variables using concat() --------------------");
		s1 = s1.concat("World");
		System.out.println
			("s1 = s1.concat(\"World\");");
		s2 = s2.concat("World");
		System.out.println
			("s2 = s2.concat(\"World\");");	
		printComparison(s1, s2);
		
		System.out.println
			("----- start fresh with assignment of identical literal --------");
		s1 = "Hello World";
		System.out.println("s1 = \"Hello World\";");
		s2 = "Hello World";
		System.out.println("s2 = \"Hello World\";");
		printComparison(s1, s2);
		
		System.out.println
			("----- use trim() for (s1==s2)=true and s1 has no white space --");
		s1 = s1.trim();
		System.out.println
			("s1 = s1.trim();");
		s2 = s2.trim();
		System.out.println
			("s2 = s2.trim();");	
		printComparison(s1, s2);

		System.out.println
			("----- start fresh with assignment of identical literal --------");
		s1 = "Hello ";
		System.out.println
			("s1 = \"Hello \";");
		s2 = "Hello ";
		System.out.println
			("s2 = \"Hello \";");
		printComparison(s1, s2);				

		System.out.println
			("----- use trim() for (s1==s2)=true and s1 has white space -----");
		s1 = s1.trim();
		System.out.println
			("s1 = s1.trim();");
		s2 = s2.trim();
		System.out.println
			("s2 = s2.trim();");
		printComparison(s1, s2);
		
		System.out.println
			("----- create identical Strings in different ways --------------");
		s1 = "Hello World";
		System.out.println
			("s1 = \"Hello World\";");
		s2 = "Hello ";
		System.out.println
			("s2 = \"Hello \";");
		s2 += "World";
		System.out.println
			("s2 += \"World\";");
		printComparison(s1, s2);
		
		System.out.println
			("----- create identical Strings in different ways --------------");
		s1 = "Hello " + "World";
		System.out.println
			("s1 = \"Hello \" + \"World\";");
		s2 = "Hello ";
		System.out.println
			("s2 = \"Hello \";");
		s2 += "World";
		System.out.println
			("s2 += \"World\";");
		printComparison(s1, s2);

		System.out.println
			("----- create identical Strings in the same way using + ---------");
		s1 = "Hello " + "World";
		System.out.println
			("s1 = \"Hello \" + \"World\";");
		s2 = "Hello " + "World";
		System.out.println
			("s2 = \"Hello \" + \"World\";");
		printComparison(s1, s2);
		
		System.out.println
			("----- create identical Strings in different ways ----------------");
		s1 = "Hello World";
		System.out.println
			("s1 = \"Hello World\";");	
		s2 = "Hello " + "World";
		System.out.println
			("s2 = \"Hello \" + \"World\";");
		printComparison(s1, s2);
		
		System.out.println
			("----- create identical Strings in different ways ----------------");
		s1 = "Hello " +  "World";
		System.out.println
			("s1 = \"Hello \" +  \"World\";");	
		System.out.println
			("s1.substring(6) is " + s1.substring(6));
		s2 = "Hello " + s1.substring(6);
		System.out.println
			("s2 = \"Hello \" + s1.substring(6);");
		printComparison(s1, s2);		

		System.out.println
			("----- create identical Strings in different ways ----------------");
		s1 = "Hello " + "World";
		System.out.println
			("s1 = \"Hello \" + \"World\";");	
		System.out.println 
			("s1.substring(6).intern() is " + s1.substring(6).intern());		
		s2 = "Hello " + (s1.substring(6)).intern();
		System.out.println
			("s2 = \"Hello \" + (s1.substring(6)).intern();");
		printComparison(s1, s2);	
		System.out.println
			("(\"Hello World\" == s1) is: " 
				+ Boolean.toString("Hello World" == s1));
		System.out.println
			("(\"Hello World\" == s2) is: " 
				+ Boolean.toString("Hello World" == s2));
		
		System.out.println
			("----- create one string from another using intern() ------------");
		s1 = "Hello World";
		System.out.println
			("s1 = \"Hello World\");");
		s2 = s1.intern();
		System.out.println
			("s2 = s1.intern();");
		printComparison(s1, s2);
	}
	
	private static void printComparison(String s1, String s2) {
		System.out.println
			("s1 is: " + s1);
		System.out.println
			("s2 is: " + s2);
		System.out.println
			("(s1.equals(s2)) evaluates to: " + Boolean.toString(s1.equals(s2)));
		System.out.println
			("(s1 == s2) evaluates to: " + Boolean.toString(s1 == s2));
		System.out.println();
		
	}

}
