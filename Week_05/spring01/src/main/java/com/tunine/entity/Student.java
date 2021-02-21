package com.tunine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private int id;

    private String name;

    public static Student create(){

        return new Student(ranodm(),"tunine22");
    }

    public static int ranodm()
    {
        int max=100,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min);
        return ran2;
    }
}
