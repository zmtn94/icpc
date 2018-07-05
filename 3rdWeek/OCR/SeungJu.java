import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(stk.nextToken());
                int q = Integer.parseInt(stk.nextToken());
                String[] words = new String[m+1];
                stk = new StringTokenizer(br.readLine());
                HashMap<String,Integer> map = new HashMap<String, Integer>();
                for(int i=1;i<=m;i++){
                        words[i] = stk.nextToken();
                        map.put(words[i],i);
                }
                double[] init = new double[m+1];
                stk = new StringTokenizer(br.readLine());
                for(int i=1;i<=m;i++){
                        init[i] = Double.parseDouble(stk.nextToken());
                }
                double[][] nextP = new double[m+1][m+1];
                for(int i=1;i<=m;i++){
                        stk = new StringTokenizer(br.readLine());
                        for(int j=1;j<=m;j++){
                                nextP[i][j] = Double.parseDouble(stk.nextToken());
                        }
                }
                double[][] classfi = new double[m+1][m+1];
                for(int i=1;i<=m;i++){
                        stk = new StringTokenizer(br.readLine());
                        for(int j=1;j<=m;j++){
                                classfi[i][j] = Double.parseDouble(stk.nextToken());
                        }
                }
                for(int i=0;i<q;i++){
                        stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        String[] subWords = new String[n+1];
                        for(int j=1;j<=n;j++){
                                subWords[j] = stk.nextToken();
                        }
                        double[][] dp = new double[n+1][m+1];
                        int inits = map.get(subWords[1]);
                        int[][] mapping = new int[n+1][m+1];

                        for(int j=1;j<=m;j++){
                                double classf = classfi[j][inits];
                                double initP = init[j];
                                dp[1][j] = initP*classf;
                        }
                        for(int j=2;j<=n;j++){
                                int index = map.get(subWords[j]);
                                mapping[j][index] = map.get(subWords[j-1]);
                                for(int k=1;k<=m;k++){
                                        for(int p=1;p<=m;p++){
                                                double pp = classfi[p][index];
                                                double pp2 = nextP[k][p];
                                                if(dp[j][p] <= pp*pp2*dp[j-1][k]){
                                                        dp[j][p] = pp*pp2*dp[j-1][k];
                                                        mapping[j][p] = k;
                                                }
                                        }
                                }
                        }
                        double ans = 0.0;
                        int last = 0;
                        for(int j=1;j<=m;j++){
                                if(ans <= dp[n][j]){
                                        ans = dp[n][j];
                                        last = j;
                                }
                        }
                        Stack<String> stack = new Stack<String>();
                        int nn = n;
                        while(last != 0){
                                stack.push(words[last]);
                                last = mapping[nn][last];
                                nn--;
                        }
                        while(!stack.isEmpty()){
                                System.out.print(stack.pop()+" ");
                        }
                        System.out.println();
                }
        }
}
