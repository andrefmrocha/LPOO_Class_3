package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

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

        class duplicatorStub implements IListDeduplicator{

            List<Integer> list;
            duplicatorStub(int size){
                this.list = Arrays.asList(new Integer[size]);
            }

            @Override
            public List<Integer> deduplicate(IListSorter sortingList) {
                return this.list;
            }
        }
        int distinct = aggregator.distinct(new duplicatorStub(4));

        assertEquals(4, distinct);

        assertEquals(3, aggregator.distinct(new duplicatorStub(3)));

        List<Integer> mockList = new ArrayList<>();
        mockList.add(1);
        mockList.add(2);
        mockList.add(2);
        IListDeduplicator mockDedup = Mockito.mock(IListDeduplicator.class);

        Mockito.when(mockDedup.deduplicate(any(IListSorter.class))).thenReturn(mockList);

        assertEquals(3, aggregator.distinct(mockDedup));
    }
}