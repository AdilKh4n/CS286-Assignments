package adil;

public class stripe {
	
		static String[] replace(String[] lines)
	{
		for(String element:lines)
		{
			int index  = element.indexOf("card=");
			System.out.println(index);	
		}
		return lines;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = new String[]{"card=12345","card=1234567890"};	
		String[] op = replace(in);
	}

}
