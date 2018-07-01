import java.io.*;
import java.util.*;

public class as_JLIS {
	static int[] A, B;
	static int N, M;
	static int[][] DP;
	static final long MIN = Long.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N+1];
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			
			B = new int[M+1];
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=M; i++)
				B[i] = Integer.parseInt(st.nextToken());
			
			DP = new int[N+1][M+1];
			int ans = search(0, 0);
			sb.append(ans-2+"\n");
		}
		System.out.println(sb);
	}
	
	static int search(int a, int b) {
		if(DP[a][b] != 0) return DP[a][b];
		
		int ret = 2;
		long la, lb;
		la = (a==0)? MIN : A[a];
		lb = (b==0)? MIN : B[b];
		long next = Math.max(la, lb);
		
		for(int i=a+1; i<=N; i++)
			if(A[i] > next) ret = Math.max(ret, 1+search(i, b));
		for(int i=b+1; i<=M; i++)
			if(B[i] > next) ret = Math.max(ret, 1+search(a, i));
		
		
		return DP[a][b] = ret;
	}
}
