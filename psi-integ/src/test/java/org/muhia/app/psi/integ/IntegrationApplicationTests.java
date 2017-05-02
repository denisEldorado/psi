package org.muhia.app.psi.integ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationApplicationTests {
	@Autowired
	private ObopayKeProperties keProperties;

	@Test
	public void contextLoads() {

	}

	@Test
	public void propertyLoadingTest(){
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Checking for "+keProperties.getContextPath());
	}

}
