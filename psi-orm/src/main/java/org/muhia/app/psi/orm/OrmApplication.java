package org.muhia.app.psi.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//@EntityScan(basePackages = {"org.muhia.app.psi.orm.model"})
//@ComponentScan(basePackages = {"org.muhia.app.psi.orm"})
//@SpringBootApplication(scanBasePackages = {"org.muhia.app.psi.config", "org.muhia.app.psi.orm", "org.muhia.app.psi"})
@SpringBootApplication(scanBasePackages = {"org.muhia.app.psi"})
@EnableCaching
public class OrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }


}
