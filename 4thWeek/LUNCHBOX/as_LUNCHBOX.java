import java.io.*;
import java.util.*;

public class as_LUNCHBOX {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			int n = Integer.parseInt(in.readLine());
			
			ArrayList<Node_LUNCHBOX> arr = new ArrayList<>();
			StringTokenizer st1 = new StringTokenizer(in.readLine());
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++)
				arr.add(new Node_LUNCHBOX(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())));
			
			Collections.sort(arr, new Comparator<Node_LUNCHBOX>() {
				@Override
				public int compare(Node_LUNCHBOX o1, Node_LUNCHBOX o2) {
					// TODO Auto-generated method stub
					return o2.eat - o1.eat;
				}
			});
			
			long ans = 0;
			long begin = 0;
			for(int i=0; i<n; i++) {
				begin += arr.get(i).heat;
				ans = Math.max(ans, begin+arr.get(i).eat);
			}
			sb.append(ans+"\n");
			
		}
		System.out.println(sb);
	}
}
class Node_LUNCHBOX {
	int heat, eat;
	public Node_LUNCHBOX(int h, int e) {
		this.heat = h;
		this.eat = e;
	}
}