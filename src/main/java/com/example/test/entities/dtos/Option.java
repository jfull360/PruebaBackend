package com.example.test.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option<T> {
    private String label;
    private T value;
}
