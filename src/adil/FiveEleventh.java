package adil;

public class FiveEleventh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double B[][] = {{2,-2,-1,3},
						{-1,3,3,-1},
						{0,2,3,0},
						{1,3,1,3},
						{1,0,-1,2},
						{-3,2,4,-1},
						{5,-1,5,3},
						{2,1,2,0}};
		
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
		
		//Through SVD, we get
		double U[][]={{-0.4654,-0.0374,0.4828},   
				   {0.4699 , -0.0418,  -0.1089},   
				   {0.2915 , -0.1540 ,  0.0358},  
				   {0.0180  , 0.3532  , 0.3319},   
				  {-0.2260 ,  0.1975 ,  0.2204},  
				   {0.5965 , -0.2106 ,  0.6114},   
				  {-0.2618 , -0.8438 ,  0.1382},   
				  { 0.0430 , -0.2305  ,-0.4495}};   
		
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
		
		double Y[] = {1,5,1,5,5,1,1,3};
		double Y1[] = new double[Y.length];
		
		for(int i=0; i<Y.length; i++)
		 {
			 Y1[i] = Y[i] - u[i];
		 }
		
		 double W[] = new double[3];
		 for(int i=0 ; i < 3 ; i++)
		 {	 
			 for(int j=0 ;j<Y1.length; j++)
			 {
				 W[i] += Y1[j] * U[j][i]; 
			 }
		 }
		 
		 System.out.println("W Matrix:" );
		 for(int j=0 ;j<3; j++)
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
