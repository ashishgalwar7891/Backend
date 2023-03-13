package org.MavenDemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class LeapYearTest {
    LeapYear lyobj;

    @BeforeEach
    public void setup(){
        lyobj=new LeapYear();
    }
    @AfterEach
    public void setdown(){
        lyobj=null;
    }
    @Test
    public void testleapyear(){
        List<Integer> res=lyobj.findLeapYears(2010,2020);
        assertEquals(Arrays.asList(2012,2016,2020),res);  //true
//        assertEquals(Arrays.asList(2016,2012,2020),res);  //false
    }
}
