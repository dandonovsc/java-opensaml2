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
package org.opensaml.saml2.metadata.impl;

import org.apache.log4j.Logger;
import org.joda.time.format.ISODateTimeFormat;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.impl.AbstractSAMLObjectMarshaller;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.common.CacheableSAMLObject;
import org.opensaml.saml2.common.TimeBoundSAMLObject;
import org.opensaml.saml2.metadata.AffiliationDescriptor;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.DatatypeHelper;
import org.w3c.dom.Element;

/**
 * A thread safe {@link org.opensaml.common.io.Marshaller} for {@link org.opensaml.saml2.metadata.AffiliationDescriptor} objects.
 */
public class AffiliationDescriptorMarshaller extends AbstractSAMLObjectMarshaller {
    /**
     * Logger
     */
    private static Logger log = Logger.getLogger(AffiliationDescriptorMarshaller.class);

    /**
     * Constructor
     */
    public AffiliationDescriptorMarshaller(){
        super(SAMLConstants.SAML20MD_NS, AffiliationDescriptor.LOCAL_NAME);
    }
    
    /*
     * @see org.opensaml.common.io.impl.AbstractMarshaller#marshallAttributes(org.opensaml.common.SAMLObject, org.w3c.dom.Element)
     */
    protected void marshallAttributes(SAMLObject samlElement, Element domElement) throws MarshallingException {
        AffiliationDescriptor descriptor = (AffiliationDescriptor)samlElement;
        
        // Set affiliationOwnerID
        domElement.setAttributeNS(null, AffiliationDescriptor.OWNER_ID_ATTRIB_NAME, descriptor.getOwnerID());
        
        // Set the validUntil attribute
        if(descriptor.getValidUntil() != null){
            if(log.isDebugEnabled()){
                log.debug("Writting validUntil attribute to AffiliationDescriptor DOM element");
            }
            String validUntilStr = ISODateTimeFormat.dateTime().print(descriptor.getValidUntil());
            domElement.setAttributeNS(null, TimeBoundSAMLObject.VALID_UNTIL_ATTRIB_NAME, validUntilStr);
        }
        
        // Set the cacheDuration attribute
        if(descriptor.getCacheDuration() != null){
            if(log.isDebugEnabled()){
                log.debug("Writting cacheDuration attribute to AffiliationDescriptor DOM element");
            }
            String cacheDuration = DatatypeHelper.longToDuration(descriptor.getCacheDuration());
            domElement.setAttributeNS(null, CacheableSAMLObject.CACHE_DURATION_ATTRIB_NAME, cacheDuration);
        }
    }
}