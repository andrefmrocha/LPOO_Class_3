package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    private List<Integer> list = new ArrayList<>();
    private List<Integer> expected = new ArrayList<>();

    public void prepareList(){
        this.list.clear();
        this.expected.clear();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
    }

    @Test
    public void sort() {
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        assertEquals(expected, sorted);

        List<Integer> bugList= new ArrayList<>();
        bugList.add(1);
        bugList.add(2);
        bugList.add(4);
        bugList.add(2);
        List<Integer> bugExpected = new ArrayList<>();
        bugExpected.add(1);
        bugExpected.add(2);
        bugExpected.add(2);
        bugExpected.add(4);

        ListSorter bugSorter = new ListSorter(bugList);
        assertEquals(bugExpected, bugSorter.sort());
    }
}