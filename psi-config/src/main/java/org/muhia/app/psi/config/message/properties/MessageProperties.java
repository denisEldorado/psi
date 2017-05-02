package org.muhia.app.psi.config.message.properties;

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
    Package: org.muhia.app.psi.config.external.properties
    Date: 03-Jan-17.
*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/message.properties"})
public class MessageProperties {
    @Value("${org.muhia.psi.validator.messages.error.file.empty}")
    private String fileEmpty;
    @Value("${org.muhia.psi.validator.messages.error.file.too.large}")
    private String fileTooLarge;
    @Value("${org.muhia.psi.validator.messages.error.file.not.image}")
    private String fileNotImage;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.contact.contact.phone}")
    private String contactContactPhone;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.contact.first.name}")
    private String contactFirstName;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.contact.last.name}")
    private String contactLastName;
    @Value("${org.muhia.psi.validator.messages.error.not.length.last.name}")
    private String lastName;
    @Value("${org.muhia.psi.validator.messages.error.not.length.emailaddress}")
    private String emailaddress;
    @Value("${org.muhia.psi.validator.messages.error.not.length.phonenumber}")
    private String phonenumber;
    @Value("${org.muhia.psi.validator.messages.error.not.length.address.street}")
    private String addressStreet;
    @Value("${org.muhia.psi.validator.messages.error.not.length.postcode}")
    private String postcode;
    @Value("${org.muhia.psi.validator.messages.error.not.length.address.postal}")
    private String addressPostal;
    @Value("${org.muhia.psi.validator.messages.error.not.length.state}")
    private String state;
    @Value("${org.muhia.psi.validator.messages.error.not.length.country}")
    private String country;
    @Value("${org.muhia.psi.validator.messages.error.past.contact.birthdate}")
    private String contactBirthdatePast;
    @Value("${org.muhia.psi.validator.messages.error.not.null.contact.birthdate}")
    private String contactBirthdate;
    @Value("${org.muhia.psi.validator.messages.error.contact.hobies}")
    private String contactHobies;
    @Value("${org.muhia.psi.validator.messages.error.global.password.demo.user}")
    private String passwordDemoUser;
    @Value("${org.muhia.psi.validator.messages.error.password.reset}")
    private String passwordReset;
    @Value("${org.muhia.psi.validator.messages.error.mail.not.exists}")
    private String mailNotExists;
    @Value("${org.muhia.psi.validator.messages.feedback.profile.image.updated}")
    private String profileImageUpdated;
    @Value("${org.muhia.psi.validator.messages.feedback.profile.image.removed}")
    private String profileImageRemoved;
    @Value("${org.muhia.psi.validator.messages.feedback.contact.deleted}")
    private String contactDeleted;
    @Value("${org.muhia.psi.validator.messages.feedback.contact.updated}")
    private String contactUpdated;
    @Value("${org.muhia.psi.validator.messages.feedback.contact.added}")
    private String contactAdded;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.userDTO.fullname}")
    private String userDTOFirstNameNotEmpty;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.userDTO.lastName}")
    private String userDTOLastNameNotEmpty;
    @Value("${org.muhia.psi.validator.messages.error.length.userDTO.password}")
    private String userDTOPassword;
    @Value("${org.muhia.psi.validator.messages.error.length.userDTO.username}")
    private String userDTOUsername;
    @Value("${org.muhia.psi.validator.messages.error.length.userDTO.fullname}")
    private String userDTOFirstName;
    @Value("${org.muhia.psi.validator.messages.error.length.userDTO.lastName}")
    private String userDTOLastName;
    @Value("${org.muhia.psi.validator.messages.feedback.user.password.reset}")
    private String userPasswordReset;
    @Value("${org.muhia.psi.validator.messages.feedback.user.password.login}")
    private String userPasswordLogin;
    @Value("${org.muhia.psi.validator.messages.feedback.password.email.sent}")
    private String passwordEmailSent;
    @Value("${org.muhia.psi.validator.messages.feedback.user.password.updated}")
    private String userPasswordUpdated;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.secinfo.anonymous}")
    private String secinfoAnonymous;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.forgotEmailDTO.email}")
    private String NotEmptyForgotEmailDTOEmail;

    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.roleDTO.authority}")
    private String NotEmptyRoleDTOAuthority;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.siteOptionMapDTO.siteName}")
    private String NotEmptySiteOptionMapDTOSiteName;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.siteOptionMapDTO.siteDescription}")
    private String NotEmptySiteOptionMapDTOSiteDescription;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.mailDTO.fromName}")
    private String NotEmptyMailDTOFromName;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.NotEmpty.mailDTO.body}")
    private String NotEmptyMailDTOBody;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postslist.page.subheader}")
    private String postslistPageSubheader;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postDTO.postTitle}")
    private String postDTOPostTitle;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postDTO.displayType}")
    private String postDTODisplayType;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postDTO.postContent}")
    private String postDTOPostContent;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postDTO.tags}")
    private String postDTOTags;
    @Value("${org.muhia.psi.validator.messages.error.not.empty.postQueryDTO.query}")
    private String postQueryDTOQuery;
    @Value("${org.muhia.psi.validator.messages.feedback.role.added}")
    private String roleAdded;
    @Value("${org.muhia.psi.validator.messages.feedback.role.updated}")
    private String roleUpdated;
    @Value("${org.muhia.psi.validator.messages.feedback.role.error}")
    private String roleError;
    @Value("${org.muhia.psi.validator.messages.feedback.role.islocked}")
    private String roleIslocked;
    @Value("${org.muhia.psi.validator.messages.feedback.sitesettings.updated}")
    private String sitesettingsUpdated;
    @Value("${org.muhia.psi.validator.messages.feedback.tag.added}")
    private String tagAdded;
    @Value("${org.muhia.psi.validator.messages.feedback.tag.error}")
    private String tagError;
    @Value("${org.muhia.psi.validator.messages.feedback.tag.updated}")
    private String tagUpdated;
    @Value("${org.muhia.psi.validator.messages.feedback.tag.deleted}")
    private String tagDeleted;
    @Value("${org.muhia.psi.validator.messages.error.no.match.password}")
    private String noMatchPassword;
    @Value("${org.muhia.psi.validator.messages.error.mail.exists}")
    private String mailExists;
    @Value("${org.muhia.psi.validator.messages.error.login.exists}")
    private String userExists;
    @Value("${org.muhia.psi.validator.messages.error.domain.not.approved}")
    private String domainNotApproved;

    public String getFileEmpty() {
        return fileEmpty;
    }

    public String getFileTooLarge() {
        return fileTooLarge;
    }

    public String getFileNotImage() {
        return fileNotImage;
    }

    public String getContactContactPhone() {
        return contactContactPhone;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAddressPostal() {
        return addressPostal;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getContactBirthdatePast() {
        return contactBirthdatePast;
    }

    public String getContactBirthdate() {
        return contactBirthdate;
    }

    public String getContactHobies() {
        return contactHobies;
    }

    public String getPasswordDemoUser() {
        return passwordDemoUser;
    }

    public String getPasswordReset() {
        return passwordReset;
    }

    public String getMailNotExists() {
        return mailNotExists;
    }

    public String getProfileImageUpdated() {
        return profileImageUpdated;
    }

    public String getProfileImageRemoved() {
        return profileImageRemoved;
    }

    public String getContactDeleted() {
        return contactDeleted;
    }

    public String getContactUpdated() {
        return contactUpdated;
    }

    public String getContactAdded() {
        return contactAdded;
    }

    public String getUserDTOFirstNameNotEmpty() {
        return userDTOFirstNameNotEmpty;
    }

    public String getUserDTOLastNameNotEmpty() {
        return userDTOLastNameNotEmpty;
    }

    public String getUserDTOPassword() {
        return userDTOPassword;
    }

    public String getUserDTOUsername() {
        return userDTOUsername;
    }

    public String getUserDTOFirstName() {
        return userDTOFirstName;
    }

    public String getUserDTOLastName() {
        return userDTOLastName;
    }

    public String getUserPasswordReset() {
        return userPasswordReset;
    }

    public String getUserPasswordLogin() {
        return userPasswordLogin;
    }

    public String getPasswordEmailSent() {
        return passwordEmailSent;
    }

    public String getUserPasswordUpdated() {
        return userPasswordUpdated;
    }

    public String getSecinfoAnonymous() {
        return secinfoAnonymous;
    }

    public String getNotEmptyForgotEmailDTOEmail() {
        return NotEmptyForgotEmailDTOEmail;
    }

    public String getNotEmptyRoleDTOAuthority() {
        return NotEmptyRoleDTOAuthority;
    }

    public String getNotEmptySiteOptionMapDTOSiteName() {
        return NotEmptySiteOptionMapDTOSiteName;
    }

    public String getNotEmptySiteOptionMapDTOSiteDescription() {
        return NotEmptySiteOptionMapDTOSiteDescription;
    }

    public String getNotEmptyMailDTOFromName() {
        return NotEmptyMailDTOFromName;
    }

    public String getNotEmptyMailDTOBody() {
        return NotEmptyMailDTOBody;
    }

    public String getPostslistPageSubheader() {
        return postslistPageSubheader;
    }

    public String getPostDTOPostTitle() {
        return postDTOPostTitle;
    }

    public String getPostDTODisplayType() {
        return postDTODisplayType;
    }

    public String getPostDTOPostContent() {
        return postDTOPostContent;
    }

    public String getPostDTOTags() {
        return postDTOTags;
    }

    public String getPostQueryDTOQuery() {
        return postQueryDTOQuery;
    }

    public String getRoleAdded() {
        return roleAdded;
    }

    public String getRoleUpdated() {
        return roleUpdated;
    }

    public String getRoleError() {
        return roleError;
    }

    public String getRoleIslocked() {
        return roleIslocked;
    }

    public String getSitesettingsUpdated() {
        return sitesettingsUpdated;
    }

    public String getTagAdded() {
        return tagAdded;
    }

    public String getTagError() {
        return tagError;
    }

    public String getTagUpdated() {
        return tagUpdated;
    }

    public String getTagDeleted() {
        return tagDeleted;
    }

    public String getNoMatchPassword() {
        return noMatchPassword;
    }

    public void setNoMatchPassword(String noMatchPassword) {
        this.noMatchPassword = noMatchPassword;
    }

    public String getMailExists() {
        return mailExists;
    }

    public void setMailExists(String mailExists) {
        this.mailExists = mailExists;
    }

    public String getDomainNotApproved() {
        return domainNotApproved;
    }

    public String getUserExists() {
        return userExists;
    }
}
