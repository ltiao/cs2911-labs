package lab06;

import java.util.Comparator;

public interface Sorter {
	
	<E extends Comparable<? super E>>
	void sort(E[] data);
	
	<E>
	void sort(E[] data, Comparator<? super E> comp);
}