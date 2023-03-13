package org.MavenDemo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {
    Calculator calobj;
    @BeforeEach
    public  void setup(){
        calobj=new Calculator();
    }
    @AfterEach
    public void clearsetup(){
        calobj=null;
    }
    @Test
    public void addSuccess(){
        int output=calobj.add(10,20);
        assertEquals(30,output);
    }
    @Test
    public void addFailer(){
        int output=calobj.add(10,20);
        assertNotEquals(0,output);
    }
    @Test
    public void subSuccess(){
        int output=calobj.sub(10,20);
        assertEquals(-10,output);
    }
    @Test
    public void mulSuccess(){
        int output=calobj.mul(10,20);
        assertEquals(200,output);
    }
    @Test
    public void divSuccess(){
        int output=calobj.div(20,10);
        assertEquals(2,output);
    }
    @Test
    public void modSuccess(){
        int output=calobj.mod(20,3);
        assertEquals(2,output);
    }
}
