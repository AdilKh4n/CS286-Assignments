package adil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class fourteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int maxchar, T;
		
		int maincount = 0;
		int maincount1 = 0;
		
		double oldLogProb, logProb;
		int minIters = 0;
		logProb = 0;
		oldLogProb = -999999999;

		System.out.println("Enter Maximum Number of characters");
		maxchar = input.nextInt();
		
		System.out.println("Enter the shift factor");
		int n=input.nextInt();

		char mes[] = new char[maxchar + 1];
		
		
		//System.out.println("Enter seed:");
		//seed = input.nextInt();

		

		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("/Users/adilkhan/Downloads/BrownCorpus")));
			char temp[] = new char[maxchar];

			T = 0;
			String line = new String();
			int count = 0;
			while ((line = reader.readLine()) != null) {
				line = line.toLowerCase();
				temp = line.toCharArray();
				count++;
				int length1 = temp.length;
				int startpo = 15;
				while (temp[startpo] == ' ') {
					startpo++;
				}
				for (int i = startpo; i < length1; i++) {

					if (temp[i] >= 'a' && temp[i] <= 'z') {
						mes[maincount] = temp[i];
						maincount++;
					} 
					if (maincount > maxchar)
						break;

				}
				if (maincount > maxchar)
					break;
			}
			reader.close();
		} 
		catch (Exception e) {
			System.out.print(e.toString());
		}
		
		System.out.println("plain Text: ");
		for(int i=0; i<mes.length ;i++)
		{
			System.out.print(mes[i]);
		}
		System.out.print("\n");
		
		for(int i=0;i<mes.length;i++)
		{
			//System.out.print((int)ch[i]);
			if(n + (int)mes[i] > 122)
			{
				mes[i]=(char)((int)(mes[i] - 26));
			//	System.out.print("in heres");
			}
			mes[i]=(char)(n+(int)mes[i]);
		}
		System.out.println();
		
		System.out.println("Encrypted Text: ");
		for(int i=0; i<mes.length ;i++)
		{
			System.out.print(mes[i]);
		}
		System.out.print("\n");
		
		
		T = maincount;
		int M = 26, N = 26;
		//double A[][] = new double[][] { { 0.25596, 0.74404 }, { 0.71571, 0.28429 }};
		//double B[][] = new double[N][M];
		//double pi[] = new double[] { 0.00000, 1.00000};
		double oldlogProb = -999999999;
		
		
		
			
			
			//System.out.println("give 100000 value");
	//		Scanner sc = new Scanner(System.in);
	//	int diagraphc = input.nextInt();
		int diagraphc = 1000000;
			char mes1[] = new char[diagraphc + 1];
			maincount = 0;
			
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
			
			System.out.println("length of diagraph" + mes1.length);
			System.out.println("length of encrypted text" + mes.length);
			
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

			T = 300;
			int O[] = new int[T];
			for (int i = 0; i < 300; i++) {
				if (mes[i] >= 'a' && mes[i] <= 'z')
					O[i] = (int) mes[i] - 97;
				
			}
			
			System.out.println("Enter number of iterations");
			int usvalue = input.nextInt();
			
			float[] arr = new float[usvalue];
			while (n < usvalue)
			{
			double B[][]= new double[26][26];  
			Random rm = new Random();
			//System.out.println(rm.nextInt(100) + 1);
			
			for(int i=0; i < 26;i++)
			{
				for(int j=0; j<26; j++)
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
				for(int j=0; j<26;j++)
				{
					rowsum1[i] = rowsum1[i] + B[i][j];
				}
			}
			
			Double sum1 = 0.0;
			System.out.println("B Matrix: ");
		//	System.out.println(" " + hm.keySet());
			for (int i =0; i<26;i++)
			{
				for(int j=0; j<26;j++)
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

					//System.out.println(iters + "Chutiya ho gaya main" + " " + Math.abs(logProb - oldLogProb));
					// Calculating if required to iterate

					// if(iteration%100==0)
					// System.out.println("PASS "+iteration+ "= "+ logProb);
					iters=iters+1;
				}

				System.out.println("\n\nB Matrix");
				int alphabets = 97;
				for (int i = 0; i < M; i++) 
				{
					System.out.print((char) alphabets);
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
				//			System.out.println("j"+ j + "i" +i + "k" + k + (float) B[i][j]);
							maxval = B[i][j];
							max[k] = j;
					//		System.out.println("Max of column "+i + " " + B[i][j]);
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
				
			//]	int tot = puta + equals;
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
