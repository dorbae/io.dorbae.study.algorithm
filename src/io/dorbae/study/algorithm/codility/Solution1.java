package io.dorbae.study.algorithm.codility;

/*****************************************************************
 * 
 * Solution1.java
 *
 * Pass -> How to handle exception... don't throw exception...
 *****************************************************************
 *
 * @version	0.0.0	2018-05-16 14:14:01	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class Solution1 {
	/**
	 * 
	 *
	 * @version	1.0.2	2018-05-16 15:01:17	dorbae	return 0 when exception occurs
	 * @version	1.0.1	2018-05-16 14:56:17	dorbae	V type int -> long
	 * @version	1.0.0	2018-05-16 14:14:17	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param S : binary format text
	 * @return
	 */
	public int solution( String S) {
		// Check null
		if ( S == null)
			return 0;
//			throw new IllegalArgumentException( "Must not be null.");
		
		// Check Invalid length
		int N = S.length();
		if ( N < 1 || N > 1000000)
			return 0;
//			throw new IllegalArgumentException( "N must be integer within the range [1 .. 1,000,000].");
		
		// Check Number Format
		long V = -1;
		try {
			V = Long.parseLong( S, 2);
			
		} catch ( NumberFormatException e) {
			return 0;
//			throw new IllegalArgumentException( String.format( "Invalid argument. Not number format data [%s]", S), e);
		
		}
		
		if ( V < 0)			// Check Non-negative
			return 0;
//			throw new IllegalArgumentException( "V must be non-negative integer");
		
		
		int modifiedCount = 0;
		while ( V > 0) {
			if ( ( V % 2) == 0)	// Even
				V = V / 2;
			else				// Odd
				V -= 1;
			
			modifiedCount++;
			
		}
		
		return modifiedCount;
		
    }
}

