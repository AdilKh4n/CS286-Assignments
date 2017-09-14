package adil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class fifteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

Scanner input = new Scanner(System.in);
int maxchar,T;
int maincount1 = 0;

double oldLogProb, logProb;
int minIters = 0;
logProb = 0;
oldLogProb = -999999999;

//char mes[] = new char[maxchar + 1];


//System.out.println("Enter seed:");
//seed = input.nextInt();

//T = maincount;
int M = 54, N = 26;
//double A[][] = new double[][] { { 0.25596, 0.74404 }, { 0.71571, 0.28429 }};
//double B[][] = new double[N][M];
//double pi[] = new double[] { 0.00000, 1.00000};
double oldlogProb = -999999999;



	
	
	//System.out.println("give 100000 value");
//		Scanner sc = new Scanner(System.in);
//	int diagraphc = input.nextInt();
int diagraphc = 1000000;
	char mes1[] = new char[diagraphc + 1];
	
	
	try {

		BufferedReader reader1 = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/adilkhan/Downloads/BrownCorpus")));
		char temp1[] = new char[diagraphc + 1];
		
		
		int T1 = 0;
		int count1 = 0;
		maincount1 = 0;
		String line1 = new String();
		while ((line1 = reader1.readLine()) != null) {
			line1 = line1.toLowerCase();
			temp1 = line1.toCharArray();
			count1++;
			int length2 = temp1.length;
			int startpo = 15;
			while (temp1[startpo] == ' ') {
				startpo++;
			}
			for (int i = startpo; i < length2; i++) {

				if (temp1[i] >= 'a' && temp1[i] <= 'z') {
					mes1[maincount1] = temp1[i];
					maincount1++;
				}
				if (maincount1 > diagraphc)
					break;

			}
			if (maincount1 > diagraphc)
				break;
		}
		reader1.close();
	} 
	catch (Exception e) {
		System.out.print(e);
		
	}
	
	HashMap hm = new HashMap<Character,Integer>();
	
	
	int alphabet = 97;
	
	for (int i = 0; i < 26;i ++)
	{
		hm.put((char) alphabet,i);
		alphabet ++;
	}
	
	System.out.println(hm.keySet());
	System.out.println(hm.values());
	
	double diagraph[][] = new double[26][26];
	
	
	for(int i=0; i < mes1.length - 1;i++)
	{
		diagraph[(int) hm.get(mes1[i])][(int) hm.get(mes1[i+1])] = diagraph[(int) hm.get(mes1[i])][(int) hm.get(mes1[i+1])] + 1;
	}
	
	System.out.println("Diagraph matrix");
	System.out.println(" " + hm.keySet());
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<26;j++)
		{
			System.out.print("  "+ diagraph[i][j]);
		}
		System.out.print("\n");
	}
	
	
	System.out.println("New Diagraph matrix");
	System.out.println(" " + hm.keySet());
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<26;j++)
		{
			System.out.print("  " + (diagraph[i][j] + 5));
		}
		System.out.print("\n");
	}
	
	double rowsum[] = new double[26];
	
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<26;j++)
		{
			rowsum[i] =  rowsum[i] + (diagraph[i][j] + 5);
		}

	}
	

	
	double sum =0;
	System.out.println("New Diagraph matrix - A Matrix:");
	System.out.println(" " + hm.keySet());
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<26;j++)
		{
			System.out.print("  " + (float) (diagraph[i][j] + 5) / rowsum[i]);
			sum = sum + (double) (diagraph[i][j] + 5) / rowsum[i];
			diagraph[i][j] = (double) (diagraph[i][j] + 5) / rowsum[i];
		}
		System.out.print(" Sum " + sum);
		System.out.print("\n");
		sum = 0.0;
	}
	
	
	int O[] =new int[]
			{1,2,3,4,5,4,6,7,2,8,9,10,11,12,13,11,7,14,15,16,17,18,19,20,21,1,22,3,23,24,25,26,19,17,
27,28,19,29,6,30,8,31,26,32,33,34,35,19,36,37,38,39,40,4,1,2,7,3,9,10,41,6,2,42,10,43,26,44,
8,29,45,27,5,28,46,47,48,12,20,22,15,14,17,31,19,23,16,26,18,36,1,24,30,38,21,26,13,49,37,50,39,40,
10,34,33,30,19,44,43,9,1,26,18,7,32,21,39,2,7,45,46,4,3,2,7,23,13,26,44,22,27,6,29,10,10,8,51,5,24,26,12,30,38,14,26,25,49,37,45,27,47,1,52,
7,3,36,10,16,28,11,21,48,34,40,17,44,6,22,8,20,5,51,12,9,15,14,30,37,16,33,45,38,43,29,10,21,22,
30,1,36,10,53,32,19,47,48,46,17,4,23,13,28,35,41,
3,37,27,49,10,6,33,2,45,38,34,15,44,24,22,11,18,
47,30,25,28,8,37,1,49,45,27,43,34,41,38,5,40,3,
50,6,12,8,41,1,52,7,15,14,48,16,15,32,33,9,3,
29,11,39,47,43,42,6,17,21,31,36,50,18,2,2,25,27,34,8,38,39,51,44,4,1,2,2,5,42,41,3,52,7,15,12,17,13,26,14,26,53,20,52,49,51,16,23,1,41,1,7,
2,9,32,37,10,6,51,16,53,46,19,26,53,29,39,26,14,15,5,17,18,19,24,44,53,32,19,41,1,2,52,45,33,53,
22,25,20,7,13,1,50,13,41,36,46,48,31,45,25,11,26,53,17,46,52,52,21,17,37,3,9,10,13,35,20,2,18,51,5,23,28,32,33,26,53,49,28,30,16,47,7,3,35,14,21,15,44,13,47,1,14,30,21,26,44,22,27,38,11,19,30,8};
	T = O.length;
	
	System.out.println("Enter number of iterations");
	int usvalue = input.nextInt();
	
	float[] arr = new float[usvalue];
	int n = 0;
	while (n < usvalue)
	{
	double B[][]= new double[26][54];  
	Random rm = new Random();
	//System.out.println(rm.nextInt(100) + 1);
	
	for(int i=0; i < 26;i++)
	{
		for(int j=0; j<54; j++)
		{
			B[i][j] = rm.nextInt(100) + 1;
		}
	}
	
	/*for(int i=0; i < 26;i++)
	{
		for(int j=0; j<26; j++)
		{
			System.out.print(B[i][j] + " ");
		}
		System.out.println();
	}*/
	
	double rowsum1[] = new double[26];
	
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<54;j++)
		{
			rowsum1[i] = rowsum1[i] + B[i][j];
		}
	}
	
	Double sum1 = 0.0;
	System.out.println("B Matrix: ");
