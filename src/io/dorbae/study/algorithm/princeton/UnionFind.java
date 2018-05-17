/*****************************************************************
 * 
 * UnionFind.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-04-18 21:23:35	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.algorithm.princeton;

import java.util.Scanner;

/**
 * @author dorbae
 *
 */
public class UnionFind<T> {

	/**
	 * Initialize union-find data structure with N objects (0 to N -1)
	 *
	 * @version	1.0.0	2018-04-18 21:30:55	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param n
	 */
	public UnionFind( int n) {
		
	}
	
	/**
	 * Add connection between p and q
	 *
	 * @version	1.0.0	2018-04-18 21:34:08	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param p
	 * @param q
	 */
	public void union( T p, T q) {
		
	}
	
	/**
	 * are p and q in the same component?
	 *
	 * @version	1.0.0	2018-04-18 21:34:05	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected( T p, T q) {
		return false;
	}
	
	/**
	 * Component identifier for p (0 to N - 1)
	 *
	 * @version	1.0.0	2018-04-18 21:36:00	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param p
	 * @return
	 */
	public T find( T p) {
		return null;
	}
	
	/**
	 * Number of components
	 *
	 * @version	1.0.0	2018-04-18 21:37:31	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @return
	 */
	public int count() {
		return 0;
	}
	
	/**
	 *
	 * @version	1.0.0	2018-04-18 21:23:35	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param args
	 */
	public static void main( String[] args) {
		Scanner scan = new Scanner( System.in);
		int n = scan.nextInt();
		
		UnionFind< Integer> uf = new UnionFind< Integer>( n);
		int p, q = 0;
		while ( scan.hasNextInt()) {
			p = scan.nextInt();
			q = scan.nextInt();
			
			if ( !uf.connected( p, q)) {
				uf.union( p, q);
				System.out.printf( "%d <-> %d\n", p, q);
			}
		}
		
		scan.close();
		
	}

}
