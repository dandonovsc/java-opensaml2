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

import org.opensaml.common.impl.AbstractSAMLObjectMarshaller;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.metadata.ServiceDescription;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * A thread safe Marshaller for {@link org.opensaml.saml2.metadata.ServiceDescription} objects.
 */
public class ServiceDescriptionMarshaller extends AbstractSAMLObjectMarshaller {

    /**
     * Constructor
     */
    public ServiceDescriptionMarshaller() {
        super(SAMLConstants.SAML20MD_NS, ServiceDescription.DEFAULT_ELEMENT_LOCAL_NAME);
    }

    /**
     * Constructor
     * 
     * @param namespaceURI
     * @param elementLocalName
     */
    protected ServiceDescriptionMarshaller(String namespaceURI, String elementLocalName) {
        super(namespaceURI, elementLocalName);
    }

    /**
     * {@inheritDoc}
     */
    protected void marshallAttributes(XMLObject samlObject, Element domElement) throws MarshallingException {
        ServiceDescription description = (ServiceDescription) samlObject;

        if (description.getDescription() != null) {
            Attr attribute = XMLHelper.constructAttribute(domElement.getOwnerDocument(), SAMLConstants.XML_NS,
                    ServiceDescription.LANG_ATTRIB_NAME, SAMLConstants.XML_PREFIX);
            attribute.setValue(description.getDescription().getLanguage());
            domElement.setAttributeNodeNS(attribute);
        }
    }

    /** {@inheritDoc} */
    protected void marshallElementContent(XMLObject samlObject, Element domElement) throws MarshallingException {
        ServiceDescription description = (ServiceDescription) samlObject;

        if (description.getDescription() != null) {
            XMLHelper.appendTextContent(domElement, description.getDescription().getLocalString());
        }
    }
}