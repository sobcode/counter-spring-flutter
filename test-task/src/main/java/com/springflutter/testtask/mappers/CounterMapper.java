package com.springflutter.testtask.mappers;

import com.springflutter.testtask.entity.Counter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CounterMapper implements RowMapper<Counter> {

    @Override
    public Counter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Counter counter = new Counter();
        counter.setId(rs.getInt("id"));
        counter.setValue(rs.getInt("value"));

        return counter;
    }
}
