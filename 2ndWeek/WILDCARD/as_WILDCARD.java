import java.io.*;
import java.util.*;

public class as_WILDCARD {
	static boolean[][] visit;
	static String W, input;
	static PriorityQueue<String> S = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			W = in.readLine();
			int N = Integer.parseInt(in.readLine());
			for(int n=0; n<N; n++) {
				input = in.readLine();
				visit = new boolean[W.length()][input.length()];
				for(int i=0; i<W.length(); i++)
					Arrays.fill(visit[i], true);
				if(compare(0,0)) S.add(input);
			}
			while(!S.isEmpty())
				sb.append(S.poll()+"\n");	
		}
		
		System.out.println(sb);
	}
	static boolean compare(int idx1, int idx2) {
		
		if(visit[idx1][idx2] == false)
			return false;
		
		while(idx1 < W.length() && idx2 < input.length() && (W.charAt(idx1) == '?' || W.charAt(idx1) == input.charAt(idx2))) {
			idx1++;
			idx2++;
		}
		
		if(idx1 == W.length()) {
			if(idx2 == input.length()) return true;
			return visit[idx1-1][idx2] = false;
		}
		
		else if(W.charAt(idx1) == '*') {
			idx1++;
			if(idx1 >= W.length()) return true;
			for(int i=idx2; i<input.length(); i++) {
				if(compare(idx1, i)) return true;
			}
		}
		return visit[idx1][idx2] = false;
	}
}
