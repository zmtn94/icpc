import java.io.*;
import java.util.*;

public class as_NUMBERGAME {
	
	static int ans;
	static int[] map;
	static int[][] DP;
	static int INF = -100_001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		
		for(int c=0; c<C; c++) {
			int n = Integer.parseInt(in.readLine());
			map = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			DP = new int[n][n];
			for(int i=0; i<n; i++)
				Arrays.fill(DP[i], INF);
			sb.append(startGame(0, n-1)+"\n");
		}
		System.out.println(sb);
	}
	static public int startGame(int idx1, int idx2) {
		if(idx1 > idx2)
			return 0;
		
		if(DP[idx1][idx2] != INF) return DP[idx1][idx2];
		int temp = INF;
		// 왼쪽 선택
		temp = Math.max(temp, map[idx1] - startGame(idx1+1, idx2));
		// 오른쪽 선택
		temp = Math.max(temp, map[idx2] - startGame(idx1, idx2-1));
		
		if(idx2 - idx1 >= 1) {
			// 왼쪽 두개 제거
			temp = Math.max(temp, -startGame(idx1+2, idx2));
			// 오른쪽 두개 제거
			temp = Math.max(temp, -startGame(idx1, idx2-2));
		}
		
		return DP[idx1][idx2] = temp;
	}
}

			
			