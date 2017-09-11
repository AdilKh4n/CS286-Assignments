package adil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddNumberofTimes {
	
	public static List<Integer> OddNumberTimes(int[] nums)
	{
		List<Integer> res = new ArrayList<>();
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i=0; i<nums.length;i++)
		{
			if(!hm.containsKey(nums[i]))
			{
				hm.put(nums[i], 1);
			}	
			else
			{
				int val = hm.get(nums[i]);
				hm.put(nums[i], val+1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    // do something with key and/or tab
		    if(value % 2 != 0)
		    	res.add(key);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,2,3,3,4,3,2,5,5};
		List<Integer> x = OddNumberTimes(a);
		System.out.println(x);

	}

}
