package org.MavenDemo;

import java.util.ArrayList;
import java.util.List;

public class LeapYear {
    public List<Integer> findLeapYears(int fromyr , int toyr){
        List<Integer> leapyears=new ArrayList<Integer>();
        for(int i=fromyr;i<=toyr;++i){
            if(i%400==0 || (i%4==0 && i%100!=0)){
                leapyears.add(i);
            }
        }
        return leapyears;
    }
}
