package org.muhia.app.psi.portal.components;

/*
  Copyright 2015-2017 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  
*/

import net.coobird.thumbnailator.Thumbnails;
import org.muhia.app.psi.portal.service.orm.ISiteStatisticsService;
import org.muhia.app.psi.config.external.properties.ExternalProperties;
import org.muhia.app.psi.infra.dto.ProfileImageDTO;
import org.muhia.app.psi.orm.model.SiteStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Locale;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal
    Date: 02-Jan-17.
*/
@Component
public class WebUI {
    @Resource
    private MessageSource messageSource;

    @Autowired
    private Environment env;
    @Autowired
    private ExternalProperties properties;
    @Autowired
    private ISiteStatisticsService statService;

    @Autowired
    public WebUI(Environment env, ISiteStatisticsService statService) {
        this.env = env;
        this.statService = statService;
    }

    public String getMessage(String code, Object... params) {
        Locale current = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, params, current);
    }

    public void addFeedbackMessage(RedirectAttributes model, String code, Object... params) {
        String localizedFeedbackMessage = getMessage(code, params);
        model.addFlashAttribute(properties.getFeedbackMessageKey(), localizedFeedbackMessage);
    }

    public String parameterizedMessage(String code, Object... params) {
        String localizedMessage = getMessage(code, params);
        return localizedMessage;
    }

    public void processProfileImage(ProfileImageDTO profileImageDTO, String userKey) throws IOException {

        // Reduce original image size. Thumbnailator will not modify
        // image if less than 600x600

        BufferedImage bufferedProfileImage =
                Thumbnails.of(profileImageDTO.getFile().getInputStream())
                        .forceSize(600, 600)
                        .allowOverwrite(true)
                        .outputFormat("png")
                        .asBufferedImage();

        saveProfileImage(bufferedProfileImage, userKey, false);

        // Create profile image icon. Saved to separate directory

        BufferedImage bufferedIconImage =
                Thumbnails.of(profileImageDTO.getFile().getInputStream())
                        .forceSize(32, 32)
                        .allowOverwrite(true)
                        .outputFormat("png")
                        .asBufferedImage();

        saveProfileImage(bufferedIconImage, userKey, true);
    }


    public void processProfileImage(String providerImageUrl, String userKey) throws IOException {

        // Reduce original image size. Thumbnailator will not modify
        // image if less than 600x600

        BufferedImage bufferedProfileImage =
                Thumbnails.of(new URL(providerImageUrl))
                        .forceSize(600, 600)
                        .allowOverwrite(true)
                        .outputFormat("png")
                        .asBufferedImage();

        saveProfileImage(bufferedProfileImage, userKey, false);

        // Create profile image icon. Saved to separate directory

        BufferedImage bufferedIconImage =
                Thumbnails.of(new URL(providerImageUrl))
                        .forceSize(32, 32)
                        .allowOverwrite(true)
                        .outputFormat("png")
                        .asBufferedImage();

        saveProfileImage(bufferedIconImage, userKey, true);
    }

    private void saveProfileImage(BufferedImage bufferedImage, String userKey, boolean isIcon) throws IOException {

        String destination = isIcon ? properties.getPathProfileIcon() : properties.getPathProfileImage();
        File imageDestination = new File(destination + userKey);
        ImageIO.write(bufferedImage, "png", imageDestination);

    }

    public Collection<SiteStatistics> getCurrentSiteStats() {
        final Collection<SiteStatistics> results;
        statService.findSiteStatisticsByIpAddressAndStatus("", 0).ifPresent(statistics -> {
        });
        return null;
    }


}
