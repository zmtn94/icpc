import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=1;t<=T;t++){
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        int p = Integer.parseInt(stk.nextToken());
                        int l = Integer.parseInt(stk.nextToken());
                        if(n==0){
                                System.out.println("FX".substring(p-1,p+l-1));
                        }
                        else if(n==1){
                                System.out.println("FX+YF".substring(p-1,p+l-1));
                        }
                        else
                                System.out.println(go(n,p,l,0));
                }
        }
        public static String go(int n,long p,long l,int state){
                if(p==0 || l==0) return "";
                if(n == 1){
                        p--;
                        if (state == 0){
                                return "FX+YF".substring((int)p,(int)(p+l));
                        }
                        return "FX-YF".substring((int)p,(int)(p+l));
                }
                long len = getLen(n);
                long mid = len/2+1;
                String s = "";
                if(mid == p ){
                        if(state== 0)
                                s = "+";
                        else    s = "-";
                        String temp = go(n-1,1,l-1,1);
                        s = add(s,temp,state);
                }
                else if(mid < p){
                        //mid 를 넘어설때는 mid를 뺴준다.
                        String temp = go(n-1,p-mid,l,1);
                        s = add(s,temp,state);
                }
                else{
                        //중간에 끼는 경우
                        if(mid == p + l -1){
                                String temp = go(n-1,p,l-1,0);
                                s += temp;
                                if(state == 0){
                                        s += '+';
                                }
                                else
                                        s += '-';
                        }
                        else if(mid > p + l -1){
                                String temp = go(n-1,p,l,0);
                                s = temp;
                        }
                        else{
                                s = go(n-1,p,mid - p,0);
                                if(state==0){
                                        s +='+';
                                }
                                else s += '-';
                                String temp = go(n-1,1,l-mid+p-1,1);
                                s = add(s,temp,state);
                        }
                }
                return s;
        }
        public static long getLen(int n){
                return (1L<<(n+1)) +  (1L<<n)-1;
        }
        public static String add(String s,String temp,int state){
                s += temp;
                return s;
        }
}
