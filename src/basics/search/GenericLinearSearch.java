package basics.search;

import java.util.Arrays;

public class GenericLinearSearch {
	
	public static <E extends Comparable<E>>
		int linearSearch(E[] list, E key) {
		
		int index = -1;
		for (int i = 0; i < list.length; i++) {
			if (key.compareTo(list[i]) == 0) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	


	public static void main(String[] args) {
		
		////////////////// Test ArrayList<String> ///////////////////////////////////
		System.out.println("=== TEST 1: String[] =======================");
		String[] stringList = {"aaa", "bbb", "aaa", "ccc", "aaa"};
		System.out.println("list: " + Arrays.toString(stringList));
		System.out.println("index of bbb:  " + linearSearch(stringList, "bbb"));
		System.out.println("index of f  :  " + linearSearch(stringList, "f"));
		System.out.println();
		
		////////////////// Test ArrayList<Integer> ///////////////////////////////////
		System.out.println("=== TEST 2: Integer[] ======================");
		Integer[] intList = {1, 1, 3, 4, 3, 5};
		System.out.println("list: " + Arrays.toString(intList));
		System.out.println("index of 3:  " + linearSearch(intList, 3));
		System.out.println("index of 8:  " + linearSearch(intList, 8));
		System.out.println();

	}

}
