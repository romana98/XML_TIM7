package com.project.organ_vlasti.model.util.email.client;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "response"
})
@XmlRootElement(name = "sendPlainResponse", namespace = "http://email")
public class sendPlainResponse {

    @XmlElement(name = "response", required = true)
    protected String response;

    /**
     * Gets the value of the student property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the student property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResponse(String value) {
        this.response = value;
    }
}
