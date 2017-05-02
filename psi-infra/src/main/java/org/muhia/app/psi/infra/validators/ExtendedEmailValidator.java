package org.muhia.app.psi.infra.validators;/*
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

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.infra.validators
  Generated on 31-Dec-16.
 */
@Pattern(regexp = ".+@.+\\..+", message = "{ExtendedEmailValidator.email}")
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ExtendedEmailValidator {
    String message() default "{ExtendedEmailValidator.email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
