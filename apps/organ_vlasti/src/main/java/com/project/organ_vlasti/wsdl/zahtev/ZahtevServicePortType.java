package com.project.organ_vlasti.wsdl.zahtev;

import com.project.organ_vlasti.model.zahtev.ObjectFactory;
import com.project.organ_vlasti.model.zahtev.Tzahtev;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-30T17:41:49.514+01:00
 * Generated source version: 3.2.1
 */
@WebService(targetNamespace = "http://www.zahtevcir", name = "ZahtevServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ZahtevServicePortType {

    @WebMethod(action = "http://www.zahtevcir/ws/getZahtevById")
    @WebResult(name = "zahtev", targetNamespace = "http://www.zahtevcir", partName = "zahtev")
    Tzahtev getZahtevById(
            @WebParam(partName = "id", name = "id")
                    String id
    );
}
