package org.muhia.app.psi.orm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.jpa.properties.JpaConnectionProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {HibernateJpaConfiguration.class})
@SpringBootTest(classes = {JpaConnectionProperties.class, HashingImplementation.class, OrganizationProperties.class})
public class OrmApplicationTests {

    @Test
    public void contextLoads() {
    }

}
