package adil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class UpperLowerRemove {
	
	public static String UpperLowerR(String str)
	{
StringBuilder res = new StringBuilder();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i =0;i<str.length();i++)
         {
            if(hm.containsKey(str.charAt(i)))
                {
            		int val = hm.get(str.charAt(i));
            		hm.put(str.charAt(i), val+1);
                }
            else
                {
                    hm.put(str.charAt(i),1);
                }
         }
        
        for ( Map.Entry<Character, Integer> entry : hm.entrySet()) {
            Character key = entry.getKey();
            Integer tab = entry.getValue();
            // do something with key and/or tab
            if(tab % 2 != 0 )
            	res.append(key);
            //else
            	//res.append(key);
        }
        return res.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String x = UpperLowerR("aaabccddd");
			System.out.println(x);
	}

}
