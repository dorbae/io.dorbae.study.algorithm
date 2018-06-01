package io.dorbae.study.algorithm.codility.timecomplexity;

/*****************************************************************
 * 
 * TapeEquilibrium.java
 * 
 * 
 * 
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-06-01 15:04:21	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class TapeEquilibrium {
	
	private static final int RESCODE_INVALID = 0;
	/**
	 * 
	 *
	 * @version	1.0.0	2018-06-01 15:10:34	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param A : a non-empty array (the range of elements is -1000 ~ 1000)
	 * 
	 * @return : a minimal different between two arrays that be seperated by Pb
	 */
	public int solution( int[] A) {
		if ( A == null) {
			System.err.println( "Invalid array A.");
			return RESCODE_INVALID;
		}
		
		/** N : the length of array A. 2 <= N < 100,000 */
		int N = A.length;
		if (  N < 2 || N > 100000) {
			System.err.println( "Invalid array A.");
			return RESCODE_INVALID;
		}
		
		int minimumValue = Integer.MAX_VALUE;
		int preValue = 0;
		int postValue = 0;
		int differntValue = 0;
		int ll = 0;
		preValue = 0;
		postValue = 0;
		preValue = A[ 0];
		for ( ll = 1; ll < N; ll++) {
			postValue += A[ ll];
			
		}
		
		differntValue = Math.abs( preValue - postValue);
		if ( differntValue < minimumValue) {
			minimumValue = differntValue;
		}
		
		/* P : a index to split array A. (seperated arrays must be not empty.). 0 < P < N */
		for ( int P = 1; P < N; P++) {
			preValue += A[ P];
			postValue -= A[ P];
			differntValue = Math.abs( preValue - postValue);
			if ( differntValue < minimumValue) {
				minimumValue = differntValue;
			}
		}
		
		return minimumValue;
		
    }
}

