import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=1;t<=T;t++) {
                        int n = Integer.parseInt(br.readLine());
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        Food[] foods = new Food[n];
                        for(int i=0;i<n;i++){
                                foods[i] = new Food();
                                foods[i].time = Integer.parseInt(stk.nextToken());
                        }
                        stk = new StringTokenizer(br.readLine());
                        for(int i=0;i<n;i++){
                                foods[i].eating = Integer.parseInt(stk.nextToken());
                        }
                        Arrays.sort(foods);
                        int time = 0 ;
                        int max = 0 ;
                        for(int i=0;i<n;i++){
                                time += foods[i].time;
                                max = Math.max(max,time+foods[i].eating);
                        }
                        System.out.println(max);
                }
        }
        public static class Food implements Comparable<Food>{
                int time,eating;

                @Override
                public int compareTo(Food o) {
                        return -(eating - o.eating);
                }
        }
}
