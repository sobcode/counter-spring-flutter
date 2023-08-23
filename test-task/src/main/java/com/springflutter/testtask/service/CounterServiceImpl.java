package com.springflutter.testtask.service;

import com.springflutter.testtask.entity.Counter;
import com.springflutter.testtask.repository.CounterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService{
    private CounterDAO counterDAO;

    @Autowired
    public CounterServiceImpl(CounterDAO counterDAO) {
        this.counterDAO = counterDAO;
    }

    @Override
    public Counter getCounter() {
        return counterDAO.getCounterById(1);
    }

    @Override
    public boolean incrementCounter() {
        Counter counter = getCounter();
        counter.setValue(counter.getValue() + 1);
        return counterDAO.updateCounter(counter);
    }
}
