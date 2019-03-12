package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {


    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();

    @Before
    public void prepareList(){
        this.list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        this.expected.clear();
        expected.add(1);
        expected.add(2);
        expected.add(4);
    }


    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        class stubListSorter implements IListSorter{
            @Override
            public List<Integer> sort() {
                List<Integer> list= new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                return list;
            }
        }
        List<Integer> distinct = deduplicator.deduplicate(new stubListSorter());

        assertEquals(expected, distinct);


    }
}