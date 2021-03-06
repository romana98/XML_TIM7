
package com.project.organ_vlasti.model.util.ComplexTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tinformacije_o_traziocu complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tinformacije_o_traziocu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lice" type="{http://www.reusability}Ttip_lica"/&gt;
 *         &lt;element name="adresa" type="{http://www.reusability}Tadresa"/&gt;
 *         &lt;element name="drugi_podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tinformacije_o_traziocu", propOrder = {
        "lice",
        "adresa",
        "drugiPodaciZaKontakt"
})
public class TinformacijeOTraziocu {

    @XmlElement(required = true)
    protected TtipLica lice;
    @XmlElement(required = true)
    protected Tadresa adresa;
    @XmlElement(name = "drugi_podaci_za_kontakt", required = true)
    protected String drugiPodaciZaKontakt;

    /**
     * Gets the value of the lice property.
     *
     * @return possible object is
     * {@link TtipLica }
     */
    public TtipLica getLice() {
        return lice;
    }

    /**
     * Sets the value of the lice property.
     *
     * @param value allowed object is
     *              {@link TtipLica }
     */
    public void setLice(TtipLica value) {
        this.lice = value;
    }

    /**
     * Gets the value of the adresa property.
     *
     * @return possible object is
     * {@link Tadresa }
     */
    public Tadresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     *
     * @param value allowed object is
     *              {@link Tadresa }
     */
    public void setAdresa(Tadresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the drugiPodaciZaKontakt property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDrugiPodaciZaKontakt() {
        return drugiPodaciZaKontakt;
    }

    /**
     * Sets the value of the drugiPodaciZaKontakt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDrugiPodaciZaKontakt(String value) {
        this.drugiPodaciZaKontakt = value;
    }

}
