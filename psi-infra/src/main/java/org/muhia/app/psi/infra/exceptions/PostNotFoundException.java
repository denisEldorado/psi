package org.muhia.app.psi.infra.exceptions;

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

/*
    Created by KennethKZMMuhia
    Project: psi
    Package: ${PACKAGE_NAME}
    Date: 6/15/16.
*/
public class PostNotFoundException extends Exception {

    private static final long serialVersionUID = 3613978896775863909L;

    private String msg;

    public PostNotFoundException() {
        super();
    }

    public PostNotFoundException(String msg) {
        this.msg = System.currentTimeMillis() + ": " + msg;
    }

    public String getMsg() {
        return msg;
    }


}
