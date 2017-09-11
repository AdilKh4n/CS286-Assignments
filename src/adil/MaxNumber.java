package adil;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxNumber {

	static String FindMaxNum(int[] input)
	{
		int Max = 0;
		int res = 0;
		
		LinkedList s = new LinkedList();
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i]<=9)
			{
				s.add(input[i]);
			}
			else if (input[i] > 9 && input[i] < 99)
			{
			Max = input[i] % 10;
			res = input[i] / 10;
			s.add(res);
			s.add(Max);
			}
			   
		}
		
		Collections.sort(s);
		 Iterator itr=s.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }
		  
		  String ans = "";
	        for(int i=s.size()-1;i>=0;i--)
	            ans = ans+s.get(i).toString();
	        return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,34,54,33,13,722};
		String x = FindMaxNum(array);
		System.out.println(x);
		
	}

}
