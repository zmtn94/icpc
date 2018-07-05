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
                        String s = br.readLine();
                        int len = s.length();
                        Stack<Square> stack = new Stack<Square>();
                        Square start = new Square();
                        stack.add(start);
                        if(len == 1){
                                System.out.println(s);
                                continue;
                        }
                        for(int i=0;i<len;i++){
                              //  System.out.println(s.charAt(i));
                                if(s.charAt(i)=='x'&&i!=0){
                                        Square ss = new Square();
                                        stack.peek().squares.add(ss);
                                        stack.add(ss);
                                }
                                else{
                                        if(s.charAt(i)=='x')continue;
                                        stack.peek().squares.add(new Square(s.charAt(i)));
                                }
                                while(!stack.isEmpty()&&stack.peek().squares.size()==4){
                                        stack.pop();
                                }
                        }
                        //System.out.println(start.squares.size());
                        reverse(start);
                       // System.out.println("reverse");
                        iterate(start);
                        System.out.println();
                }
        }
        public static void iterate(Square start){
                System.out.print('x');
                for(int i=0;i<4;i++){
                        if(start.squares.get(i).type!=' '){
                                System.out.print(start.squares.get(i).type);
                        }
                        else{
                                iterate(start.squares.get(i));
                        }
                }
        }
        public static void reverse(Square start){
                Square temp = start.squares.get(0);
                start.squares.set(0,start.squares.get(2));
                start.squares.set(2,temp);
                temp = start.squares.get(1);
                start.squares.set(1,start.squares.get(3));
                start.squares.set(3,temp);
                for(int i=0;i<4;i++){
                        if(start.squares.get(i).type==' '){
                                reverse(start.squares.get(i));
                        }
                }
        }
        public static class Square{
                ArrayList<Square> squares = new ArrayList<Square>();
                char type = ' ';
                public Square(){

                }
                public Square(char type){
                        this.type = type;
                }
        }
}
