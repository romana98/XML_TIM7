package com.project.organ_vlasti.wsdl.izjasnjavanje;

import com.project.organ_vlasti.model.util.message.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-31T18:41:58.610+01:00
 * Generated source version: 3.2.1
 */
@WebService(targetNamespace = "http://www.message", name = "IzjasnjavanjeServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IzjasnjavanjeServicePortType {

    @WebMethod(action = "http://www.message/ws/setIzjasnjavanje")
    @WebResult(name = "response", targetNamespace = "http://www.message", partName = "response")
    String setIzjasnjavanje(
            @WebParam(partName = "message", name = "message")
                    String message
    );
}
