package lab06;

import java.util.Comparator;

public class SelectionSorter implements Sorter {

	@Override
	public <E extends Comparable<? super E>> void sort(E[] data) {
		int min_index;
		for (int i = 0 ; i < data.length ; i++) {
			min_index = i;
			for (int j = i+1 ; j < data.length ; j++) {
				if (data[min_index].compareTo(data[j]) == 1)
					min_index = j;
			}
			if (min_index != i)
				swap(data, i, min_index);
		}
		
	}

	@Override
	public <E> void sort(E[] data, Comparator<? super E> comp) {
		int min_index;
		for (int i = 0 ; i < data.length ; i++) {
			min_index = i;
			for (int j = i+1 ; j < data.length ; j++) {
				if (comp.compare(data[min_index], data[j]) == 1)
					min_index = j;
			}
			if (min_index != i)
				swap(data, i, min_index);
		}
		
	}

	private <E> void swap (E[] data, int i, int j) {
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
}