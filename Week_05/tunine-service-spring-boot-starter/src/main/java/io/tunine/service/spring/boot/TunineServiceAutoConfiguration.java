package io.tunine.service.spring.boot;

import io.tunine.service.spring.boot.entity.Student;
import io.tunine.service.spring.boot.service.TunineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(TunineService.class)
// 必须，绑定我们的配置文件类
@EnableConfigurationProperties(Student.class)
@ConditionalOnProperty(prefix = "myservice", value = "enabled", matchIfMissing = true)
public class TunineServiceAutoConfiguration {

    @Resource
    //@Autowired
    private Student student;

    @Bean
    //@ConditionalOnMissingBean(TunineService.class)
    //@ConditionalOnProperty(prefix = "tunie.service", value = "enabled", havingValue = "true")
    public TunineService msgService() {
        TunineService msgService = new TunineService(student);
        // 如果提供了其他set方法，在此也可以调用对应方法对其进行相应的设置或初始化。
        return msgService;
    }

}
