package org.muhia.app.psi.infra.validators;

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

import org.muhia.app.psi.config.external.properties.ExternalProperties;
import org.muhia.app.psi.config.message.properties.MessageProperties;
import org.muhia.app.psi.infra.dto.ProfileImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.infra.validators
    Date: 03-Jan-17.
*/
@Component
public class ProfileImageValidator implements Validator {
    @Autowired
    private ExternalProperties properties;
    @Autowired
    private MessageProperties messageProperties;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ProfileImageDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProfileImageDTO profileImage = (ProfileImageDTO) target;
        validateFileType(errors, profileImage);
        validateForMinMaxFileSize(errors, profileImage);

    }

    private void validateForMinMaxFileSize(Errors errors, ProfileImageDTO profileImage) {
        if (profileImage.getFile().getSize() == 0) {
            errors.reject(messageProperties.getFileEmpty());
        }
        if (profileImage.getFile().getSize() > properties.getImageUploadSize()) {
            errors.reject(messageProperties.getFileEmpty());
        }
    }

    private void validateFileType(Errors errors, ProfileImageDTO profileImage) {
        try (InputStream input = profileImage.getFile().getInputStream()) {
            try {
                ImageIO.read(input);
            } catch (Exception e) {
                errors.reject(messageProperties.getFileNotImage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
