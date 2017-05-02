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
  <p>
  <p>
  Generated on Aug 19, 2016 for  psi-config on package org.muhia.psi.config.security
 */
package org.muhia.app.psi.config.security;

import org.muhia.app.psi.config.security.properties.RandomHashProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Service
public class RandomPasswordGenerators {

    //	private static RandomHashProperties hashProperties;
    private final List<CustomTemplate> templates;

    private boolean doShuffle;

    private static List<Character> LOWER_CAPS, UPPER_CAPS, DIGITS, SPECIALS;

    @Autowired
    public RandomPasswordGenerators(RandomHashProperties hashProperties) {
//		RandomPasswordGenerators.hashProperties = hashProperties;
        templates = new ArrayList<>();

        UPPER_CAPS = new ArrayList<Character>(hashProperties.getAlphaCaps().length()) {
            /**
             *
             */
            private static final long serialVersionUID = 845366103355750873L;

            {

                for (int i = 0; i < hashProperties.getAlphaCaps().length(); i++) {
                    add(hashProperties.getAlphaCaps().charAt(i));
                }
            }
        };

        LOWER_CAPS = new ArrayList<Character>(hashProperties.getAlpha().length()) {
            /**
             *
             */
            private static final long serialVersionUID = 3954401447209043834L;

            {

                for (int i = 0; i < hashProperties.getAlpha().length(); i++) {
                    add(hashProperties.getAlpha().charAt(i));
                }
            }
        };

        DIGITS = new ArrayList<Character>(hashProperties.getDigits().length()) {
            /**
             *
             */
            private static final long serialVersionUID = 8372308958476016541L;

            {

                for (int i = 0; i < hashProperties.getDigits().length(); i++) {
                    add(hashProperties.getDigits().charAt(i));
                }
            }
        };

        SPECIALS = new ArrayList<Character>(hashProperties.getSpecialChars().length()) {
            /**
             *
             */
            private static final long serialVersionUID = 7984502419699830315L;

            {

                for (int i = 0; i < hashProperties.getSpecialChars().length(); i++) {
                    add(hashProperties.getSpecialChars().charAt(i));
                }
            }
        };
    }

    // static {
    //
    // UPPER_CAPS = new ArrayList<Character>() {
    // {
    //
    // for (int i = 0; i < hashProperties.getAlphaCaps().length(); i++) {
    // add(hashProperties.getAlphaCaps().charAt(i));
    // }
    // }
    // };
    //
    // LOWER_CAPS = new ArrayList<Character>() {
    // {
    //
    // for (int i = 0; i < hashProperties.getAlpha().length(); i++) {
    // add(hashProperties.getAlpha().charAt(i));
    // }
    // }
    // };
    //
    // DIGITS = new ArrayList<Character>() {
    // {
    //
    // for (int i = 0; i < hashProperties.getDigits().length(); i++) {
    // add(hashProperties.getDigits().charAt(i));
    // }
    // }
    // };
    //
    // SPECIALS = new ArrayList<Character>() {
    // {
    //
    // for (int i = 0; i < hashProperties.getSpecialChars().length(); i++) {
    // add(hashProperties.getSpecialChars().charAt(i));
    // }
    // }
    // };
    //
    // }
    RandomPasswordGenerators lowerCase(int count) {
        templates.add(new CustomTemplate(LOWER_CAPS, count));
        return this;
    }

    RandomPasswordGenerators upperCase(int count) {
        templates.add(new CustomTemplate(UPPER_CAPS, count));
        return this;
    }

    public RandomPasswordGenerators digits(int count) {
        templates.add(new CustomTemplate(DIGITS, count));
        return this;
    }

    RandomPasswordGenerators specials(int count) {
        templates.add(new CustomTemplate(SPECIALS, count));
        return this;
    }

    public RandomPasswordGenerators shuffle() {
        setDoShuffle(true);
        return this;
    }

    /**
     * @return the doShuffle
     */
    public boolean isDoShuffle() {
        return doShuffle;
    }

    /**
     * @param doShuffle the doShuffle to set
     */
    private void setDoShuffle(boolean doShuffle) {
        this.doShuffle = doShuffle;
    }

    public String generateRandomString() {

        StringBuilder passwordBuilder = new StringBuilder();
        List<Character> characters = new ArrayList<>();
        templates.forEach((template) -> {
            characters.addAll(template.addCharactersToList());
        });

        if (isDoShuffle()) {
            Collections.shuffle(characters);
        }

        characters.forEach(passwordBuilder::append);

        return passwordBuilder.toString();
    }

}
