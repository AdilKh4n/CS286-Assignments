package adil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

public class chx {
	
	Double init = 1.0/26;
      
	
public static void main(String[] args)
	{
		Random rm = new Random();
		System.out.println(rm.nextInt(100) + 1);
		double B[][]= new double[26][26];  
		
		double pi[] = new double[26];
		double rowsum = 0.0;
		
		for(int i=0; i < 26;i++)
		{
			pi[i]= rm.nextInt(100) + 1;
			rowsum = rowsum + pi[i];
		}
		
		Double sum = 0.0;
		System.out.println("New B matrix formed after dividing by rowsum");
	//	System.out.println(" " + hm.keySet());
		for (int i =0; i<26;i++)
		{
				System.out.print("  " + pi[i] / rowsum);
				sum = sum + pi[i] / rowsum;
				pi[i] =  pi[i] / rowsum;
		}
			System.out.print(" Sum " + sum);
			//System.out.print("\n");
			//sum = 0.0;
		
	 }
}