import java.io.*;
import java.util.Arrays;

public class as_ASYMTILING {
	static int[] DP;
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			int n = Integer.parseInt(in.readLine());
			DP = new int[n+2];
			DP[0] = DP[1] = 1;
			
			sb.append(asy(n)+"\n");
		}
		System.out.println(sb);
	}
	static int search(int n) {
		if(DP[n] != 0) return DP[n];
		return DP[n] = (search(n-1) + search(n-2))%MOD;
	}
	static int asy(int n) {
		if(n%2 == 1) return (search(n) - search(n/2) + MOD)%MOD;
		else {
			int ret = (search(n)-search(n/2) + MOD) % MOD;
			return (ret - search(n/2-1) + MOD)%MOD;
		}
	}
}
