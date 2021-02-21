package io.tunine.starter.test.controller;

import io.tunine.service.spring.boot.aop.ISchool;
import io.tunine.service.spring.boot.entity.Klass;
import io.tunine.service.spring.boot.service.TunineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TunineService tunineService;

    @RequestMapping("/test")
    public String test() {
        Klass klass = tunineService.getKlass();
        ISchool school = tunineService.getSchool();
        System.out.println(klass.toString());
        school.ding();
        return "ok";
    }
}
