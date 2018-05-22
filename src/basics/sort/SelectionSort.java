package basics.sort;

import java.util.ArrayList;

import basics.InputGenerator;

public class SelectionSort {

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		ArrayList<Integer> A = ig.makeArrayList(5, 100);
		
		System.out.println(A);
		selectionSort(A);
		System.out.println(A);
	}
	
	public static void selectionSort(ArrayList<Integer> A) {
		for (int j=0; j<A.size()-1; j++) {
			Integer smallest = A.get(j);
			int swapIndex = -1;
			for (int i=j+1; i<A.size(); i++) {
				if(A.get(i) < smallest) {
					smallest = A.get(i);
					swapIndex = i;
				}
			}
			if(swapIndex >= 0) {
				Integer temp = A.get(j);
				A.set(j, smallest);
				A.set(swapIndex, temp);
			}
		}
	}

}
