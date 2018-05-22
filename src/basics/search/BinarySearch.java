package basics.search;

import java.util.ArrayList;
import basics.InputGenerator;

public class BinarySearch {

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();

		int key = 5;
		int[] list;
		int index;
		
		//Test for empty array
		System.out.println("-------------------TEST CASE: empty array---------------------");
		list = ig.makeSortedArray(0, 9);
		System.out.println("list: " + ig.toArrayList(list));
		System.out.println("key: " + key);
		System.out.printf("low: %d, high: %d\n", 0, (list.length - 1));
		index = binarySearch(list, key, 0, list.length - 1);
		System.out.println("binarySearch(list, key, 0, list.length - 1) returns " + index);
		
		//Run test for normal case a few times
		for (int i = 1; i <= 5; i++) {
			System.out.printf("-----------------------------TEST # %d---------------------------\n", i);
			list = ig.makeSortedArray(10, 9);
			key = ig.makeInt(9);
			System.out.println("list: " + ig.toArrayList(list));
			System.out.println("key: " + key);
			System.out.printf("low: %d, high: %d\n", 0, (list.length - 1));
			index = binarySearch(list, key, 0, list.length - 1);
			System.out.println("binarySearch(list, key, 0, list.length - 1) returns " + index);
		}
	}
	
	
	
	public static int binSearch
			(ArrayList<Integer> A, int key, int low, int high) {
		//base case
		if(high<low)
			return -1;
		
		int mid = (low + high) / 2;

		if(key < A.get(mid))
			return binSearch(A, key, low, mid-1);
		if(key > A.get(mid))
			return binSearch(A, key, mid+1, high);
		
		return mid;
	}
	
	public static int binarySearch(int[] list, int key, int low, int high) {
		//base case
		if (high < low)
			return -1;
		
		//recursive case
		int mid = (low + high)/2;
		
		if (key < list[mid])
			return binarySearch(list, key, low, mid - 1);
		if (key > list[mid])
			return binarySearch(list, key, mid+1, high);
		
		return mid;
		
	}

}
