/**
 * 
 */
package edu.stanford.math.plex_plus.homology.simplex;

import java.util.Comparator;

import edu.stanford.math.plex_plus.utility.ExceptionUtility;

/**
 * @author Andris
 *
 */
public class TensorComparator<T extends ChainBasisElement, U extends ChainBasisElement> implements Comparator<TensorProductPair<T, U>> {
	private final Comparator<T> TComparator;
	private final Comparator<U> UComparator;
	
	public TensorComparator(Comparator<T> TComparator, Comparator<U> UComparator) {
		this.TComparator = TComparator;
		this.UComparator = UComparator;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(TensorProductPair<T, U> o1, TensorProductPair<T, U> o2) {
		ExceptionUtility.verifyNonNull(o1);
		ExceptionUtility.verifyNonNull(o2);
		int comparison = this.TComparator.compare(o1.getFirst(), o2.getFirst());
		if (comparison != 0) {
			return comparison;
		} else {
			return this.UComparator.compare(o1.getSecond(), o2.getSecond());
		}
	}

}