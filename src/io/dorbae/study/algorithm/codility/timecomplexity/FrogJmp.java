package io.dorbae.study.algorithm.codility.timecomplexity;

import java.math.BigDecimal;

/*****************************************************************
 * 
 * FrogJmp.java
 * 
 * 120m
 * 1Task
 * 
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Assume that:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-23 15:27:59	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class FrogJmp {

	/**
	 * 
	 *
	 * @version	1.0.0	2018-05-23 15:28:51	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param X : current position
	 * @param Y : a smallest position where the frog wants to go
	 * @param D : a distance that the frog can jump
	 * @return : the minimal count to the frog should jump
	 */
	public int solution( int X, int Y, int D) {
		// Exception
		if ( X < 1 || X > 1000000000) {
			System.err.println( "X is out of allowed range.");
			return 0;
			
		} else if ( Y < 1 || Y > 1000000000) {
			System.err.println( "Y is out of allowed range.");
			return 0;
			
		} else if ( D < 1) {
			System.err.println( "Invalid D.");
			return 0;
			
		}
		
		int gap = Y - X;
		if ( gap < 1) {
			return 0;
		}
		
		BigDecimal gapDecimal = new BigDecimal( ( double)gap);
		BigDecimal diviedeDecimal = gapDecimal.divide( new BigDecimal( D), BigDecimal.ROUND_UP);
		
		return diviedeDecimal.intValue();
		
	}
	
}
