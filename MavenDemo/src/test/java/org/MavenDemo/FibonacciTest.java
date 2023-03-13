package org.MavenDemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    Fibonacci fibobj;

    @BeforeEach
    public void setup() {
        fibobj = new Fibonacci();
    }

    @AfterEach
    public void setdown(){
        fibobj=null;
    }
    @Test
    public void testfibonacci(){
        List<Integer> res=fibobj.fseries(0,1,10);
        assertEquals(Arrays.asList(1,2,3,5,8,13,21,34),res);
    }
}