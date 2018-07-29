import java.io.*;
import java.util.*;

public class as_SUSHI {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken())/100;
			
			int[] price = new int[n];
			int[] value = new int[n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				price[i] = Integer.parseInt(st.nextToken())/100;
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] DP = new int[201];
			for(int money=0; money<=m; money++) {
				int ret = 0;
				for(int i=0; i<n; i++) {
					if(money-price[i]>=0) {
						ret = Math.max(ret, DP[(money-price[i])%200] + value[i]);
					}
				}
				DP[money%200] = ret;
			}
			sb.append(DP[m%200] + "\n");
		}
		System.out.println(sb);
		
	}
}
