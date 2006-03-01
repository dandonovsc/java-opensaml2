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

import javax.xml.namespace.QName;

import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.LogoutResponse;

/**
 *
 */
public class LogoutResponseTest extends StatusResponseTest {

    /**
     * Constructor
     *
     */
    public LogoutResponseTest() {
        super();
        singleElementFile = "/data/org/opensaml/saml2/core/impl/LogoutResponse.xml";
        singleElementOptionalAttributesFile = "/data/org/opensaml/saml2/core/impl/LogoutResponseOptionalAttributes.xml";
        childElementsFile = "/data/org/opensaml/saml2/core/impl/LogoutResponseChildElements.xml";
    }
    
    /**
     * @see org.opensaml.saml2.core.impl.StatusResponseTest#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * @see org.opensaml.saml2.core.impl.StatusResponseTest#testSingleElementMarshall()
     */
    public void testSingleElementMarshall() {
        QName qname = new QName(SAMLConstants.SAML20P_NS, LogoutResponse.LOCAL_NAME);
        LogoutResponse resp = (LogoutResponse) buildXMLObject(qname);
        
        super.populateRequiredAttributes(resp);
        
        assertEquals(expectedDOM, resp);
    }

    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesMarshall()
     */
    public void testSingleElementOptionalAttributesMarshall() {
        QName qname = new QName(SAMLConstants.SAML20P_NS, LogoutResponse.LOCAL_NAME);
        LogoutResponse resp = (LogoutResponse) buildXMLObject(qname);
        
        super.populateRequiredAttributes(resp);
        super.populateOptionalAttributes(resp);
        
        assertEquals(expectedOptionalAttributesDOM, resp);
    }
    
    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testChildElementsMarshall()
     */
    public void testChildElementsMarshall() {
        QName qname = new QName(SAMLConstants.SAML20P_NS, LogoutResponse.LOCAL_NAME);
        LogoutResponse resp = (LogoutResponse) buildXMLObject(qname);
        
        super.populateChildElements(resp);
        
        assertEquals(expectedChildElementsDOM, resp);
    }

    /**
     * @see org.opensaml.saml2.core.impl.StatusResponseTest#testSingleElementUnmarshall()
     */
    public void testSingleElementUnmarshall() {
        LogoutResponse resp = (LogoutResponse) unmarshallElement(singleElementFile);
        
        super.helperTestSingleElementUnmarshall(resp);
    }
 
    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesUnmarshall()
     */
    public void testSingleElementOptionalAttributesUnmarshall() {
        LogoutResponse resp = (LogoutResponse) unmarshallElement(singleElementOptionalAttributesFile);

        super.helperTestSingleElementOptionalAttributesUnmarshall(resp);
    }
 
    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testChildElementsUnmarshall()
     */
    public void testChildElementsUnmarshall() {
        LogoutResponse resp = (LogoutResponse) unmarshallElement(childElementsFile);
        
        super.helperTestChildElementsUnmarshall(resp);
    }
    
}