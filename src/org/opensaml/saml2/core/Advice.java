/*
 * Copyright [2005] [University Corporation for Advanced Internet Development, Inc.]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.saml2.core;

import java.util.List;

import org.opensaml.common.SAMLObject;

/**
 * SAML 2.0 Core Advice
 */
public interface Advice extends SAMLObject {
    
    /** Element local name */
    public final static String LOCAL_NAME = "Advice";

    /**
     * Gets the list of AssertionID references used as advice.
     * 
     * @return the list of AssertionID references used as advice
     */
    public List<AssertionIDRef> getAssertionIDReferences();

    /**
     * Gets the list of AssertionURI references used as advice;
     * 
     * @return the list of AssertionURI references used as advice
     */
    public List<AssertionURIRef> getAssertionURIReferences();

    /**
     * Gets the list of Assertions used as advice.
     * 
     * @return the list of Assertions used as advice
     */
    public List<Assertion> getAssertions();

    // TODO encrypted assertions
}