package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositiveFilterTest {

    @Test
    public void accept(){
        PositiveFilter filter = new PositiveFilter();
        assertTrue(filter.accept(2));
        assertFalse(filter.accept(-1));
    }
}
