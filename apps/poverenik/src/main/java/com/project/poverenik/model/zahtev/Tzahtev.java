
package com.project.poverenik.model.zahtev;

import com.project.poverenik.model.util.ComplexTypes.TciljaniOrganVlasti;
import com.project.poverenik.model.util.ComplexTypes.Tfusnote;
import com.project.poverenik.model.util.ComplexTypes.TinformacijeOTraziocu;
import com.project.poverenik.model.util.ComplexTypes.TtekstZahtevaZahtevcir;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Java class for Tzahtev complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tzahtev"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="mesto"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ciljani_organ_vlasti" type="{http://www.reusability}Tciljani_organ_vlasti"/&gt;
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tekst_zahteva" type="{http://www.reusability}Ttekst_zahteva_zahtevcir"/&gt;
 *         &lt;element name="informacije_o_traziocu" type="{http://www.reusability}Tinformacije_o_traziocu"/&gt;
 *         &lt;element name="fusnote" type="{http://www.reusability}Tfusnote" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tzahtev", propOrder = {
        "status",
        "mesto",
        "ciljaniOrganVlasti",
        "naziv",
        "tekstZahteva",
        "informacijeOTraziocu",
        "fusnote"
})
public class Tzahtev {

    protected Tzahtev.Status status;
    @XmlElement(required = true)
    protected Tzahtev.Mesto mesto;
    @XmlElement(name = "ciljani_organ_vlasti", required = true)
    protected TciljaniOrganVlasti ciljaniOrganVlasti;
    protected String naziv;
    @XmlElement(name = "tekst_zahteva", required = true)
    protected TtekstZahtevaZahtevcir tekstZahteva;
    @XmlElement(name = "informacije_o_traziocu", required = true)
    protected TinformacijeOTraziocu informacijeOTraziocu;
    protected Tfusnote fusnote;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link Tzahtev.Status }
     */
    public Tzahtev.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link Tzahtev.Status }
     */
    public void setStatus(Tzahtev.Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the mesto property.
     *
     * @return possible object is
     * {@link Tzahtev.Mesto }
     */
    public Tzahtev.Mesto getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     *
     * @param value allowed object is
     *              {@link Tzahtev.Mesto }
     */
    public void setMesto(Tzahtev.Mesto value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the ciljaniOrganVlasti property.
     *
     * @return possible object is
     * {@link TciljaniOrganVlasti }
     */
    public TciljaniOrganVlasti getCiljaniOrganVlasti() {
        return ciljaniOrganVlasti;
    }

    /**
     * Sets the value of the ciljaniOrganVlasti property.
     *
     * @param value allowed object is
     *              {@link TciljaniOrganVlasti }
     */
    public void setCiljaniOrganVlasti(TciljaniOrganVlasti value) {
        this.ciljaniOrganVlasti = value;
    }

    /**
     * Gets the value of the naziv property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the tekstZahteva property.
     *
     * @return possible object is
     * {@link TtekstZahtevaZahtevcir }
     */
    public TtekstZahtevaZahtevcir getTekstZahteva() {
        return tekstZahteva;
    }

    /**
     * Sets the value of the tekstZahteva property.
     *
     * @param value allowed object is
     *              {@link TtekstZahtevaZahtevcir }
     */
    public void setTekstZahteva(TtekstZahtevaZahtevcir value) {
        this.tekstZahteva = value;
    }

    /**
     * Gets the value of the informacijeOTraziocu property.
     *
     * @return possible object is
     * {@link TinformacijeOTraziocu }
     */
    public TinformacijeOTraziocu getInformacijeOTraziocu() {
        return informacijeOTraziocu;
    }

    /**
     * Sets the value of the informacijeOTraziocu property.
     *
     * @param value allowed object is
     *              {@link TinformacijeOTraziocu }
     */
    public void setInformacijeOTraziocu(TinformacijeOTraziocu value) {
        this.informacijeOTraziocu = value;
    }

    /**
     * Gets the value of the fusnote property.
     *
     * @return possible object is
     * {@link Tfusnote }
     */
    public Tfusnote getFusnote() {
        return fusnote;
    }

    /**
     * Sets the value of the fusnote property.
     *
     * @param value allowed object is
     *              {@link Tfusnote }
     */
    public void setFusnote(Tfusnote value) {
        this.fusnote = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * <p>
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     *
     * @return always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;anyAttribute processContents='lax'/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Mesto {

        @XmlValue
        protected String value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         *
         * <p>
         * the map is keyed by the name of the attribute and
         * the value is the string value of the attribute.
         * <p>
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         *
         * @return always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;anyAttribute processContents='lax'/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Status {

        @XmlValue
        protected String value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         *
         * <p>
         * the map is keyed by the name of the attribute and
         * the value is the string value of the attribute.
         * <p>
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         *
         * @return always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }
}