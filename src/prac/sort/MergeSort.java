package prac.sort;

public class MergeSort<E extends Comparable<E>> {

	private E[] _tempArr;

	public MergeSort(E[] array) {
		_tempArr = (E[]) (new Comparable[array.length]);
		mergesort(array, 0, array.length);
	}

	public void mergesort(E[] array, int left, int right) {
		int midPoint = (right + left) / 2;
		if (right - left > 1) {
			// left
			mergesort(array, left, midPoint);
			// right
			mergesort(array, midPoint, right);

			merge(array, left, midPoint, right);
		}

	}

	public void merge(E[] array, int left, int midPoint, int right) {

		int lp = left;
		int rp = midPoint;
		int i = left;

		while (lp < midPoint && rp < right) {
			_tempArr[i++] = array[lp].compareTo(array[rp]) < 0 ? array[lp++]
					: array[rp++];
		}

		while (lp < midPoint) {
			_tempArr[i++] = array[lp++];
		}

		while (rp < right) {
			_tempArr[i++] = array[rp++];
		}

		for (int j = left; j < right; j++) {
			array[j] = _tempArr[j];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = { 19, 8, 172, 11, 48, 54, 17, 3, 7, 19 };
		MergeSort<Integer> ms = new MergeSort<Integer>(a);

		System.out.println("merge");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " / ");
		}

	}
}
