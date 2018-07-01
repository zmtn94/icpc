import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;

public class Main {
        public static void main(String args[]) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=0;t<T;t++){
                        String input = br.readLine();
                        int n = Integer.parseInt(br.readLine());
                        ArrayList<String> ans = new ArrayList<String>();
                        for(int i=0;i<n;i++){
                                String compare = br.readLine();
                                if(check(input,compare)){
                                        ans.add(compare);
                                }
                        }
                        Collections.sort(ans);
                        for(String s : ans){
                                System.out.println(s);
                        }
                }
        }
        public static boolean check(String input,String compare){
                int len = input.length();
                int len2 = compare.length();
                boolean[][] match = new boolean[len+1][len2+1];
                match[0][0] = true;
                int cnt = 0;
                for(int i=1;i<=len;i++){
                        if(input.charAt(i-1)=='*'){
                                match[i][0] = true;
                                boolean flag = false;
                                for(int j=Math.max(cnt,1);j<=len2;j++){
                                        if(match[i-1][j-1] || flag || match[i-1][j] ){
                                                flag = true;
                                                match[i][j] = flag;
                                        }
                                }
                        }
                        else if(input.charAt(i-1)=='?'){
                                for(int j=Math.max(cnt,1);j<=len2;j++){
                                        if(match[i-1][j-1]){
                                                match[i][j] = true;
                                        }
                                }
                        }
                        else{
                                cnt++;
                                for(int j=cnt;j<=len2;j++){
                                        if(match[i-1][j-1] && input.charAt(i-1) == compare.charAt(j-1)){
                                                match[i][j] = true;
                                        }
                                }
                        }
                }
                return match[len][len2];
        }
}
