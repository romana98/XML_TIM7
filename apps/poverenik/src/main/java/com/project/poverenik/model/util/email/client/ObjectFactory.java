
package com.project.poverenik.model.util.email.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.project.organ_vlasti.model.zahtev package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.project.organ_vlasti.model.zahtev
     *
     */
    public ObjectFactory() {
    }
    /**
     * Create an instance of {@link sendPlain }
     *
     */
    public sendPlain createSendPlain() {
        return new sendPlain();
    }

    /**
     * Create an instance of {@link sendPlainResponse }
     *
     */
    public sendPlainResponse createSendPlainResponse() {
        return new sendPlainResponse();
    }

    /**
     * Create an instance of {@link sendAttach }
     *
     */
    public sendAttach createSendAttach() {
        return new sendAttach();
    }

    /**
     * Create an instance of {@link sendAttachResponse }
     *
     */
    public sendAttachResponse createSendAttachResponse() {
        return new sendAttachResponse();
    }
}