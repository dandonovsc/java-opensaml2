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

package org.opensaml.saml2.metadata.validator;

import org.opensaml.saml2.metadata.ArtifactResolutionService;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.DatatypeHelper;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;

/**
 * Checks {@link org.opensaml.saml2.metadata.ArtifactResolutionService} for Spec compliance.
 */
public class ArtifactResolutionServiceSpecValidator extends IndexedEndpointSchemaValidator implements Validator {

    /** Constructor */
    public ArtifactResolutionServiceSpecValidator() {

    }

    /*
     * @see org.opensaml.xml.validation.Validator#validate(org.opensaml.xml.XMLObject)
     */
    public void validate(XMLObject xmlObject) throws ValidationException {
        super.validate(xmlObject);
        ArtifactResolutionService artifactResolutionService = (ArtifactResolutionService) xmlObject;
        validateResponseLocation(artifactResolutionService);
    }

    /**
     * Checks that Response Location is omitted.
     * 
     * @param artifactResolutionService
     * @throws ValidationException
     */
    protected void validateResponseLocation(ArtifactResolutionService artifactResolutionService)
            throws ValidationException {
        if (!DatatypeHelper.isEmpty(artifactResolutionService.getResponseLocation())) {
            throw new ValidationException("Response Location must be omitted.");
        }
    }
}