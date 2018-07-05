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
                for(int t=0;t<T;t++) {
                        int n = Integer.parseInt(br.readLine());
                        int[] arr = new int[n];
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        for(int i=0;i<n;i++){
                                arr[i] = Integer.parseInt(stk.nextToken());
                        }
                        Stack<Integer> stack = new Stack<Integer>();
                        int ans = 0;
                        for(int i=0;i<n;i++){
                                if(stack.isEmpty()){
                                        stack.push(i);
                                }
                                else{
                                        if(arr[stack.peek()]<arr[i]){
                                                stack.push(i);
                                        }
                                        else{
                                               while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                                                       int index =stack.pop();
                                                       int width = 0 ;
                                                       if(stack.isEmpty()){
                                                                width = i ;
                                                       }
                                                       else{
                                                               width = i - stack.peek() - 1 ;
                                                       }
                                                       ans = Math.max(ans,width*arr[index]);
                                               //        System.out.println(i+" "+ans+" "+arr[index]);
                                               }
                                               stack.push(i);
                                        }
                                }
                        }
                        while(!stack.isEmpty()){
                                int index =stack.pop();
                                int width = 0 ;
                                if(stack.isEmpty()){
                                        width = n ;
                                }
                                else{
                                        width = n - stack.peek() - 1;
                                }
                                ans = Math.max(ans,width*arr[index]);
                        }
                        System.out.println(ans);
                }
        }
}

