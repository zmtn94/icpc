import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SeungJu {
        static int n,m;
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=0;t<T;t++){
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        n = Integer.parseInt(stk.nextToken());
                        m = Integer.parseInt(stk.nextToken());
                        isFriend = new boolean[n][n];
                        isCheck = new boolean[n];
                        stk = new StringTokenizer(br.readLine());
                        Friend[] friends = new Friend[m];
                        for(int i=0;i<m;i++){
                                int u = Integer.parseInt(stk.nextToken());
                                int v = Integer.parseInt(stk.nextToken());
                                friends[i] = new Friend(u,v);
                        }

                        cnt=0;
                        go(0,friends);
                        System.out.println(cnt);
                }
        }
        static int cnt;
        static boolean[][] isFriend ;
        static boolean[] isCheck;
        static class Friend{
                int u,v;
                public Friend(int u,int v){
                        this.u = u;
                        this.v =v;
                }
        }
        static void go(int index,Friend[] friends){
                if(index == m ){
                        for(int i=0;i<n;i++){
                                if(!isCheck[i]){
                                        return;
                                }
                        }
                        cnt+=1;
                        return;
                }
                if(isCheck[friends[index].u]||isCheck[friends[index].v]){

                }
                else{

                        isCheck[friends[index].u] = true;
                        isCheck[friends[index].v] = true;
                        go(index+1,friends);
                        isCheck[friends[index].u] = false;
                        isCheck[friends[index].v] = false;
                }
                go(index+1,friends);
        }
}