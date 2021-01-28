
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.project.poverenik.wsdl.resenje;

import com.project.poverenik.model.resenje.Tresenje;
import com.project.poverenik.service.ResenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-27T22:45:27.263+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "ResenjeService",
                      portName = "ResenjeServiceSoapBinding",
                      targetNamespace = "http://resenje",
                      wsdlLocation = "classpath:wsdl/Resenje.wsdl",
                      endpointInterface = "com.project.poverenik.wsdl.resenje.ResenjeServicePortType")
@Service
public class ResenjeServiceSoapBindingImpl implements ResenjeServicePortType {

    @Autowired
    ResenjeService resenjeService;

    private static final Logger LOG = Logger.getLogger(ResenjeServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see resenje.ResenjeServicePortType#getResenjeByBroj(java.lang.String broj)*
     */
    public Tresenje getResenjeByBroj(String broj) {
        LOG.info("Executing operation getResenjeByBroj");
        try {
            Tresenje _return = resenjeService.getOne(broj).getResenjeBody();
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
