package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InputGenerator {
	Random numGenerator;
	
	public InputGenerator() {
		numGenerator = new Random();
	}
	
	public InputGenerator(long seed) {
		numGenerator = new Random(seed);
	}
	

	public int[] makeSortedArray(int size, int maxValue) {
		int[] array = makeArray(size, maxValue);
		Arrays.sort(array);
		return array;
	}
	
	public int makeInt(int maxValue) {
		return numGenerator.nextInt(maxValue + 1);
	}
	

	public ArrayList<Integer> makeSortedArrayList
		(int size, int maxValue) {
		return toArrayList(makeSortedArray(size, maxValue));
	}
	
	public int[] makeArray(int size, int maxValue) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = numGenerator.nextInt(maxValue+1);
		return array;
	}
	
	public ArrayList<Integer> makeArrayList
		(int size, int maxValue){
		return toArrayList(makeArray(size, maxValue));
	}
	
	public ArrayList<Integer> toArrayList(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++)
			list.add(array[i]);
		return list;
	}

	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		
		ArrayList<Integer> A = ig.makeArrayList(0, 0);
		System.out.println("A = " + A);
		ArrayList<Integer> B = ig.makeArrayList(3, 9);
		System.out.println("B = " + B);
	}

	
	

}
