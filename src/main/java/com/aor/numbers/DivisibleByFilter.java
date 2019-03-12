package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    Integer num;
    DivisibleByFilter(Integer num){
        this.num = num;
    }
    @Override
    public boolean accept(Integer number) {
        return ((number % this.num) == 0);
    }
}
