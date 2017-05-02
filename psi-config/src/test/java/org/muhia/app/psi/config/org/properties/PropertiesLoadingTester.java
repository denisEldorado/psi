package org.muhia.app.psi.config.org.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesLoadingTester {

    @Autowired
    private OrganizationProperties op;

    @Test
    public void propertiesLoadingTest() {
//        op = new OrganizationProperties().loadOrganizationProperties();

        Logger.getLogger(PropertiesLoadingTester.class.getName()).log(Level.INFO, "The property loaded is {0}", op.getOrganizationName());
//		return op.getOrganizationName();
    }
}
