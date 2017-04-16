package io.dorbae.study.algorithm;

import java.util.Scanner;

/**
 * 
 * @author dornae (dorbae.io@gmail.com)
 * 
 * 문제
단어에 숫자가 숨어있다. 이 숫자를 히든 넘버라고 한다. 알파벳 대/소문자와 숫자로 이루어진 단어가 주어졌을 때, 모든 히든 넘버의 합을 구하는 프로그램을 작성하시오.

단어와 히든 넘버는 아래와 같은 성질을 갖는다.

연속된 숫자는 한 히든 넘버이다.
두 히든 넘버 사이에는 글자가 적어도 한 개 있다.
히든 넘버는 6자리를 넘지 않는다.
입력
첫째 줄에 단어의 길이 n (1 ≤ n ≤ 5,000,000)이 주어진다. 둘째 줄에는 단어가 주어진다. 단어는 알파벳 대/소문자와 숫자(0-9)로 이루어져 있다. 

출력
입력으로 주어진 단어에 숨어있는 모든 히든 넘버의 합을 출력한다. 만약, 히든 넘버가 없는 경우에는 0을 출력한다.

ex)
입력
14
ab13c9d07jeden

출력
29

 *
 */
public class N8595_HiddenNumber {
	
	public static void main( String[] args) {
		Scanner scan = new Scanner( System.in);
		int wordCount = scan.nextInt();
		
		scan.nextLine();
				
		String word = scan.nextLine();
		
		int codePoint = 0;
		boolean isBeforeNumber = false;
		StringBuilder numberBuilder = new StringBuilder();
		int sum = 0;
		for ( int ll = 0; ll < wordCount; ll++) {
			codePoint = word.codePointAt( ll);
			if ( codePoint >= 48 && codePoint <= 57) {
				numberBuilder.append( word.charAt( ll));
				isBeforeNumber = true;
				
			} else {
				if ( isBeforeNumber) {
					sum += Integer.parseInt( numberBuilder.toString());
					numberBuilder.setLength( 0);
					isBeforeNumber = false;
				}
				
			}
			
		}
		
		if ( isBeforeNumber) {
			sum += Integer.parseInt( numberBuilder.toString());
			numberBuilder.setLength( 0);
			isBeforeNumber = false;
		}
		
		System.out.println( sum);
		
		scan.close();
		
	}
}
