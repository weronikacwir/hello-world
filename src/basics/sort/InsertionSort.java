package basics.sort;

import java.util.ArrayList;

import basics.InputGenerator;

public class InsertionSort {

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		ArrayList<Integer> A = ig.makeArrayList(5, 100);
		
		System.out.println(A);
		insertionSort(A);
		System.out.println(A);
		
	}
	
	public static void insertionSort(ArrayList<Integer> A) {
		for (int j=1; j < A.size(); j++) {
			Integer key = A.remove(j);
			int i = j-1;
			while((i >= 0) && (A.get(i) > key)) {
				i--;
			}
			A.add(i+1, key);
		}
	}

}
