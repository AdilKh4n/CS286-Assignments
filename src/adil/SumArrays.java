package adil;

import adil.SumLists.Node;

public class SumArrays {


	public static int[] addArray(int[] a, int[] b){
		int alen = a.length;
		int blen = b.length;
		int clen = Math.max(alen, blen);
		int[] c  = new int[clen];
		boolean carry = false;
		
		for ( int i = 0; i < clen; i++ ){
			int eleSum = 0;
			
			if ( i < alen ){
				eleSum = a[i];
			}
			if ( i < blen){
				eleSum += b[i];
			}
			if ( carry ){
				eleSum += 1;
				carry = false;
			}
			carry = (eleSum > 10);
			c[i] = (carry)? eleSum-10 : eleSum;					
		}
		return c;
		
		
	}
	
	public static void main(String[] args){
		int[] b = new int[] { 6, 6, 6, 6, 6 };
		int[] a = new int[] { 5, 0, 5 };
		
		int[] c = addArray(a, b);
		StringBuilder sb = new StringBuilder();
		for ( int ele : c ){
			sb.insert(0, ele);
		}
		System.out.println(sb.toString());
		
	}

}
