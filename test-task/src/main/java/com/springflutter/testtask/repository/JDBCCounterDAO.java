package com.springflutter.testtask.repository;

import com.springflutter.testtask.entity.Counter;
import com.springflutter.testtask.mappers.CounterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JDBCCounterDAO implements CounterDAO {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_COUNTER = "select * from counter where id = ?";
    private final String SQL_UPDATE_COUNTER = "update counter set value = ? where id = ?";

    @Autowired
    public JDBCCounterDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Counter getCounterById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_COUNTER, new CounterMapper(), id);
    }

    @Override
    public boolean updateCounter(Counter counter) {
        return jdbcTemplate.update(SQL_UPDATE_COUNTER, counter.getValue(), counter.getId()) > 0;
    }

}
