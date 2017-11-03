package adil;

public class ssmo_fifteen {
	static double X[][] = {{3,3},
			{3,4},
			{2,3},
			{1,1},
			{1,3},
			{2,2}};
	static double Z[] = {1,1,1,-1,-1,-1};
	static double C = 2.5;
	static double epsi = 0.00001;
	
	static double[] lambda = new double[X.length];
	static double[] oldlambda = new double[X.length];
	static double b = 0;
	static double E[] = new double[X.length]; 
	static double l = 0;
	static double h = 0;
	static double[] B = new double[X.length];
	static int[] i_value = {0,1,2,3,4,0,1,2,3,0,1,2,0,1,0,1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[] j_value = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5,0,1,2,3,4,0,1,2,3,0,1,2,0,1,0};
	
	public static void main(String[] args) {
		
		int m = 0;
		int count = 0;
		while(count<10)
		{
			for(int i = 0; i < lambda.length; i++)
			{
				if(lambda[i] == oldlambda[i])
					break;
			}
		m = 0;
		int i = 0;
		int j = 0;
		for(i = i_value[m], j = j_value[m]; m < i_value.length; m++)
		{
			    i = i_value[m];
			    j = j_value[m];
				double d = 2 *(X[i][0] * X[j][0] + X[i][1] * X[j][1]) - (X[i][0]*X[i][0]+X[i][1]*X[i][1]) - (X[j][0]*X[j][0] + X[j][1]*X[j][1]);
				//System.out.println(d);
			
					if(Math.abs(d) > epsi)
					{
						E[i] = funcx(new double[]{X[i][0],X[i][1]}) - Z[i];
						//System.out.println(E[i]);
						E[j] = funcx(new double[]{X[j][0],X[j][1]}) - Z[j];
						//System.out.println(E[j]);
						
						oldlambda[i]= lambda[i];
						oldlambda[j]= lambda[j];
						lambda[j] = lambda[j] - ((Z[j] * (E[i]-E[j]))/d);
					//	System.out.println(lambda[j]);
						
						if(Z[i] == Z[j])
						{
							l = Math.max(0,lambda[i]+lambda[j] - C );
							h = Math.min(C,lambda[i]+lambda[j]);
						}
						else
						{
							l = Math.max(0,lambda[j]-lambda[i]);
							h = Math.min(C,C+lambda[j]-lambda[i]);
						}
						//System.out.println(l);
						//System.out.println(h);
						
						if(lambda[j] > h)
						{
							lambda[j] = h;
						}
						else if(l <= lambda[j] && lambda[j] <= h)
						{
							lambda[j] = lambda[j];
						}
						else if(lambda[j] < l)
						{
							lambda[j] = l;
						}
						
						lambda[i] = lambda[i] + (Z[i]*Z[j]*(oldlambda[j]-lambda[j]));
						
						B[i] = b - E[i] - Z[i] * (lambda[i] - oldlambda[i]) * (X[i][0]*X[i][0]+X[i][1]*X[i][1])
								- Z[j] * (lambda[j] - oldlambda[j]) * (X[i][0]*X[j][0] + X[i][1]*X[j][1]);
						B[j] = b - E[j] - Z[i] * (lambda[i] - oldlambda[i]) * (X[i][0] * X[j][0] + X[i][1] * X[j][1])
								- Z[j] * (lambda[j] - oldlambda[j]) * (X[j][0]*X[j][0] + X[j][1]*X[j][1]);
						
						if(0 < lambda[i] && lambda[i] < C)
						{
							b = B[i];
						}
						else if (0 < lambda[j] && lambda[j] < C)
						{
							b = B[j];
						}
						else
						{
							b = (B[i] + B[j])/2;
						}
						System.out.println(i + " " + j);
					}
				
			
		}
		count = count + 1;
		System.out.println(count);
		}
		System.out.println(b);
		
		for(int i = 0; i < lambda.length; i++)
		{
			System.out.println(" " + i + " " + lambda[i]);
		}
		
		double w1 = 0;
		double w2 = 0;
		for(int i = 0; i < X.length; i++)
		{
			w1 += lambda[i] * Z[i] * X[i][0];
			w2 += lambda[i] * Z[i] * X[i][1];
		}
		System.out.println("W1 " + w1 + "W2 " + w2);
		}
	public static double funcx(double Y[])
	{
		double result = 0;
		for(int i = 0; i < 6; i++)
		{
			result += lambda[i] * Z[i] * (X[i][0]*Y[0] + X[i][1]*Y[1]);
		}
		return result + b;
	}
		

}
