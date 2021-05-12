package edu.wmich.CS3310.PA2.RajBasnet;

import java.util.Comparator;

/**
 * This class implements the Comparator to compare two generic data and return the integer value.
 * @param <T> Represents the generic nature of the class
 */
public class DataComparator<T> implements Comparator<T> {

	/**
	 * This method compares two data and returns the integer value accordingly.
	 * @param o1 T represents first data to be compared
	 * @param o2 T represents the second data to be compared
	 */
	public int compare(T o1, T o2) {

		//If integer form of both data are equal, return 0
		if ((Integer) o1 == (Integer) o2) {
			return 0;
		}
		//If first data is smaller than second data, return -1
		else if ((Integer)o1 < (Integer)o2) {
			return -1;
		} 
		//Else first data is larger than second data return 1
		else {
			return 1;
		}
	}

}
