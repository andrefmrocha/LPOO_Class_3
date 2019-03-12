package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list = new ArrayList<>();

    @Before
    public void prepareList(){
        this.list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }
    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);

        List<Integer> bugTest = new ArrayList<>();
        bugTest.add(-1);
        bugTest.add(-4);
        bugTest.add(-5);

        ListAggregator bugAggregator = new ListAggregator(bugTest);

        int bugMax = bugAggregator.max();

        assertEquals(-1, bugMax);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct();

        assertEquals(4, distinct);
    }
}