package org.MavenDemo;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    int c;
    public List<Integer> fseries(int a, int b ,int x){
        List<Integer> fibser=new ArrayList<Integer>();
        for (int i=x;i>2;i--){
            c=a+b;
            a=b;
            b=c;
            fibser.add(c);
        }
        return fibser;
    }
}
