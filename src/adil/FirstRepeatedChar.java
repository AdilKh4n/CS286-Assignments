package adil;

import java.util.HashMap;

public class FirstRepeatedChar {
	
	public static char FirstChar(String str)
	{
		/*int freq[] = new int[26];
		
		for(int i=0;i<str.length();i++)
		{
			freq[str.charAt(i)-'a']++;
		}
		
		for(int i=0;i<freq.length;i++)
		{
			if(freq[i]>1)
				return ;
		}
		return ;*/
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		int val = 1;
		for(int i=0;i<str.length();i++)
		{
		 if(!hm.containsKey(str.charAt(i)))
		 {
			 hm.put(str.charAt(i), val+1);	
		 }
		else
		{
			if(hm.get(str.charAt(i))>1)
				return str.charAt(i);
			else
				hm.put(str.charAt(i),val);
		
		}
		
		}
		return 'z';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char x = FirstChar("abcba");
		System.out.println(x);
	}

}
