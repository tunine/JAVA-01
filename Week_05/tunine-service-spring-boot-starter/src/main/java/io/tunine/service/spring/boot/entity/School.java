package io.tunine.service.spring.boot.entity;

import io.tunine.service.spring.boot.aop.ISchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class School implements ISchool {
    

    private Klass class1;
    

    private Student student100;
    
    //@Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
