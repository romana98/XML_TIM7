package com.project.organ_vlasti.wsdl.resenje_ref;

import com.project.organ_vlasti.model.resenje.database.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-01T11:11:18.743+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://resenje", name = "ResenjeRefServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ResenjeRefServicePortType {

    @WebMethod(action = "http://resenje/ws/setResenjeRef")
    @WebResult(name = "response", targetNamespace = "http://resenje", partName = "response")
    public String setResenjeRef(
        @WebParam(partName = "resenje_ref", name = "resenje_ref")
        String resenjeRef
    );
}
