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

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLObjectBaseTestCase;
import org.opensaml.common.SAMLVersion;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.Status;
import org.opensaml.saml2.core.StatusResponse;

/**
 *
 */
public abstract class StatusResponseTest extends SAMLObjectBaseTestCase {
    
    /** Expected ID attribute */
    protected String expectedID;
    
    /** Expected InResponseTo attribute */
    protected String expectedInResponseTo;
    
    /** Expected Version attribute */
    protected SAMLVersion expectedSAMLVersion;
    
    /** Expected IssueInstant attribute */
    protected DateTime expectedIssueInstant;
    
    /** Expected Destination attribute */
    protected String expectedDestination;
    
    /** Expected Consent attribute */
    protected String expectedConsent;
    
    /** Expected Issuer child element */
    protected Issuer expectedIssuer;
    
    /** Expected Status child element */
    protected Status expectedStatus;
    
    
    //TODO Signature tests ?
    //TODO Extensions tests - need implementation

    /**
     * Constructor
     *
     */
    public StatusResponseTest() {
        
    }

    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        expectedID = "def456";
        expectedInResponseTo = "abc123";
        expectedSAMLVersion = SAMLVersion.VERSION_20;
        expectedIssueInstant = new DateTime(2006, 2, 21, 16, 40, 0, 0, ISOChronology.getInstanceUTC());
        expectedDestination = "http://sp.example.org/endpoint";
        expectedConsent = "urn:string:consent";
        
        expectedIssuer = new IssuerImpl();
        expectedStatus = new StatusImpl();
    }

    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementUnmarshall()
     */
    public abstract void testSingleElementUnmarshall();

    /**
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementMarshall()
     */
    public abstract void testSingleElementMarshall();
    
    
    /**
     * Used by subclasses to populate the required attribute values
     * that this test expects.
     * 
     * @param samlObject
     */
    protected void populateRequiredAttributes(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        sr.setID(expectedID);
        sr.setIssueInstant(expectedIssueInstant);
        // NOTE:  the SAML Version attribute is set automatically by the impl superclas
        
    }
    
    /**
     * Used by subclasses to populate the optional attribute values
     * that this test expects. 
     * 
     * @param samlObject
     */
    protected void populateOptionalAttributes(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        sr.setInResponseTo(expectedInResponseTo);
        sr.setConsent(expectedConsent);
        sr.setDestination(expectedDestination);
        
    }
    
    /**
     * Used by subclasses to populate the child elements that this test expects.
     * 
     * 
     * @param samlObject
     */
    protected void populateChildElements(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        sr.setIssuer(expectedIssuer);
        sr.setStatus(expectedStatus);
        
    }
    
    protected void helperTestSingleElementUnmarshall(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        assertEquals("Unmarshalled ID attribute was not the expected value", expectedID, sr.getID());
        //TODO Should SAMLVersion  implement equals() ?
        assertEquals("Unmarshalled Version attribute was not the expected value", expectedSAMLVersion.toString(), sr.getVersion().toString());
        assertEquals("Unmarshalled IssueInstant attribute was not the expected value", 0, expectedIssueInstant.compareTo(sr.getIssueInstant()));
        
        assertNull("InResponseTo was not null", sr.getInResponseTo());
        assertNull("Consent was not null", sr.getConsent());
        assertNull("Destination was not null", sr.getDestination());
        
    }
    
    protected void helperTestSingleElementOptionalAttributesUnmarshall(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        assertEquals("Unmarshalled ID attribute was not the expected value", expectedID, sr.getID());
        //TODO Should SAMLVersion  implement equals() ?
        assertEquals("Unmarshalled Version attribute was not the expected value", expectedSAMLVersion.toString(), sr.getVersion().toString());
        assertEquals("Unmarshalled IssueInstant attribute was not the expected value", 0, expectedIssueInstant.compareTo(sr.getIssueInstant()));
        
        assertEquals("Unmarshalled InResponseTo attribute was not the expected value", expectedInResponseTo, sr.getInResponseTo());
        assertEquals("Unmarshalled Consent attribute was not the expected value", expectedConsent, sr.getConsent());
        assertEquals("Unmarshalled Destination attribute was not the expected value", expectedDestination, sr.getDestination());
        
    }

    protected void helperTestChildElementsUnmarshall(SAMLObject samlObject) {
        StatusResponse sr = (StatusResponse) samlObject;
        
        assertNotNull("Issuer was null", sr.getIssuer());
        assertNotNull("Status was null", sr.getIssuer());
    }

}