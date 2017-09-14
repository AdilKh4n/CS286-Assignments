package adil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	//	System.out.println("Enter the plain text");
	//	String pl=sc.nextLine();
	//	pl=pl.toLowerCase();
	//	System.out.println(pl);
		System.out.println("Enter the shift factor");
		int n=sc.nextInt();
		
String s1="abcdefghijklmnopqrstuvwxyz";  
		
		System.out.print("Plaintext - ciphertext mapping \n");
		char[] ch=s1.toCharArray();  
		for(int i=0;i<ch.length;i++)
		{  
		System.out.print(ch[i]);  
		}  
		
		for(int i=0;i<ch.length;i++)
		{
			//System.out.print((int)ch[i]);
			if(n + (int)ch[i] > 122)
			{
				ch[i]=(char)((int)(ch[i] - 26));
			//	System.out.print("in heres");
			}
			ch[i]=(char)(n+(int)ch[i]);
		}
		
		System.out.println(); 
		
		for(int i=0;i<ch.length;i++)
		{
			System.out.print(ch[i]);
		}
		System.out.println();
	//	System.out.println("Cipher Text:");
	//	char a[]= pl.toCharArray();
		
		int maxchar=0,T = 0;
		System.out.println("Enter Maximum Number of characters");
		maxchar = sc.nextInt();
		char mes[] = new char[maxchar + 1];
		int maincount = 0;
		int seed = 0;
		int minIters = 0;
		double oldLogProb, logProb;
		logProb = 0;
		oldLogProb = -999999999;
		double threshold = 0.0;

		System.out.println("Enter Minimum Number of re-estimation iteration");
		minIters = sc.nextInt();

		System.out.println("Enter seed:");
		seed = sc.nextInt();

		
		
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
			System.out.print(e + "exception here \n");
		}
		
		
		
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
	int M = 27, N = 2;
	double A[][] = new double[][] { { 0.52, 0.48 }, { 0.41571, 0.58429 }};
	double B[][] = new double[N][M];
	double pi[] = new double[] { 0.00000, 1.00000};
	double oldlogProb = -999999999;
	int iters = 0;

	// System.out.println(count);
	int O[] = new int[T];
	for (int i = 0; i < maincount; i++) {
		if (mes[i] >= 'a' && mes[i] <= 'z')
			O[i] = (int) mes[i] - 97;
		else if (mes[i] == ' ')
			O[i] = 26;

	}
	
	double alpha[][] = new double[T][N];
	double beta[][] = new double[T][N];
	double gammas[][] = new double[T][N];
	double digammas[][][] = new double[T][N][N];
	double pr, f1, f12;
	Random rand = new Random(seed);
	pr = 1.0 / (double) N;
	f1 = pr / 10.0;
	f12 = 0.0;

	pr = 1.0 / (double) M;
	f1 = pr / 10.0;
	for (int i = 0; i < N; ++i) {
		f12 = 0.0;
		for (int j = 0; j < M; ++j) {
			if ((rand.nextInt() & 0x1) == 0) {
				B[i][j] = pr + (double) (rand.nextInt() & 0x7) / 8.0 * f1;
			} else {
				B[i][j] = pr - (double) (rand.nextInt() & 0x7) / 8.0 * f1;
			}
			f12 += B[i][j];

		} // next j

		for (int j = 0; j < M; ++j) {
			B[i][j] /= f12;
		}

	}

	//System.out.println(T);
	iters = 0;
	double c[] = new double[T];
	while (iters < minIters && Math.abs(logProb - oldLogProb) > threshold) {
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

		for (int t = 1; t < T; t++) {
			c[t] = 0;
			for (int i = 0; i < N; i++) {
				alpha[t][i] = 0;
				for (int j = 0; j < N; j++) {
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
		}

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

		// Calculating if required to iterate

		// if(iteration%100==0)
		// System.out.println("PASS "+iteration+ "= "+ logProb);
		iters = iters + 1;
		//System.out.println(iters);
	}
	System.out.println("A Matrix Sum: ");
	System.out.print(A[0][0] + A[0][1]);

	System.out.println("\n\nB Matrix");
	int alphabets = 97;
	for (int i = 0; i < M; i++) {
		System.out.print((char) alphabets);
		System.out.print(" ");
		alphabets++;
		for (int j = 0; j < N; j++) {
			System.out.print(B[j][i] + "       ");
		}
		System.out.println(" ");
	}

	sc.close();
	}
}
