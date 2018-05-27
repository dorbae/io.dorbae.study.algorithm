package io.dorbae.study.algorithm.codility.timecomplexity;

/*****************************************************************
 * 
 * PermMissingElem.java
 * 
 * ***************************************************************
 * 
 An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 
 
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-24 20:30:39	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class PermMissingElem {
	private static final int RESCODE_INVALID	= 0;
	private static final int RESCODE_NOTFOUND	= 0;
	
	/**
	 * 
	 * @version	1.1.0	2018-05-24 21:04:11	dorbae	empty_and_single 오류 수
	 * @version	1.0.0	2018-05-24 20:32:54	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param A : An array A consisting of N different integers is given
	 * @return : Missing element
	 */
	public int solution( int[] A) {
		if ( A == null) {
			System.err.println( "Illegal Argument.");
			return RESCODE_INVALID;
		}
		
		int N = A.length;
		
		if ( N < 0 || N > 100000 ) {
			System.err.println( "Illegal Argument.");
			return RESCODE_INVALID;
			
		/** 
		 * version 1.1.0
		 * Solve empty and single error
		*/
		} else if ( N == 0) {
//			return 0;	// Old (Error)
			return 1;
			
		}
		/**
		 * End of version 1.1.0
		 */
		
		boolean[] checkBitArray = new boolean[ N +2];	// Default primitive boolean value is false.
		
		// Checking
		for ( int ll = 0; ll < N; ll++) {
			try {
				if ( checkBitArray[ A[ ll]]) {	// Already Checked
					System.err.println( "Already existing value.");
					return RESCODE_INVALID;
				
				} else {
					checkBitArray[ A[ ll]] = !checkBitArray[ A[ ll]];
				
				}
				
			} catch ( IndexOutOfBoundsException e) {
				System.err.println( "each element of array A is an integer within the range [1..(N + 1)]");
				return RESCODE_INVALID;
				
			}
		}
		
		if ( checkBitArray[ 0]) {	// one of elements of array A is 0. Each element of array A is an integer within the range [1..(N + 1)]
			return RESCODE_INVALID;
		}
		
		// Find missing element
		for ( int ll = 1; ll < checkBitArray.length; ll++) {
			if ( !checkBitArray[ ll]) {
				return ll;
			}
		}
		
		return RESCODE_NOTFOUND; 
		
    }

}
