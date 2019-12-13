package com.alumnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AlumnosMain {
	
	public static void main(String[] args) {
//		int[] avg =new int[] {1,1,1,0,0,1,1,0};  //4
//		int[] avg =new int[] {0,1,0,1};          //1
//		int[] avg =new int[] {0,1,1,0,0,1,1,0};  //8
//		int[] avg =new int[] {1,1,1,1,0,0,0,0};  //0
		int[] avg =new int[] {1,0,1,0,0,0,0,1};  //6

		
		// Collection
		Collection<Integer> c =new ArrayList<Integer>();
		for (int x = 0; x < avg.length; x++) {
			c.add(avg[x]);
		}
		
		int toMove = ( Collections.frequency(c, 0) > Collections.frequency(c, 1) ) ? 1 
						: ( Collections.frequency(c, 0) < Collections.frequency(c, 1) ) ? 0 : 1;
		
		String move = ( Collections.frequency(Arrays.asList(c.toArray()).subList(0, (avg.length/2)), toMove) 
							> Collections.frequency(Arrays.asList(c.toArray()).subList((avg.length/2), avg.length), toMove) ) 
						? "U" : "D";

		int seq = Collections.frequency(c, toMove);
		
		int count = 0;
		while(true) {
			
			if(valSequency(seq,toMove,avg))
				break;
			
			// U= up to down, D= down to up
			if ("U".equals(move)) {
				
				f1:for (int x = (avg.length - 1); x > -1; x--) {
					
					if (avg[x] == toMove && (x > 0) ) {
						
						if (toMove == avg[x-1]) {
							continue f1;
						}
						
						int tmp = avg[x];
						avg[x] = avg[x-1];
						avg[x-1] = tmp;
						count ++;
					}
				}
				
			} else {
				
				f1:for (int x = 0; x < avg.length; x++) {
					
					if (avg[x] == toMove && (x < (avg.length - 1)) ) {
						
						if (toMove == avg[x+1]) {
							continue f1;
						}
						
						int tmp = avg[x];
						avg[x] = avg[x+1];
						avg[x+1] = tmp;
						count ++;
					}
				}
			}
		}
		
		System.out.println("RETURN COUNT: "+count);
		
	}
	
	private static boolean valSequency(int seq, int toMove, int[] arr) {
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
