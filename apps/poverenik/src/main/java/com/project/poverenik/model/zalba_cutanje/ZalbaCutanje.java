
package com.project.poverenik.model.zalba_cutanje;

import com.project.poverenik.model.util.TpodaciOPodnosiocu;
import com.project.poverenik.model.util.TpodaciPovereniku;
import com.project.poverenik.model.util.TsadrzajZalbe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podaci_o_primaocu" type="{http://www.reusability}Tpodaci_povereniku"/>
 *         &lt;element name="sadrzaj_zalbe" type="{http://www.reusability}Tsadrzaj_zalbe"/>
 *         &lt;element name="podaci_o_podnosiocu" type="{http://www.reusability}Tpodaci_o_podnosiocu"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mjesto" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "naziv",
    "podaciOPrimaocu",
    "sadrzajZalbe",
    "podaciOPodnosiocu"
})
@XmlRootElement(name = "zalba_cutanje", namespace = "http://www.zalbacutanje")
public class ZalbaCutanje {

    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(name = "podaci_o_primaocu", required = true)
    protected TpodaciPovereniku podaciOPrimaocu;
    @XmlElement(name = "sadrzaj_zalbe", required = true)
    protected TsadrzajZalbe sadrzajZalbe;
    @XmlElement(name = "podaci_o_podnosiocu", required = true)
    protected TpodaciOPodnosiocu podaciOPodnosiocu;
    @XmlAttribute(name = "mjesto")
    protected String mjesto;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the podaciOPrimaocu property.
     * 
     * @return
     *     possible object is
     *     {@link TpodaciPovereniku }
     *     
     */
    public TpodaciPovereniku getPodaciOPrimaocu() {
        return podaciOPrimaocu;
    }

    /**
     * Sets the value of the podaciOPrimaocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TpodaciPovereniku }
     *     
     */
    public void setPodaciOPrimaocu(TpodaciPovereniku value) {
        this.podaciOPrimaocu = value;
    }

    /**
     * Gets the value of the sadrzajZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TsadrzajZalbe }
     *     
     */
    public TsadrzajZalbe getSadrzajZalbe() {
        return sadrzajZalbe;
    }

    /**
     * Sets the value of the sadrzajZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TsadrzajZalbe }
     *     
     */
    public void setSadrzajZalbe(TsadrzajZalbe value) {
        this.sadrzajZalbe = value;
    }

    /**
     * Gets the value of the podaciOPodnosiocu property.
     * 
     * @return
     *     possible object is
     *     {@link TpodaciOPodnosiocu }
     *     
     */
    public TpodaciOPodnosiocu getPodaciOPodnosiocu() {
        return podaciOPodnosiocu;
    }

    /**
     * Sets the value of the podaciOPodnosiocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TpodaciOPodnosiocu }
     *     
     */
    public void setPodaciOPodnosiocu(TpodaciOPodnosiocu value) {
        this.podaciOPodnosiocu = value;
    }

    /**
     * Gets the value of the mjesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMjesto() {
        return mjesto;
    }

    /**
     * Sets the value of the mjesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMjesto(String value) {
        this.mjesto = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

}