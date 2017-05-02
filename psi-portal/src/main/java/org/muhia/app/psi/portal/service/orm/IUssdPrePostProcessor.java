package org.muhia.app.psi.portal.service.orm;/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

import java.util.Map;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm
 * Generated on: 22-Apr-17, 10:23
 */
public interface IUssdPrePostProcessor {

    //    String loanRate(String query, Long productId);
    String loanRate(Map<String, String> params);
}