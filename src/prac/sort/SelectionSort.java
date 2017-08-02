package prac.sort;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class SelectionSort<E extends Comparable<E>> {

	public void sort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			int currentIndex = i;
			int smallestIndex = findSmallestIndex(array, currentIndex);

			if (currentIndex != smallestIndex) {
				E temp = array[currentIndex];
				array[currentIndex] = array[smallestIndex];
				array[smallestIndex] = temp;
			}

		}

	}

	public int findSmallestIndex(E[] array, int startingIndex) {
		int theLowestIndex = startingIndex;
		
		
		for(int i = startingIndex + 1; i < array.length ; i++){
			if(array[theLowestIndex].compareTo(array[i]) > 0){
				theLowestIndex = i;
			}
		}
		
		return theLowestIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = { 10, 8, 32, 7, 20, 12, 58, 32, 81, 3, 19, 5 };

		SelectionSort<Integer> ss = new SelectionSort<>();

		ss.sort(a);

		System.out.println("selection");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " / ");
		}

	}
}
