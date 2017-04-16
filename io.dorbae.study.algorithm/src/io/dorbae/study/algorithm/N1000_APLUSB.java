package io.dorbae.study.algorithm;

import java.util.Scanner;

/**
 * 
 * @author dorbae (dorbae.io@gmail.com)
 * 
 * 문제
두 수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 10)

출력
첫째 줄에 A+B를 출력한다.

예제 입력  복사
1 2

예제 출력  복사
3
 *
 */

public class N1000_APLUSB {

	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println( a + b);
	
	}

}
