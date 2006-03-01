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

/**
 * 
 */
package org.opensaml.saml2.core.impl;

import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.LogoutResponse;

/**
 * A thread-safe Unmarshaller for {@link org.opensaml.saml2.core.LogoutResponse} objects.
 */
public class LogoutResponseUnmarshaller extends StatusResponseUnmarshaller {

    /**
     * Constructor
     *
     */
    public LogoutResponseUnmarshaller() {
        super(SAMLConstants.SAML20P_NS, LogoutResponse.LOCAL_NAME);
    }
    
    // no attributes or elements of our own to unmarshall

}