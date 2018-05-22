package basics.sort;

import java.util.Arrays;
import java.util.Random;

public class GenericSorts {

	public static<E extends Comparable<E>> void bubbleSort(E[] list) {
		int numToSort = list.length;
		int indexOfLastSwap;
		do {
			indexOfLastSwap = 0;
			for (int i = 1; i < numToSort; i++) {
				if (list[i - 1].compareTo(list[i]) > 0) {
					swap(list, i, i - 1);
					indexOfLastSwap = i;
				}
			}
			numToSort = indexOfLastSwap;
		}
		while (numToSort > 0);	
	}

	public static<E extends Comparable<E>> void insertionSort(E[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0 && list[j - 1].compareTo(list[j]) > 0 ; j--) { 
				swap(list, j, j - 1);
			}
		}	
	}
	
	private static <E> void swap(E[] list, int i, int j) {
		E temp = list[i];
		list[i] = list[j];
		list[j] = temp;	
	}
	

	
	public static void main(String[] args) {
		String[] stringList;	
		Integer[] intList;

		//////// TEST BUBBLE-SORT ///////////////////////////////////////////////////////
		System.out.println("=== TEST BUBBLE-SORT on String[] ========================");

		stringList = generateStringArray(0);
		displayBubbleSortTest(stringList);	
		stringList = generateStringArray(1);
		displayBubbleSortTest(stringList);
		stringList = generateStringArray(10);
		displayBubbleSortTest(stringList);
		
		System.out.println("=== TEST BUBBLE-SORT on Integer[] =======================");	
		intList = generateIntegerArray(0);
		displayBubbleSortTest(intList);	
		intList = generateIntegerArray(1);
		displayBubbleSortTest(intList);
		intList = generateIntegerArray(10);
		displayBubbleSortTest(intList);

		System.out.println("=== TEST INSERTION-SORT on String[] =====================");	
		stringList = generateStringArray(0);
		displayInsertionSortTest(stringList);	
		stringList = generateStringArray(1);
		displayInsertionSortTest(stringList);
		stringList = generateStringArray(10);
		displayInsertionSortTest(stringList);

		System.out.println("=== TEST INSERTION-SORT on Integer[] ====================");	
		intList = generateIntegerArray(0);
		displayInsertionSortTest(intList);	
		intList = generateIntegerArray(1);
		displayInsertionSortTest(intList);
		intList = generateIntegerArray(10);
		displayInsertionSortTest(intList);
	}
	
	private static String[] generateStringArray(int length) {
		String[] array = new String[length];
		
		Random r = new Random();
		StringBuilder sb;
		int strLength;
		for (int i = 0; i < length; i++) {
			sb = new StringBuilder();
			strLength = 1 + r.nextInt(3);
			for (int j = 0; j < strLength; j ++)
				sb.append((char) (65 + r.nextInt(26)));
			array[i] = sb.toString();	
		}
		
		return array;
	}
	
	private static Integer[] generateIntegerArray(int length) {
		Integer[] array = new Integer[length];
		
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			array[i] = r.nextInt(20);	
		}
		
		return array;
	}
	
	private static <E extends Comparable<E>> void displayBubbleSortTest(E[] list) {
		System.out.println("ORIGINAL: " + Arrays.toString(list));
		bubbleSort(list);
		System.out.println("SORTED:   " + Arrays.toString(list));
		System.out.println();
	}
	
	private static <E extends Comparable<E>> void displayInsertionSortTest(E[] list) {
		System.out.println("ORIGINAL: " + Arrays.toString(list));
		insertionSort(list);
		System.out.println("SORTED:   " + Arrays.toString(list));
		System.out.println();
	}

	
	

}
