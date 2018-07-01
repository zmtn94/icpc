import java.io.*;
import java.util.*;

public class as_QUANTIZE {
	static int[] arr, tree, s_tree;
	static int N, S;
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			int h = (int)Math.ceil(Math.log(N) / Math.log(2))+1;
			tree = new int[1<<h];
			s_tree = new int[1<<h];
			DP = new int[N+1][S+1];
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			init(1, N, 1);
			s_init(1, N, 1);
			int ans = getMin(1, S);
			System.out.println(ans);
		}
	}
	
	static int getMin(int start, int chunk) {
		if(start >= N) return 0;
		if(DP[start][chunk] != 0) return DP[start][chunk];
		if(chunk == 1) {
			int mean = (int)((sum(start, N, 1, N, 1) / (double)(N-start+1))+0.5);
			return DP[start][chunk] = s_sum(start, N, 1, N, 1) - 2*mean*sum(start, N, 1, N, 1) + mean*mean*(N-start+1);
		}
		
		int ret = Integer.MAX_VALUE;
		for(int i=start; i<=N; i++) {
			int mean = (int)((sum(start, i, 1, N, 1) / (double)(i-start+1))+0.5);
			ret = Math.min(ret, s_sum(start, i, 1, N, 1) - 2*mean*sum(start, i, 1, N, 1) + mean*mean*(i-start+1) + getMin(i+1, chunk-1));
		}
		return DP[start][chunk] = ret;
	}
	
	static int init(int L, int R, int idx) {
		if(L==R) return tree[idx] = arr[L];
		else return tree[idx] = init(L, (L+R)/2, 2*idx) + init((L+R)/2+1, R, 2*idx+1);
	}
	
	static int sum(int sL, int sR, int L, int R, int idx) {
		if(sL > R || sR < L) return 0;
		if(sL <= L && sR >= R) return tree[idx];
		return sum(sL, sR, L, (L+R)/2, idx*2) + sum(sL, sR, (L+R)/2+1, R, 2*idx+1);
	}
	
	static int s_init(int L, int R, int idx) {
		if(L==R) return s_tree[idx] = arr[L]*arr[L];
		else return s_tree[idx] = s_init(L, (L+R)/2, 2*idx) + s_init((L+R)/2+1, R, 2*idx+1);
	}
	
	static int s_sum(int sL, int sR, int L, int R, int idx) {
		if(sL > R || sR < L) return 0;
		if(sL <= L && sR >= R) return s_tree[idx];
		return s_sum(sL, sR, L, (L+R)/2, idx*2) + s_sum(sL, sR, (L+R)/2+1, R, 2*idx+1);
	}
}
