package adil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class chx {
	
	public String reverseWords(String s,int K) {
		int lev = s.lastIndexOf("\t");
		System.out.println(lev);
        String[] arr = s.split("-");
        StringBuilder sb = new StringBuilder();
       
        for(String x:arr)
        {
        	sb.append(x);
        }
        
       
        for(int i= sb.length(); i>0 ; i=i-K)
        {
        	if(i!=0 && i!=sb.length())
        	sb.insert(i,"-");
        }
        return sb.toString().toUpperCase();
	}
     
        
public static void main(String[] args)
	{
		chx c = new chx();
		int arr[]= {1,2,3,8,5,4};
		String x = c.reverseWords("dir\n\tsubdir\n\t\tfile1.ext",5);
	System.out.println(x);
	
	 }
}