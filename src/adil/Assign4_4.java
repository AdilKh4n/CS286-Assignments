package adil;

public class Assign4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] subs = new int[][]{{9,-4,2,2},{-4,9,-5,-5},{2,-5,10,7},{2,-5,7,10}};
		
		//String X = "EJG";
		//String Y = "GEECG";
	
		int X[] = new int[]{0,3,1};
		int Y[] = new int[]{1,0,0,2,1};
		 //int Y[] = new int[]{2,1,3,0,0};
		// int X[] = new int[]{3,3,1,0,2,2,1};
		 
		int n = X.length;
		int m = Y.length;
		int[][] F = new int[n+1][m+1];
		int[][] G = new int[n+1][m+1];
		
		int sum = 0;
		for(int i=0;i<n+1;i++)
		 {
			for(int j=0;j<m+1;j++)
			{
				G[0][j] = j;
				F[0][j] = -3 * j;
	    	}
			F[i][0] = -3 * i;
			
		 }
		
		 System.out.println("G Matrix :");
		 for(int i=0;i<n+1;i++)
		 {
			 for(int j=0;j<m+1;j++)
			 {
				 System.out.print(G[i][j]+",");
			 }
		 System.out.println();
		 }
		 
		 
		 System.out.println("F Matrix :");
		 for(int i=0;i<n+1;i++)
		 {
			 for(int j=0;j<m+1;j++)
			 {
				 System.out.print(F[i][j]+",");
			 }
		 System.out.println();
		 }
		 
		 
		 for(int i=1;i<n;i++)
		 {
			 for(int j=1;j<m;j++)
			 {
				 int a = F[i-1][j-1] + subs[X[i]][Y[j]];
				 int b = F[i-1][j] + (-3 * G[i-1][j]);
				 int c = F[i][j-1] + (-3 * G[i][j-1]);
				
				 F[i][j] = Math.max(a, Math.max(b, c));
				 if(F[i][j] == a)
				 {
					 G[i][j] = 0;
				 }
				 else if(F[i][j] == b)
				 {
					 G[i][j] = (G[i-1][j] + 1);
				 }
				 else
				 {
					 G[i][j] = (G[i][j-1] + 1);
				 }
			 }
		 }
		 System.out.println();
		 
		 for(int i=0;i<n+1;i++)
		 {
			 for(int j=0;j<m+1;j++)
			 {
				 System.out.print(F[i][j]+",");
			 }
			 System.out.println();
		 }
		 
		}

}
