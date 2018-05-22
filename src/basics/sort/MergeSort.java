package basics.sort;

import java.util.ArrayList;

import basics.InputGenerator;

public class MergeSort {

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		ArrayList<Integer> A;

		A = ig.makeArrayList(8, 10);
		displayBeforeAndAfter(A);
		
		
	}
	
	private static void displayBeforeAndAfter(ArrayList<Integer> A) {
		System.out.println("A:" + A);
		mergeSort(A);
		System.out.println("A:" + A);
	}
	
	private static ArrayList<Integer> copySection
		(ArrayList<Integer> A, int start, int end) {
		ArrayList<Integer> section = new ArrayList<>();
		for (int i=start; i<=end; i++)
			section.add(A.get(i));
		return section;
	}
	
	public static void mergeSort(ArrayList<Integer> A) {
		//Base case
		if (A.size() <= 1)
				return;
		
		int mid = A.size()/2;
		
		ArrayList<Integer> left = copySection(A, 0, mid-1);
		ArrayList<Integer> right = copySection(A, mid, A.size()-1);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(A, left, right);
	}
	
	private static void merge (ArrayList<Integer> A,
		ArrayList<Integer> L, ArrayList<Integer> R) {
	
		int a = 0;	
		int l = 0;
		int r = 0;
		while (l < L.size() && r < R.size()) {
			if (L.get(l) <= R.get(r))
				A.set(a++, L.get(l++));
			else
				A.set(a++, R.get(r++));
		}
		
		while(l < L.size())
			A.set(a++, L.get(l++));
		while(r < R.size())
			A.set(a++, R.get(r++));
	}

}
