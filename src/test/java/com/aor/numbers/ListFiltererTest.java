package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class ListFiltererTest {
    private List<Integer> list;
    @Before
    public void prepareList(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(-5);
        list.add(-8);
    }
    @Test
    public void filterStubs(){
        ListFilterer list = new ListFilterer(this.list);
        IListFilter mockFilterTrue = Mockito.mock(IListFilter.class);
        Mockito.when(mockFilterTrue.accept(any(Integer.class))).thenReturn(true);
        assertEquals(this.list, list.filter(mockFilterTrue));
        IListFilter mockFilterFalse = Mockito.mock(IListFilter.class);
        Mockito.when(mockFilterFalse.accept(any(Integer.class))).thenReturn(false);
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, list.filter(mockFilterFalse));
    }

    @Test
    public void positiveFilter(){
        ListFilterer list = new ListFilterer(this.list);
        List<Integer> positiveList = new ArrayList<>();
        positiveList.add(1);
        positiveList.add(2);
        positiveList.add(3);
        positiveList.add(4);
        assertEquals(positiveList, list.filter(new PositiveFilter()));
    }
    @Test
    public void divisibleFilter(){
        ListFilterer list = new ListFilterer(this.list);
        List<Integer> divisibleList = new ArrayList<>();
        divisibleList.add(2);
        divisibleList.add(4);
        divisibleList.add(-8);
        assertEquals(divisibleList, list.filter(new DivisibleByFilter(2)));
    }
}
