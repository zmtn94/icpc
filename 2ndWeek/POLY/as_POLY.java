import java.io.*;

public class as_POLY {
	
	static int[][] DP = new int[101][101];
	static final int MOD = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			int n = Integer.parseInt(in.readLine());
			int ans = 0;
			for(int i=1; i<=n; i++) {
				ans += getCount(i, n-i);
				ans %= MOD;
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
	
	static int getCount(int w, int n) {
		if(n == 0) return 1;
		if(DP[w][n] != 0) return DP[w][n];
		int ret = 0;
		for(int i=1; i<=n; i++) {
			ret += (w+i-1)*getCount(i, n-i);
			ret %= MOD;
		}
		return DP[w][n] = ret;
	}
}
