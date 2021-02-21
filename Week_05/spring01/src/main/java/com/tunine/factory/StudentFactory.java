package com.tunine.factory;

import com.tunine.entity.Student;

/**
 * 默认工厂
 */
public interface StudentFactory {

    default Student createStudent(){
        return Student.create();
    }
}
