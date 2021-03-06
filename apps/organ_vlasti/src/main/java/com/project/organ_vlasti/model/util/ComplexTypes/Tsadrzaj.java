
package com.project.organ_vlasti.model.util.ComplexTypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Tsadrzaj complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tsadrzaj"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="osnova_za_zalbu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="clan" type="{http://www.reusability}Tclan" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tsadrzaj", propOrder = {
        "content"
})
public class Tsadrzaj {

    @XmlElementRefs({
            @XmlElementRef(name = "datum", namespace = "http://www.reusability", type = JAXBElement.class),
            @XmlElementRef(name = "clan", namespace = "http://www.reusability", type = JAXBElement.class),
            @XmlElementRef(name = "osnova_za_zalbu", namespace = "http://www.reusability", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;

    /**
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link Tclan }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

}
