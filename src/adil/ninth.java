package adil;

import java.util .*;
import java.io.*;

public class ninth
{

 public static void main(String args[])
 {
	 double A[][] = {{0.25,0.25,-0.75,0.25},
			 {-0.75,1.25,-1.75,1.25},
			 {-1.25,-0.25,1.75,-0.25},
			 {1,0,1,-2},
			 {-1,1,-1,1},
			 {0,-1,0,1}};
	 
	 double B[][] = new double[A[0].length][A.length];
	 
	 for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < A[0].length ; j++) {
             B[j][i] = A[i][j]; 
         }
     }
	 
	 System.out.println("\nA Transpose Matrix: "+ "\n");
	 for (int i = 0; i < B.length; i++) {
         for (int j = 0; j < B[0].length; j++) {
             System.out.print(B[i][j] + " ");
         }
         System.out.println();
     }
	 
	 double mul[][] = new double[A.length][B[0].length];
	 
	 for(int i=0; i<A.length; i++)
	 {
		 for(int j=0; j < B[0].length; j++)
		 {
			 for(int k=0; k<A[0].length; k++)
			 {
			 mul[i][j] += (A[i][k] * B[k][j])/4;
			 }
		 }
	 }
	 
	 //C Matrix

	 System.out.println("\nC Matrix: "+ "\n");
	 for(int i=0; i<mul.length; i++)
	 {
		 for(int j=0; j < mul[0].length; j++)
		 {
			 System.out.print(mul[i][j] + " ");
		 }
		 System.out.println();
	 }
	 
	 double sum = 0;
	 for(int i=0; i<mul.length; i++)
	 {
		 
	    sum += (mul[i][i]);

	 }
 
	 System.out.println("\nSum of the diagonal values: " + sum);
	 
	 }

}
