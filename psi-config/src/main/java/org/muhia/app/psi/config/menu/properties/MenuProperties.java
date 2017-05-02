/*

  Copyright 2015-2017 the original author or authors.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.muhia.app.psi.config.menu.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/ui-menu.properties")
public class MenuProperties {

    @Value("${org.muhia.psi.ui.menu.location.error.attribute}")
    private String locationErrorAttribute;
    @Value("${org.muhia.psi.ui.menu.session.user.connection}")
    private String sessionUserConnection;
    @Value("${org.muhia.psi.ui.menu.error.page.title.attribute}")
    private String errorPageTitleAttribute;
    @Value("${org.muhia.psi.ui.menu.file.path}")
    private String menuFilePath;
    @Value("${org.muhia.psi.ui.menu.error.page.message.attribute}")
    private String errorPageMessageAttribute;
    @Value("${org.muhia.psi.ui.menu.home.view}")
    private String homeView;
    @Value("${org.muhia.psi.ui.menu.redirect.home.view}")
    private String redirectHomeVIew;
    @Value("${org.muhia.psi.ui.menu.error.403.view}")
    private String error403View;
    @Value("${org.muhia.psi.ui.menu.error.custom.view}")
    private String errorCustomView;
    @Value("${org.muhia.psi.ui.menu.product.map.view}")
    private String productMapView;
    @Value("${org.muhia.psi.ui.menu.location.error.message.key}")
    private String locationErrorMessageKey;

    /**
     * @return the menuFilePath
     */
    public String getMenuFilePath() {
        return menuFilePath;
    }


}
