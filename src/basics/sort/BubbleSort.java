package basics.sort;

import java.util.ArrayList;

import basics.InputGenerator;

public class BubbleSort {

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		
		ArrayList<Integer> A = ig.makeArrayList(5, 20);
		System.out.println(A);
		bubbleSort(A);
		System.out.println(A);
	}
	public static void bubbleSort(ArrayList<Integer> A) {
		boolean swapped;
		Integer temp;
		for(int i = 0; i < A.size() - 1; i++) {
			swapped = false;
			for (int j = A.size() - 1; j > i; j--) {
				if (A.get(j) < A.get(j-1)) {
					temp = A.get(j);
					A.set(j, A.get(j -1));
					A.set(j - 1, temp);
					swapped = true;
				}
			}
			
			if(!swapped) break;

		}
		
	}
}
