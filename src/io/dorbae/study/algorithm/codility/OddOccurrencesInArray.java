package io.dorbae.study.algorithm.codility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*****************************************************************
 * 
 * OddOccurrencesInArray.java
 * 
 * 
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Assume that:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.


 * RESULT
 * Task Score : 55%
 * Correctness : 100%
 * Performance : 0%
 * Detected time complexity : O(N**2)
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-15 11:23:36	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class OddOccurrencesInArray {
	public int solution( int[] A) {
		if ( A.length == 1)
			return A[ 0];
		
//		int[] checkArray = new int[ A.length / 2 + 1];
//		int limit = 1;
//		checkArray[ 0] = A[ 0];
		
		int kk = 0;
		List< Integer> checkList =  new LinkedList< Integer>();
		checkList.add( A[ 0]);
		Iterator< Integer> iterator = null;
		boolean isExists = false;
		for ( int ll = 1; ll < A.length; ll++) {
			iterator = checkList.iterator();
			isExists = false;
			while ( iterator.hasNext()) {
				kk = iterator.next();
				if ( A[ ll] == kk) {
					iterator.remove();
					isExists = true;
					break;
				}
			}
			
			if ( !isExists) {
				checkList.add( A[ ll]);
			}
		}
		
		return checkList.get( 0);
		
    }

}

