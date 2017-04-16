package io.dorbae.study.algorithm;


/**
 * ************************************************************************************
 *
 * N14417_PalindromeAndQuery2.java
 * 
 * ************************************************************************************
 * 
 * @version 1.0.00	2017-04-09	dorbae	Initialize
 * @since 2017-04-09
 * @author dorbae(dorbae.io@gmail.com)
 * 
 * ************************************************************************************
 */
public class N14417_PalindromeAndQuery2_20170413 {
	
	private static final int MAX_STRING_LENGTH 	= 100000;
	private static final int MIN_STRING_LENGTH 	= 1;
	private static final int MAX_QUERY_COUNT	= 100000;
	private static final int MIN_QUERY_COUNT	= 1;
	
	public static void main( String[] args) {
		java.util.Scanner scan = new java.util.Scanner( System.in);
		String inputString = null;
		int inputStringLength = -1;
		int queryCount = -1;
//		java.util.List< Integer> inputDataList = new java.util.LinkedList< Integer>();
//		long startTimestamp = 0L;
//		long endTImestamp = 0L;
		
		
		try {
			inputString = scan.nextLine();
			inputStringLength = inputString.length();
		
			if ( inputStringLength < MIN_STRING_LENGTH || inputStringLength > MAX_STRING_LENGTH) {
				System.out.println( "Invalid string. Too short or too long.");
				System.exit( 1);
			
			}
			
			queryCount = Integer.parseInt( scan.nextLine());
			if ( queryCount < MIN_QUERY_COUNT || queryCount > MAX_QUERY_COUNT) {
				System.out.println( "Invalid query count. Too small or too large.");
				System.exit( 1);
			
			}
			
			String line = null;
			String[] il = null;
			Integer temp = null;
			int index = 0;
			int len = 0;
			int jj = 0;
			int maxLen = 0;
			int palindromeWordCount = 0;
			boolean isPalindromeWord = true;
			
			for ( int ll = 0; ll < queryCount; ll++) {
				line = scan.nextLine();
				il = line.split( "\\s");
				if ( il.length != 2) {
					System.out.println( "Invalid input");
					System.exit( 1);
					
				}
				
				try {
					index = Integer.parseInt( il[ 0]);
					len = Integer.parseInt( il[ 1]);
					
				} catch ( NumberFormatException e) {
					System.out.printf( "%s is not integer.\n", il[ 0]);
					System.out.println( 1);
				
				}
				
				maxLen = inputStringLength - index;
				if ( len > maxLen) {
					System.out.println( "0");
					continue;
					
				}
				
				// aba , 0:1, 0:2
				palindromeWordCount = 0;
				while ( len <= maxLen) {
					isPalindromeWord = true;
					for ( jj = index; jj < ( (index + len) / 2); jj++) {
//					for ( jj = index; jj < index + len;) {
						if ( inputString.charAt( jj) != inputString.charAt( index + len - ++jj)) {
							isPalindromeWord = false;
							break;
					
						}
						
					}
					
					++len;
					
					if ( isPalindromeWord)
						++palindromeWordCount;
					
				}
				
				System.out.println( palindromeWordCount);
				
			}

			
		} catch ( Exception e) {
			System.out.println( "Unexpected Exception.");
			e.printStackTrace();

		} finally {
			scan.close();
			
		}
			
	}

}
