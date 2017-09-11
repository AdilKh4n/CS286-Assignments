package adil;

public class isUnique {

	
	public static Boolean isUniques(char[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i+1; j < arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[i]+ "" + arr[j]);
					return true;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		final char[] str = {'M', 'r','i', 't', 'h','x','y','M'};
		Boolean b = isUniques(str);
		System.out.println(b);
		}
		
	}

