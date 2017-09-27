package adil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class Assign4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] MSA = new String[]{
		"A-AB-BAFCD-B-AAEA0ACEDA-EQ---A-ABCDBALF4-BBASB---AAAAFB",
		"A-ABNBAFCD-B-AAEAABCEDA-EQ-CDABAB--BA-F4NBBM-BTYBAAAA--",
		"A-AB-BAFCDAB-A-EAA-CEDCDEQA--ABFBAN---F4-BBAFBTYBAAAA--",
		"2AAB-BAFCDAB-A-EAABCEDCDEQFCDABA-APAL-F4-BBA--SBAAAAA--",
		"CDAB-BAFCDB1-AAEAA-CEDA-EQ-CDABABABAL-F4LBBAFBSBAAAAA--",
		"CDABAAA----B-A-EA-ACEDCDEQ---A-ABCD-A-F4-BBASB---AAAAFB",
		"CDAB--A-CDAB-A-EAA-CEDA-EQ-CDABCDCDAA-F4MBB--ATYBAAAA--",
		"--AA-BA-CDB--AAEAA-CEDCDEQ-CDABPBA-AB-F4-BBAFBSBMAAAA--",
		"CDAB--RBAFABPAAEA-ACEDCDEQAABCDAFAL---F4NBBASB---AAAAMB",
		"A-ABAA-----B-AAEA-ACEDCDEQAABAFA------F4BNBASB---AAAAFB"};
		
		
		List<Character> lst = new ArrayList<Character>();
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		ListIterator<Character> litr = null;
		
		for(int i = 0; i<55 ; i++)
		{
			
			for(int j = 0; j<MSA.length; j++)
			{
				char c = MSA[j].charAt(i);
				if(!lst.contains(c))
				{
					if(c == '-')
					{
						
					}
					else
					{
					lst.add(c);
					}
				}
			
			}
		}
		
		System.out.print(lst.toString() + "\n");
		
		int count = 0;
		int k = 1, l = 0;
		
		for(int i = 0; i<55 ; i++)
		{
			
			for(int j = 0; j<MSA.length; j++)
			{
			char c = MSA[j].charAt(i);
			if(c == '-')
			{
				count = count + 1;
			}
			System.out.print(c);
			
			if(hm.containsKey(c))
			{
					int val = hm.get(c);
					hm.put(c, val + 1);
				
			}
			else
			{
				if(c == '-')
				{
					
				}
				else
				{
					hm.put(c, 1);
				}
			}
			
		}
			litr=lst.listIterator();
			System.out.print(" count : " + count );
			if (count > 5)
			{
				System.out.print(" This is an insert state I" + (k=k-1) +"\n");
				System.out.println("Emission Probabilities for Column" + i + ":");
				System.out.print("EI"+k+"");
				
				 while(litr.hasNext()){
					 char d = litr.next();
					 if(hm.get(d) == null)
					 {
					       System.out.println("EI"+(k)+"" + "("+ d + ") = " + 1 + "/" + ((10-count) + 19));
					 }
					 else
					 {
				       System.out.println("EI"+(k)+"" + "("+ d + ") = " + (hm.get(d) + 1) + "/" + ((10-count) + 19));
					 }
				    }
				 
				k = k + 1;
			}
			else
			{
				System.out.print(" This is a match state M" + k +"\n");
				System.out.println("Emission Probabilities for Column" + i + ":");
			//	System.out.print("EM"+(k)+"");
				
				
				 while(litr.hasNext()){
					 char d = litr.next();
					 if(hm.get(d) == null)
					 {
					       System.out.println("EM"+(k)+"" + "("+ d + ") = " + 1 + "/" + ((10-count) + 19));
					 }
					 else
					 {
				       System.out.println("EM"+(k)+"" + "("+ d + ") = " + (hm.get(d) + 1) + "/" + ((10-count) + 19));
					 }
				    }
				
				k = k + 1;
			}
		//	System.out.print(" Total div: " + (10-count) +"\n");
			System.out.println(hm.keySet());
			System.out.println(hm.entrySet());
			
			//System.out.print("EM"+(k-1)+"");
			
			hm.clear();
			count = 0;
			System.out.println();
		}
		
	
	}
		
		
}
