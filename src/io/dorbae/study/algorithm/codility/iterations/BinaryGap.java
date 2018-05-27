
package io.dorbae.study.algorithm.codility.iterations;

/*****************************************************************
 * 
 * BinaryGap.java
 * 
 * Task description
 * 
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
 * 
 * Write a function:
 * class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 * Assume that:
 * N is an integer within the range [1..2,147,483,647].
 * 
 * Complexity:
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-14 23:12:59	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class BinaryGap {
	/**
	 * 
	 *
	 * @version	1.1.0	2018-05-23 23:13:14	dorbae	예외처리. 오류 수
	 * @version	1.0.0	2018-05-14 23:12:59	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param N : positive integer
	 * @return : the length of its longest binary gap
	 */
	public int solution( int N) {
		if ( N < 1 || N > 2147483647) {
			System.out.println( "N is out of range.");
			return 0;
		}
		
		int maximumInterval = 0;
		int count = 0;
		String binary = Integer.toBinaryString( N);
//		System.out.println( "binary=" + binary);
		char[] checkData = binary.toCharArray();
		for ( int ll = 1; ll < checkData.length; ll++) {
			if ( checkData[ ll] == '1') {
				if ( count > maximumInterval)
					maximumInterval = count;
				count = 0;
				
			} else {
				++count;
			}
		}
		
		return maximumInterval;
	}
	
}
