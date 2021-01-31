package com.project.organ_vlasti.wsdl.obavestenje;

import com.project.organ_vlasti.model.obavestenje.ObjectFactory;
import com.project.organ_vlasti.model.obavestenje.Tobavestenje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-30T17:19:13.095+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.obavestenje", name = "ObavestenjeServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ObavestenjeServicePortType {

    @WebMethod(action = "http://www.obavestenje/ws/getObavestenjeByBroj")
    @WebResult(name = "obavestenje", targetNamespace = "http://www.obavestenje", partName = "obavestenje")
    public Tobavestenje getObavestenjeByBroj(
        @WebParam(partName = "id", name = "id")
        String id
    );
}
