package io.dorbae.study.algorithm;

/**
 * ************************************************************************************
 *
 * N1149_RGBDistance.java
 * 
 * ************************************************************************************
 * 
 * @version 1.0.00	2017-04-18	dorbae	Initialize
 * @since 2017-04-18
 * @author dorbae(dorbae.io@gmail.com)
 * 
 * ************************************************************************************
 */

/*
 * RGB거리
문제집 
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	12106	5685	4170	47.849%
문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

예제 입력  복사
3
26 40 83
49 60 57
13 89 99
예제 출력  복사
96
 */

/*
 * 
3
88 56 33
100 48 2
188 7 4
 */
public class N1149_RGBDistance {

	public static void main( String[] args) {
		java.util.Scanner scan = new java.util.Scanner( System.in);
		int count = Integer.parseInt( scan.nextLine());
		int[][] arr = new int[ count][ 3];
		int cost = 0;
		
		for ( int ll = 0; ll < count; ll++) {
			arr[ ll][ 0] = scan.nextInt();
			arr[ ll][ 1] = scan.nextInt();
			arr[ ll][ 2] = scan.nextInt();
			scan.nextLine();
			
		}
		
		int jj = 0;
		int minimumValue = Integer.MAX_VALUE;
		int minimumIndex = 0;
		
		for ( jj = 0; jj < 3; jj++) {
			if ( minimumValue > arr[ 0][ jj]) {
				minimumValue = arr[ 0][ jj];
				minimumIndex = jj;
				
			}
		}
		
		cost += minimumValue;
		int tmp = 0;
		
		for ( int ll = 1; ll < count; ll++) {
			minimumValue = Integer.MAX_VALUE;
			for ( jj = 0; jj < 3; jj++) {
				if ( jj != minimumIndex && minimumValue > arr[ ll][ jj]) {
					minimumValue = arr[ ll][ jj];
					tmp = jj;
					
				}
			}
			cost += minimumValue;
			minimumIndex = tmp;
		}
		
		System.out.println( cost);
	}

}