//	System.out.println(" " + hm.keySet());
	for (int i =0; i<26;i++)
	{
		for(int j=0; j<54;j++)
		{
			System.out.print("  " + (float) (B[i][j] + 5) / rowsum1[i]);
			sum1 = sum1 + (double) (B[i][j] + 5) / rowsum1[i];
			B[i][j] = (double) (B[i][j] + 5) / rowsum1[i];				
		}
		System.out.print(" Sum " + sum1);
		System.out.print("\n");
		sum1 = 0.0;
	}
	
	double pi[] = new double[26];
	double rowsum2 = 0.0;
	
	for(int i=0; i < 26;i++)
	{
		pi[i]= rm.nextInt(100) + 1;
		rowsum2 = rowsum2 + pi[i];
	}
	
	Double sum2 = 0.0;
	System.out.println("pi Matrix");
	for (int i =0; i<26;i++)
	{
			System.out.print("  " + pi[i] / rowsum2);
			sum2 = sum2 + pi[i] / rowsum2;
			pi[i] =  pi[i] / rowsum2;
	}
		System.out.print(" Sum " + sum2);
		System.out.print("\n");
	//	System.out.print(maincount1);
	
		
		
		
		
		double alpha[][] = new double[T][N];
		double beta[][] = new double[T][N];
		double gammas[][] = new double[T][N];
		double digammas[][][] = new double[T][N][N];
		double A[][] = diagraph;
		
		double c[] = new double[T];
	//	System.out.println("Enter Minimum Number of re-estimation iteration");
	//	minIters = input.nextInt();
		//System.out.println(minIters);
		
		int iters = 0;
		logProb = 0;
		double threshold = 0.001;
		while ( iters < 200 || Math.abs(logProb - oldLogProb) > threshold   ) 
		{
			// compute alpha[0][i]
			
			oldLogProb = logProb;
			c[0] = 0;
			for (int i = 0; i < N; i++) {
				alpha[0][i] = pi[i] * B[i][O[0]];
				c[0] = c[0] + alpha[0][i];
			}

			// scale the alpha[0][i]
			c[0] = 1 / c[0];
			for (int i = 0; i < N; i++) {
				alpha[0][i] = c[0] * alpha[0][i];
			}

			// compute alpha[t][i]

			for (int t = 1; t < T; t++) 
			{
				c[t] = 0;
				for (int i = 0; i < N; i++) 
				{
					alpha[t][i] = 0;
					for (int j = 0; j < N; j++) 
					{
						alpha[t][i] = alpha[t][i] + alpha[t - 1][j] * A[j][i];
					}
					alpha[t][i] = alpha[t][i] * B[i][O[t]];
					c[t] = c[t] + alpha[t][i];
				}

				// scale alpha[t][i]

				c[t] = 1 / c[t];
				for (int i = 0; i < N; i++) {
					alpha[t][i] = c[t] * alpha[t][i];
				}
			}

			// Backward algorithm or beta-pass

			// Let beta[T-1][i] = 1 scaled by C[T-1]

			for (int i = 0; i < N; i++) {
				beta[T - 1][i] = c[T - 1];
			}

			//B-pass
			for (int t = T - 2; t >= 0; t--) {
				for (int i = 0; i < N; i++) {
					beta[t][i] = 0;
					for (int j = 0; j < N; j++) {
						beta[t][i] = beta[t][i] + A[i][j] * B[j][O[t + 1]] * beta[t + 1][j];
					}
					beta[t][i] = c[t] * beta[t][i];
				}
			}
			// compute the gammas and di-gammas

			double denom = 0;

			for (int t = 0; t < T - 1; t++) {
				denom = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						denom = denom + alpha[t][i] * A[i][j] * B[j][O[t + 1]] * beta[t + 1][j];
					}
				}

				for (int i = 0; i < N; i++) {
					gammas[t][i] = 0;
					for (int j = 0; j < N; j++) {
						digammas[t][i][j] = (alpha[t][i] * A[i][j] * B[j][O[t + 1]] * beta[t + 1][j]) / denom;
						gammas[t][i] = gammas[t][i] + digammas[t][i][j];
					}
				}
			}

			// Special case for gammas[T-1][i]
			denom = 0;
			for (int i = 0; i < N; i++) {
				denom = denom + alpha[T - 1][i];
			}
			for (int i = 0; i < N; i++) {
				gammas[T - 1][i] = alpha[T - 1][i] / denom;
			}

			// Re-estimate the model lamda = (A,B,pi)

			// re-estimate pi
			for (int i = 0; i < N; i++) {
				pi[i] = gammas[0][i];
			}

			// re-estimate A

			double numer = 0;
			/*
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					numer = 0;
					denom = 0;
					for (int t = 0; t < T - 1; t++) {
						numer = numer + digammas[t][i][j];
						denom = denom + gammas[t][i];
					}

					A[i][j] = numer / denom;
				}
			}*/

			// re-estimate B

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					numer = 0;
					denom = 0;
					for (int t = 0; t < T; t++) {
						if (O[t] == j) {
							numer = numer + gammas[t][i];
						}

						denom = denom + gammas[t][i];
					}
					B[i][j] = numer / denom;
				}
			}

			// Compute log(P(O|Lamda))

			logProb = 0;
			for (int i = 0; i < T; i++) {
				logProb = logProb + Math.log(c[i]);
			}
			logProb = -logProb;

			System.out.println(iters + Math.abs(logProb - oldLogProb));
			// Calculating if required to iterate

			// if(iteration%100==0)
			// System.out.println("PASS "+iteration+ "= "+ logProb);
			iters=iters+1;
		}

		System.out.println("\n\nB Matrix");
		int alphabets = 97;
		for (int i = 0; i < M; i++) 
		{
			//System.out.print((char) alphabets);
			System.out.print(" ");
			alphabets++;
			for (int j = 0; j < N; j++) 
			{
				System.out.printf("%f", B[j][i]);
				System.out.print("\t");
			}
			System.out.println(" ");
		}

		int puta = 0;
		int equals = 0;
		
		//int i = 0;
		
	/*	for(int j=0; j<25;j++)
		{
				if(B[j][i] < B[j+1][i])
				{
					puta++;
				}
				else if(B[j][i] == B[j+1][i])
				{
					equals++;
				}
				i++;
		}
		*/
		int[] max = new int[26];
		int k=0;
		double maxval = 0;
		
		for(int i=0; i<26;i++)
		{
			for(int j=0; j<26; j++)
			{
				if(B[i][j] >maxval)
				{
					System.out.println("j"+ j + "i" +i + "k" + k + (float) B[i][j]);
					maxval = B[i][j];
					max[k] = j;
					System.out.println("Max of column "+i + " " + B[i][j]);
				}
			}
			maxval = 0;
			k++;
		}
	
		
		/*for(int i = 0; i< 26; i++)
		{
			System.out.println(max[i]);
		}
		*/
		int p = 1;
		for(int i = 0; i< 26; i++)
		{
				if(max[i] == p)
				{
					puta++;
				}
				
				else if (i == 25)
				{
					if(max[i] == 0)
						puta++;
				}
				p++;
		}
			System.out.println("putative score for run " + n + ": " + (float) puta / 26 * 100);
	arr[n] = (float)puta / 26 * 100 ;
	n = n + 1;
}

float maxx = 0 ;
for (int i = 0; i< arr.length; i++)
{
	if(arr[i] > maxx)
	{
		maxx = arr[i];
	}
}

System.out.println("Final Max putative score: " + maxx);
input.close();


	}

}
