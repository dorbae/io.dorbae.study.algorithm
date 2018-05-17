package io.dorbae.study.algorithm.codility;

import java.util.HashSet;
import java.util.Set;

/*****************************************************************
 * 
 * Solution3.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-16 17:14:15	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class Solution3 {
	private static final int RESCODE_EXCEPTION = 0;
	
	private int enteredPeopleCount = 0;
	private int enteredPeopleWeight = 0;
	private int totalStoppedCount = 0;
	private int queueingPosition = 0;
	private int X;
	private int Y;
	private int[] A;
	private int[] B;
	private int M;
	private int N;
	
	private Set< Integer> floorSet = new HashSet< Integer>();
	
	/**
	 * 
	 *
	 * @version	1.0.0	2018-05-16 17:19:13	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param A
	 * @param B
	 * @param M
	 * @param X
	 * @param Y
	 * @return
	 */
	public int solution(int[] A, int[] B, int M, int X, int Y) {
		this.N = A.length;
		if ( N != B.length) {
			System.err.println( "Invalid A, B length");
			return RESCODE_EXCEPTION;
		}
		
		// Set global variables
		this.A = A;
		this.B = B;
		this.M = M;
		this.X = X;
		this.Y = Y;
		
		// Check valid
		if ( !this.isValid( N) || !this.isValid( M) || !this.isValid( X)) {
			System.err.println( "Invalid arguments");
			return RESCODE_EXCEPTION;
		}
		
		if ( Y < 1 || Y > 1000000000)  {
			System.err.printf( "Invalid limit weight (%d).\n", Y);
			return RESCODE_EXCEPTION;
		}
		
		try {
			take();
				
		} catch ( IllegalArgumentException e) {
			e.printStackTrace();
			return RESCODE_EXCEPTION;
			
		}
		
		return this.totalStoppedCount;
		
	}
	
	/**
	 * 
	 *
	 * @version	1.0.0	2018-05-16 17:38:14	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 * @throws IllegalArgumentException
	 */
	private void take() throws IllegalArgumentException {
		while ( this.queueingPosition < this.N) {
			// Check valid data
			if ( this.A[ this.queueingPosition] < 1 || this.A[ this.queueingPosition] > Y)
				throw new IllegalArgumentException( String.format( "Invalid weight (%d).", this.A[ this.queueingPosition]));
			else if ( this.B[ this.queueingPosition] <1 || this.B[ this.queueingPosition] > this.M)
				throw new IllegalArgumentException( String.format( "Invalid weight (%d).", this.A[ this.queueingPosition]));
			
			if ( this.enteredPeopleCount < X && ( (this.enteredPeopleWeight + A[ this.queueingPosition]) <= Y)) {
				this.enteredPeopleCount++;
				this.enteredPeopleWeight += A[ this.queueingPosition];
				System.out.println("this.enteredPeopleCount="+this.enteredPeopleCount);
				this.floorSet.add( this.B[ this.queueingPosition]); // Removing Duplication floor
				this.queueingPosition++;
				
			} else { // Full & Move
				this.totalStoppedCount += this.floorSet.size();
				this.totalStoppedCount++;
				this.floorSet.clear();
				this.enteredPeopleCount = 0;
				this.enteredPeopleWeight = 0;
//				break;
			}
		}
	}
	
	/**
	 * 
	 *
	 * @version	1.0.0	2018-05-16 17:21:16	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param n
	 * @return
	 */
	private boolean isValid( int n) {
		if ( n < 1 || n > 100000)
			return false;
		
		return true;
		
	}

}

