package adil;

public class FiveThirteenthb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	double B[][] = {{-1,-2,-1,0},
				{2,1,3,2},
				{1,2,0,3},
				{2,3,1,1},
				{-1,2,3,1},
				{0,1,-1,-2}};

double u[] = new double[B.length];

for(int i=0; i<u.length ; i++)
{
	for(int j=0;j<B[0].length; j++)
	{
	u[i] += B[i][j];
	}	
	u[i] = u[i]/4;
}

//U Matrix
System.out.println("U Matrix :");
for(int i=0; i<u.length ; i++)
{
	System.out.println(u[i]);
}
System.out.println();

//A Matrix
System.out.println("A Matrix :");
for(int i = 0 ; i<B.length; i++)
{
	for(int j =0 ; j<B[0].length ; j++)
	{
		B[i][j] = B[i][j] - u[i];
		System.out.print( B[i][j]+ " ");
	}
	System.out.println();
}

//Using the same U given in the book
		double U[][]={{0.1641 , 0.2443},
				{0.6278 ,  0.1070  }, 
				{-0.2604 ,  -0.8017 },
				{-0.5389 , 0.4277 },
				{0.4637, -0.1373 },  
				{0.0752,  -0.2904}};  
		
		//double u12[][] = {{0.1641,0.6278,-0.2604,-0.5389,0.4637,0.0752},
		//		{0.2443,0.1070,-0.8017,0.4277,-0.1373,-0.2904}};
				 
	double delta[][] = new double [U[0].length][B[0].length];
		
		for(int i=0;i <B[0].length;i++)
			{
				for(int l=0;l<B.length;l++)
				{
					for(int j=0; j<delta.length ;j++)
					{
					delta[j][i] += B[l][i]*U[l][j];
					}
				}
		 }
		
		System.out.println("My delta Matrix");
		for(int i =0 ;i< delta.length ; i++)
		{
			for(int j =0 ; j<delta[0].length ; j++)
			{
				System.out.print(delta[i][j] + " ");
			}
			System.out.println();
		}
		
		//double Y[] = {1,5,1,5,5,1};
		//double Y[] = {-2,3,2,3,0,2};
		//double Y[] = {2,-3,2,3,0,0};
		double Y[] = {2,-2,2,2,-1,1};
		double Y1[] = new double[Y.length];
		
		for(int i=0; i<Y.length; i++)
		 {
			 Y1[i] = Y[i] - u[i];
		 }
		double W[] = new double[2];
		 for(int i=0 ; i < 2 ; i++)
		 {	 
			 for(int j=0 ;j<Y1.length; j++)
			 {
				 W[i] += Y1[j] * U[j][i]; 
			 }
		 }
		 
		 System.out.println("W Matrix:" );
		 for(int j=0 ;j<2; j++)
		 {
			 System.out.println(W[j]);
		 }
		 double E[] = new double[4];
		 
		 for(int i=0 ; i<E.length ; i++)
		 {
			 for(int j=0 ; j<W.length;j++)
			 {
			 double val = delta[j][i] - W[j];
			 E[i] += (val*val);	 
			 }
			 E[i] = Math.sqrt(E[i]);
		 }
		 
		 for(int i=0 ; i<E.length ; i++)
		 {
		 System.out.print(" Epsilon " +i + " :" );
		 System.out.printf("%f", E[i]);
		 }
		 System.out.println();
		 
		 double least = E[0];
		 for(int i=1 ; i<E.length ; i++)
		 {
		 	if(E[i] < least)
		 	{
		 		least = E[i];
		 	}
		 }
		 
		 System.out.printf("PCA Score of the sequence : %f",least);
		
		 
		 
	}

}
