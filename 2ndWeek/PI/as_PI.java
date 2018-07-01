import java.io.*;
import java.util.*;

public class as_PI {
	static int[] DP;
	static int len;
	static String str;
	static final int MAX_VALUE = 10*10000/5;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			str = in.readLine();
			len = str.length();
			DP = new int[str.length()+1];
			sb.append(search(0) + "\n");
		}
		System.out.println(sb);
	}
	
	static int search(int idx) {
		if(idx==len) return 0;
		if(DP[idx] != 0) return DP[idx];
		int ans = MAX_VALUE;
		for(int i=3; i<=5 && idx+i<=len; i++)
			ans = Math.min(ans, getScore(str.substring(idx, idx+i)) + search(idx+i));
		return DP[idx] = ans;
	}
	
	/*
	static int search(String str) {
		if(DP[str.length()] != -1) return DP[str.length()];
		int ans = MAX_VALUE;
		for(int i=3; i<=5 && str.length()-i>=0; i++)
			ans = Math.min(ans, getScore(str.substring(0, i)) + search(str.substring(i)));
		return DP[str.length()] = ans;
	}
	*/
	static int getScore(String str) {
		boolean[] check = new boolean[4];
		
		Arrays.fill(check, true);
		int[] score = { 1, 2, 4, 5 };
		
		int d = str.charAt(1) - str.charAt(0);
		int flag = 1;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) != str.charAt(i-1)) check[0] = false;
			if(Math.abs(str.charAt(i)-str.charAt(i-1)) != 1) check[1] = false;
			if(str.charAt(i) - str.charAt(i-1) != d*flag) check[2] = false;
			if(str.charAt(i) - str.charAt(i-1) != d) {
				check[1] = false;
				check[3] = false;
			}
			flag *= -1;
		}
		for(int i=0; i<4; i++)
			if(check[i] == true) return score[i];
		return 10;
	}
}
