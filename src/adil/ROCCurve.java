package adil;

public class ROCCurve {
	
	int[] upsample(int[] a, int x)
	{
		for(int i = 0; i<a.length;i++)
		{
			a[i] = a[i] * x;
		}
			return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ROCCurve r = new ROCCurve();
		
		int[] match = {5,5,4,4,4,3,3,2,1,1,0};
		int[] nomatch ={5,4,4,3,2,2,1,1,1,0,0};
		
		int[] upsampleddata = r.upsample(nomatch,10);
		
		for(int i=0; i<upsampleddata.length; i++)
		{
		//	System.out.println(upsampleddata[i]);
		}
		
		double[] Precision = new double[11];
		double[] Recall = new double[11];
		
		double[] fpr = new double[11];
		double[] tpr = new double[11];

		for(int i = 0; i< match.length;i++)
		{
			
				float x = 5 - match[i];
				tpr[i] = (float) 1 - x/5;
				float y = (upsampleddata[i]/5);
				fpr[i] = y/10;
		
			
		}
		
		System.out.println("TPR");
		
		for(int j =0; j< match.length;j++)
		{	
			System.out.print((float)tpr[j] + ",");
		}
		
		System.out.println();
		System.out.println("FPR");
		
		for(int i =0; i< match.length;i++)
		{
			System.out.print((float)fpr[i] + ",");
		}
		
		System.out.println();
		for(int i = 0; i< match.length;i++)
		{
		
			float x = 5 - match[i];
	
			Precision[i] = (float)1 - x/5;
			int y = match[i] + upsampleddata[i];
			Recall[i] = (float) match[i] / y;
			
		}
		
		System.out.println("Precision");
		Recall[10] = 1;
		
		for(int j =0; j< match.length;j++)
		{	
			System.out.print((float)Precision[j] + ",");
		}
		
		System.out.println();
		System.out.println("Recall");
		
		for(int i =0; i< match.length;i++)
		{
			System.out.print((float)Recall[i] + ",");
		}
		
		
		
	}

}
