import java.io.*;
import java.util.*;

public class as_NUMB3RS {
	
	static boolean[][] map;
	static int n, d, p;
	static ArrayList<Integer>[] indegree;
	static int[] outdegree;
	static double[][] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			indegree = new ArrayList[n];
			for(int i=0; i<n; i++)
				indegree[i] = new ArrayList<>();
			outdegree = new int[n];
			
			DP = new double[d+1][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<n; j++) {
					if(st.nextToken().charAt(0)=='1') {
						indegree[j].add(i);
						outdegree[i]++;
					}
				}
			}
			
			DP[0][p] = 1;
			int t = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<t; i++) {
				int s = Integer.parseInt(st.nextToken());
				sb.append(update(d, s) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static double update(int d, int position) {
		if(d == 0) return DP[d][position];
		if(DP[d][position] != 0) return DP[d][position];
		
		double ret = 0;
		for(int i=0; i<indegree[position].size(); i++)
			ret += update(d-1, indegree[position].get(i)) / outdegree[indegree[position].get(i)];
			
		return DP[d][position] = ret;
	}
}
