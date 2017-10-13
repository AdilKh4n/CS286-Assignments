package adil;

public class FiveThirteenthc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 double delta[][] = {{-1.1069,1.2794, -2.68,2.5076},
	 			 {1.5480,0.5484,-1.2085,-0.8879}};
		 
		// double Y[] = {1,5,1,5,5,1};
		// double Y[] = {-2,3,2,3,0,2};
		//double Y[] = {2,-3,2,3,0,0};
		 double Y[] = {2,-2,2,2,-1,1};
		 double u[] = {1.75,1.75,1.25,2,2,1};
		 
 double Y1[] = new double[Y.length];
		 
		 for(int i=0; i<Y.length; i++)
		 {
			 Y1[i] = Y[i] - u[i];
		 }
		 
		 double U[][]={{0.1641 , 0.2443},
					{0.6278 ,  0.1070  }, 
					{-0.2604 ,  -0.8017 },
					{-0.5389 , 0.4277 },
					{0.4637, -0.1373 },  
					{0.0752,  -0.2904}};
		 
		 double W[] = new double[2];
		 
		 for(int i=0 ; i < 2 ; i++)
		 {	 
			 for(int j=0 ;j<Y1.length; j++)
			 {
				 W[i] += Y1[j] * U[j][i]; 
			 }
		 }
		
		 System.out.println("W Matrix:");
		 for(int j=0 ;j<2; j++)
		 {
			 System.out.println(W[j]);
		 }
		 
		 double E[] = new double[4];
		 
		 for(int i=0 ; i<4 ; i++)
		 {
			 for(int j=0 ; j<2;j++)
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
