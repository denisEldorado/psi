package org.muhia.app.psi.config.external.properties;

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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.config
    Date: 02-Jan-17.
*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/external.properties"})
public class ExternalProperties {
    @Value("${org.muhia.psi.external.social.app.mode.demo}")
    private boolean appModeDemo;
    @Value("${org.muhia.psi.external.social.site.name}")
    private String siteName;
    @Value("${org.muhia.psi.external.social.application.base.url}")
    private String applicationBaseUrl;
    @Value("${org.muhia.psi.external.social.rss.channel.title}")
    private String rssChannelTitle;
    @Value("${org.muhia.psi.external.social.rss.channel.description}")
    private String rssChannelDescription;
    @Value("${org.muhia.psi.external.social.facebook.app.id}")
    private String facebookAppId;
    @Value("${org.muhia.psi.external.social.facebook.app.secret}")
    private String facebookAppSecret;
    @Value("${org.muhia.psi.external.social.twitter.app.id}")
    private String twitterAppId;
    @Value("${org.muhia.psi.external.social.twitter.app.secret}")
    private String twitterAppSecret;
    @Value("${org.muhia.psi.external.social.google.app.id}")
    private String googleAppId;
    @Value("${org.muhia.psi.external.social.google.app.secret}")
    private String googleAppSecret;
    @Value("${org.muhia.psi.external.social.google.map.key}")
    private String googleMapKey;
    @Value("${org.muhia.psi.external.social.google.analytics.trackingid}")
    private String googleAnalyticsTrackingid;
    @Value("${org.muhia.psi.external.social.google.analytics.enable}")
    private boolean googleAnalyticsEnable;
    @Value("${org.muhia.psi.external.social.linkedin.app.id}")
    private String linkedinAppId;
    @Value("${org.muhia.psi.external.social.linkedin.app.secret}")
    private String linkedinAppSecret;
    @Value("${org.muhia.psi.external.social.feedback.message.key}")
    private String feedbackMessageKey;
    @Value("${org.muhia.psi.external.social.path.profile.icon}")
    private String pathProfileIcon;
    @Value("${org.muhia.psi.external.social.path.profile.image}")
    private String pathProfileImage;
    @Value("${org.muhia.psi.external.social.image.upload.size}")
    private Long imageUploadSize;
    @Value("${org.muhia.psi.external.access.blacklisted.email.endswith}")
    private String[] blacklistedEmailEndswith;
    @Value("${org.muhia.psi.external.access.blacklisted.email.overrides}")
    private String[] blacklistedEmailOverrides;
    @Value("${org.muhia.psi.external.app.path.profile.image}")
    private String appProfileImagePath;
    

    public boolean isAppModeDemo() {
        return appModeDemo;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getApplicationBaseUrl() {
        return applicationBaseUrl;
    }

    public String getRssChannelTitle() {
        return rssChannelTitle;
    }

    public String getRssChannelDescription() {
        return rssChannelDescription;
    }

    public String getFacebookAppId() {
        return facebookAppId;
    }

    public String getFacebookAppSecret() {
        return facebookAppSecret;
    }

    public String getTwitterAppId() {
        return twitterAppId;
    }

    public String getTwitterAppSecret() {
        return twitterAppSecret;
    }

    public String getGoogleAppId() {
        return googleAppId;
    }

    public String getGoogleAppSecret() {
        return googleAppSecret;
    }

    public String getGoogleMapKey() {
        return googleMapKey;
    }

    public String getGoogleAnalyticsTrackingid() {
        return googleAnalyticsTrackingid;
    }

    public boolean isGoogleAnalyticsEnable() {
        return googleAnalyticsEnable;
    }

    public String getLinkedinAppId() {
        return linkedinAppId;
    }

    public String getLinkedinAppSecret() {
        return linkedinAppSecret;
    }

    public String getFeedbackMessageKey() {
        return feedbackMessageKey;
    }

    public void setFeedbackMessageKey(String feedbackMessageKey) {
        this.feedbackMessageKey = feedbackMessageKey;
    }


    public String getPathProfileIcon() {
        return pathProfileIcon;
    }

    public String getPathProfileImage() {
        return pathProfileImage;
    }




    public Long getImageUploadSize() {
        return imageUploadSize;
    }

    public String[] getBlacklistedEmailEndswith() {
        return blacklistedEmailEndswith;
    }

    public String[] getBlacklistedEmailOverrides() {
        return blacklistedEmailOverrides;
    }

    public String getAppProfileImagePath() {
        return appProfileImagePath;
    }

    public void setAppProfileImagePath(String appProfileImagePath) {
        this.appProfileImagePath = appProfileImagePath;
    }
    
    
}
