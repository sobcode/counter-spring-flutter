package com.springflutter.testtask.service;

import com.springflutter.testtask.entity.Counter;

public interface CounterService {
    Counter getCounter();

    boolean incrementCounter();
}
