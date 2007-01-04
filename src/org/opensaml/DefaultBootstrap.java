/*
 * Copyright [2006] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml;

import org.apache.log4j.Logger;
import org.apache.velocity.app.Velocity;
import org.apache.xml.security.Init;
import org.opensaml.common.binding.SAMLArtifactFactory;
import org.opensaml.common.xml.ParserPoolManager;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.XMLConfigurator;
import org.opensaml.xml.parse.XMLParserException;
import org.w3c.dom.Document;

/**
 * This class can be used to bootstrap the OpenSAML library with the default configurations that ship with the library.
 */
public class DefaultBootstrap {

    /** Class logger. */
    private static Logger log = Logger.getLogger(DefaultBootstrap.class);

    /** List of default XMLTooling configuration files. */
    private static String[] xmlToolingConfigs = { 
            "/common-config.xml",
            "/schema-config.xml",
            "/signature-config.xml",
            "/encryption-config.xml",
            "/saml1-assertion-config.xml",
            "/saml1-protocol-config.xml",
            "/saml1-core-validation-config.xml",
            "/saml2-assertion-config.xml",
            "/saml2-protocol-config.xml",
            "/saml2-protocol-thirdparty-config.xml",
            "/saml2-core-validation-config.xml",
            "/saml2-metadata-config.xml",
            "/saml1-metadata-config.xml",
            "/saml2-metadata-query-config.xml",
            "/saml2-metadata-validation-config.xml", 
        };

    /** Constrcutor. */
    protected DefaultBootstrap() {

    }

    /**
     * Initializes the OpenSAML library, loading default configurations.
     * 
     * @throws ConfigurationException thrown if there is a problem initializing the OpenSAML library
     */
    public static synchronized void bootstrap() throws ConfigurationException {

        initializeXMLSecurity();

        initializeVelocity();

        initializeXMLTooling(xmlToolingConfigs);

        initializeArtifactFactory();
    }

    /**
     * Initializes the Apache XMLSecurity libary.
     * 
     * @throws ConfigurationException thrown is there is a problem initializing the library
     */
    protected static void initializeXMLSecurity() throws ConfigurationException {
        if (!Init.isInitialized()) {
            if (log.isDebugEnabled()) {
                log.debug("Initializing Apache XMLSecurity library");
            }
            Init.init();
        }
    }

    /**
     * Intializes the Apache Velocity template engine.
     * 
     * @throws ConfigurationException thrown if there is a problem initializing Velocity
     */
    protected static void initializeVelocity() throws ConfigurationException {
        try {
            if (log.isDebugEnabled()) {
                log.debug("Initializing Velocity template engine");
            }
            Velocity.init();
        } catch (Exception e) {
            throw new ConfigurationException("Unable to initialize Velocity template engine");
        }
    }

    /**
     * Initializes the XMLTooling library with a default set of object providers.
     * 
     * @param providerConfigs list of provider configuration files located on the classpath
     * 
     * @throws ConfigurationException thrown if there is a problem loading the configuration files
     */
    protected static void initializeXMLTooling(String[] providerConfigs) throws ConfigurationException {
        ParserPoolManager parserPool = ParserPoolManager.getInstance();
        Class clazz = Configuration.class;
        Document configurationDoc;
        XMLConfigurator configurator = new XMLConfigurator();

        for (String config : providerConfigs) {
            try {
                if (log.isDebugEnabled()) {
                    log.debug("Loading XMLTooling configuration " + config);
                }
                configurationDoc = parserPool.parse(clazz.getResourceAsStream(config));
                configurator.load(configurationDoc);
            } catch (XMLParserException e) {
                throw new ConfigurationException("Unable to load object provider configuration " + config, e);
            }
        }
    }

    /**
     * Initializes the {@link SAMLArtifactFactory}.
     * 
     * @throws ConfigurationException thrown if there is a problem initializing the artifact factory
     */
    protected static void initializeArtifactFactory() throws ConfigurationException {
        if(log.isDebugEnabled()){
            log.debug("Initializing SAML Artifact factory");
        }
            
        Configuration.setArtifactFactory(new SAMLArtifactFactory());
    }
}