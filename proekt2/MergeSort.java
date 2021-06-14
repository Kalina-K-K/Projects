package proekt2;

import java.util.Comparator;

public class MergeSort {
	public static <E> void mergeSort(E[] list, Comparator<E> comparator) {
		if (list.length > 1) {
			E[] firstHalf = (E[]) new Object[list.length / 2]; 
			                                                       
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf, comparator);
			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[]) new Object[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf, comparator);
			merge(firstHalf, secondHalf, list, comparator);
		}
	}

	public static <E> void merge(E[] list1, E[] list2, E[] temp,  Comparator<E> comparator) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (comparator.compare(list1[current1], list2[current2]) <0)     // <
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}


}
