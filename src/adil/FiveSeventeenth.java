package adil;

public class FiveSeventeenth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 double U[][]={{0.1641 , 0.2443, -0.0710},
					{0.6278 ,  0.1070 ,0.2934 }, 
					{-0.2604 ,  -0.8017 ,0.3952 },
					{-0.5389 , 0.4277 ,0.3439},
					{0.4637, -0.1373,0.3644 },  
					{0.0752,  -0.2904,-0.7083}};
		 
		 double u1 = 4.0833;
		 double u2 = 1.2364;
		 double u3 = 0.7428; 
		 
		 
		 for(int i =0; i<U.length;i++)
		 {
			 System.out.print((float)(U[i][0] * Math.sqrt(u1)) + (float)(U[i][1] * Math.sqrt(u2)) +" ");
		 }
		 System.out.println();
		 
		 for(int i =0; i<U.length;i++)
		 {
			 System.out.print((float)(U[i][1] * Math.sqrt(u2)) +" ");
		 }
		 
		 
	}

}
