/**
 *
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.muhia.app.psi.config.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.menu.properties.MenuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuPropertiesTest {

    @Autowired
    private MenuProperties properties;

    @Test
    public void testFilePath() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "FilePath is:{0}", properties.getMenuFilePath());
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "FilePath is:{0}", properties1.getJdbcUrl());

    }
}
