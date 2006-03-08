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

package org.opensaml.saml1.core.impl;

import org.opensaml.common.SAMLObjectBaseTestCase;
import org.opensaml.common.xml.ParserPoolManager;
import org.opensaml.saml1.core.SubjectConfirmation;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * Test for {@link org.opensaml.saml1.core.impl.Subject}
 */
public class SubjectConfirmationTest extends SAMLObjectBaseTestCase {

    private String fullElementsFile;

    private Document expectedFullDOM;

    /**
     * Constructor
     */
    public SubjectConfirmationTest() {
        super();

        singleElementFile = "/data/org/opensaml/saml1/singleSubjectConfirmation.xml";
        singleElementOptionalAttributesFile = "/data/org/opensaml/saml1/singleSubjectConfirmation.xml";
        fullElementsFile = "/data/org/opensaml/saml1/SubjectConfirmationWithChildren.xml";
    }

    /*
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        ParserPoolManager ppMgr = ParserPoolManager.getInstance();

        expectedFullDOM = ppMgr.parse(new InputSource(SAMLObjectBaseTestCase.class
                .getResourceAsStream(fullElementsFile)));
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementUnmarshall()
     */
    public void testSingleElementUnmarshall() {
        SubjectConfirmation subjectConfirmation = (SubjectConfirmation) unmarshallElement(singleElementFile);

        assertEquals("Non zero number of child ConfirmationMethods elements", 0, subjectConfirmation
                .getConfirmationMethods().size());
        assertNull("Non zero number of child SubjectConfirmationData elements", subjectConfirmation
                .getSubjectConfirmationData());
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesUnmarshall()
     */
    public void testSingleElementOptionalAttributesUnmarshall() {
        // No attributes
    }

    /**
     * Test an XML file with children
     */
    public void testFullElementsUnmarshall() {
        SubjectConfirmation subjectConfirmation = (SubjectConfirmation) unmarshallElement(fullElementsFile);

        assertEquals("Number of ConfirmationMethods", 2, subjectConfirmation.getConfirmationMethods().size());
        assertNotNull("Zero child SubjectConfirmationData elements", subjectConfirmation.getSubjectConfirmationData());
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementMarshall()
     */
    public void testSingleElementMarshall() {
        SubjectConfirmation subjectConfirmation = new SubjectConfirmationImpl();

        assertEquals(expectedDOM, subjectConfirmation);
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesMarshall()
     */
    public void testSingleElementOptionalAttributesMarshall() {
        // No attributes
    }

    /*
     * Generate an subject with contents
     */

    public void testFullElementsMarshall() {
        SubjectConfirmation subjectConfirmation = new SubjectConfirmationImpl();

        subjectConfirmation.getConfirmationMethods().add(new ConfirmationMethodImpl());
        subjectConfirmation.getConfirmationMethods().add(new ConfirmationMethodImpl());
        subjectConfirmation.setSubjectConfirmationData(new SubjectConfirmationDataImpl());

        assertEquals(expectedFullDOM, subjectConfirmation);
    }
}
