package com.aor.numbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivisibleFilterTest {
    @Test
    public void divisible(){
        DivisibleByFilter filter1 = new DivisibleByFilter(2);
        DivisibleByFilter filter2 = new DivisibleByFilter(1);
        assertTrue(filter1.accept(2));
        assertTrue(filter1.accept(8));
        assertFalse(filter1.accept(3));
        assertTrue(filter2.accept(8));
        assertTrue(filter2.accept(9));
        assertTrue(filter2.accept(10));
    }
}
