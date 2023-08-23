package com.springflutter.testtask.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Counter {
    @Id
    private int id;

    private int value;
}
