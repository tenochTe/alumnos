package com.alumnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlumnosMain2 {

	public static void main(String[] args) {
//		Código Correcto
//		int[] avg =new int[] {1,1,1,0,0,1,1,0};  //4
//		int[] avg =new int[] {0,1,0,1};          //1
//		int[] avg =new int[] {0,1,1,0,0,1,1,0};  //8
//		int[] avg =new int[] {1,1,1,1,0,0,0,0};  //0
		int[] avg1 =new int[] {1,0,1,0,0,0,0,1};  //6

		
		// Collection
		List<Integer> avg =new ArrayList<Integer>();
		for (int x = 0; x < avg1.length; x++) {
			avg.add(avg1[x]);
		}
		
		int toMove = ( Collections.frequency(avg, 0) > Collections.frequency(avg, 1) ) ? 1 
						: ( Collections.frequency(avg, 0) < Collections.frequency(avg, 1) ) ? 0 : 1;
		
		String move = ( Collections.frequency( avg.subList( 0, ( avg.size() / 2 )), toMove ) 
							> Collections.frequency( avg.subList( ( avg.size()/2 ), avg.size() ), toMove ) ) 
						? "U" : "D";

		int seq = Collections.frequency(avg, toMove);
		
		int count = 0;
		Integer[] arr = avg.toArray( new Integer[avg.size()]);

		while(true) {
			
			if(valSequency(seq,toMove,arr))
				break;
			
			// U= up to down, D= down to up
			if ("U".equals(move)) {
				
				f1:for (int x = (arr.length - 1); x > -1; x--) {
					
					if (arr[x] == toMove && (x > 0) ) {
						
						if (toMove == arr[x-1]) {
							continue f1;
						}
						
						int tmp = arr[x];
						arr[x] = arr[x-1];
						arr[x-1] = tmp;
						count ++;
					}
				}
				
			} else {
				
				f1:for (int x = 0; x < arr.length; x++) {
					
					if (arr[x] == toMove && (x < (arr.length - 1)) ) {
						
						if (toMove == arr[x+1]) {
							continue f1;
						}
						
						int tmp = arr[x];
						arr[x] = arr[x+1];
						arr[x+1] = tmp;
						count ++;
					}
				}
			}
		}
		
		System.out.println("RETURN COUNT: "+count);
		
	}
	
	private static boolean valSequency(int seq, int toMove, Integer[] arr) {
		int val = 0;
		for (int x : arr) {
			
			if (val == seq)
				break;
			
			if(x == toMove) {
				val ++;
			}else {
				val = 0;
			}
			
		}
		
		return (val == seq);
		
	}

}
