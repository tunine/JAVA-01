package com.tunine.factory;

import com.tunine.entity.Student;
import org.springframework.beans.factory.FactoryBean;;

public class StudentFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return Student.create();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
