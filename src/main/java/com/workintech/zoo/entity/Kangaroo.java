package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {
    private int id;
    private String name;
    private double height;
    private double weight;
    private double sleepHour;
    private double gender;
    private boolean isAggressive;
}
