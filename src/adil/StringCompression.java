package adil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringCompression {
	
	static String workonit(String a)
	{
		StringBuilder str = new StringBuilder();
		
		HashMap hm =new HashMap();
		
		for(int i=0;i<a.length();i++)
		{
			char x = a.charAt(i);
			if(hm.containsKey(x))
			{
				int val = (int) hm.get(x);
				hm.put(x, val+1);
			}	
			else
			{
				hm.put(x, 1);
			}
		}
		
		 Set set = hm.entrySet();
	      
	      // Get an iterator
	      Iterator i = set.iterator();
	      
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	         str.append(me.getKey()).append(me.getValue());
	      }
	      System.out.println();
	      
		return str.toString();
		
	}
	
	 public static void main(String[] args) {
		 String x="aaxccabccccd";
		 String j = workonit(x);
		 System.out.println(j);
	 }
}
