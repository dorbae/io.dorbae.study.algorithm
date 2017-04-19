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

/*
 * 문제
문자열 S가 주어졌을 때, 다음 쿼리를 수행하는 프로그램을 작성하시오.

index len: S의 index번째에서 시작하면서, 길이가 적어도 len인 팰린드롬 부분 문자열의 개수를 출력한다.
입력
첫째 줄에 문자열 S가 주어진다. 문자열의 길이는 100,000을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

둘째 줄에는 쿼리의 개수 M (1 ≤ M ≤ 100,000)이 주어진다.

셋째 줄부터 M개의 줄에는 쿼리가 한 줄에 하나씩 주어진다. (0 ≤ index < S의 길이, 0 ≤ len ≤ 100,000)

문자열의 인덱스는 0부터 시작한다.

출력
입력으로 주어진 쿼리의 결과를 주어진 순서대로 한 줄에 하나씩 출력한다.

예제 입력  복사
ababa
3
0 3
2 4
1 3

예제 출력  복사
2
0
1
 */
public class N14417_PalindromeAndQuery3 {
	
	public static void main( String[] args) {
		java.util.Scanner scan = new java.util.Scanner( System.in);
		String inputString = null;
		int inputStringLength = -1;
		int queryCount = -1;
		
		inputString = scan.nextLine();
		inputStringLength = inputString.length();
		queryCount = scan.nextInt();
		scan.nextLine();
		
		int index = 0;
		int len = 0;
		int jj = 0;
		int maxLen = 0;
		int palindromeWordCount = 0;
		int lastIndex = 0;
		boolean isPalindromeWord = true;
		
		for ( int ll = 0; ll < queryCount; ll++) {
			index = scan.nextInt();
			len = scan.nextInt();
			
			maxLen = inputStringLength - index;
			if ( len > maxLen) {
				System.out.println( "0");				
				continue;
				
			}
			
			palindromeWordCount = 0;
			while ( len <= maxLen) {
				
				isPalindromeWord = true;
				lastIndex = ( int)Math.floor( ( (index + len) / 2));
				for ( jj = index; jj < lastIndex; jj++) {
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
			scan.nextLine();
			
		}
		
		scan.close();
		
	}

}
