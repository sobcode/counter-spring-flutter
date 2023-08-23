package com.springflutter.testtask.repository;

import com.springflutter.testtask.entity.Counter;

public interface CounterDAO {
    Counter getCounterById(int id);

    boolean updateCounter(Counter counter);
}
