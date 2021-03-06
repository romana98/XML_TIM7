
package com.project.poverenik.model.util.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tpath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tpath"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bytes" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tpath", propOrder = {
    "bytes"
})
public class Tpath {

    @XmlElement(required = true)
    protected Object bytes;

    /**
     * Gets the value of the bytes property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBytes(Object value) {
        this.bytes = value;
    }

}
