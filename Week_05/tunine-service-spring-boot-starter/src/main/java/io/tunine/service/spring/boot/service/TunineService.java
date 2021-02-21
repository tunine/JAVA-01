package io.tunine.service.spring.boot.service;

import io.tunine.service.spring.boot.aop.ISchool;
import io.tunine.service.spring.boot.entity.Klass;
import io.tunine.service.spring.boot.entity.School;
import io.tunine.service.spring.boot.entity.Student;

import java.util.Arrays;

public class TunineService {


    private Student student;

    public TunineService(Student student){
        this.student = student;
    }

    public Klass getKlass(){
        return  new Klass(Arrays.asList(this.student));
    }

    public ISchool getSchool(){
        return new School(getKlass(),this.student);
    }
}
