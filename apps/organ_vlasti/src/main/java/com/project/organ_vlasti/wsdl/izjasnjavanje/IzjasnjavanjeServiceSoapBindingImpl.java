
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.project.organ_vlasti.wsdl.izjasnjavanje;

import com.project.organ_vlasti.model.util.message.Message;
import com.project.organ_vlasti.model.util.message.ObjectFactory;
import com.project.organ_vlasti.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import javax.jws.WebService;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-31T18:41:58.610+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "IzjasnjavanjeService",
                      portName = "IzjasnjavanjeServiceSoapBinding",
                      targetNamespace = "http://www.message",
                      wsdlLocation = "classpath:wsdl/Izjasnjavanje.wsdl",
                      endpointInterface = "com.project.organ_vlasti.wsdl.izjasnjavanje.IzjasnjavanjeServicePortType")
@Service
public class IzjasnjavanjeServiceSoapBindingImpl implements IzjasnjavanjeServicePortType {
    @Autowired
    MessageService messageService;
    private static final Logger LOG = Logger.getLogger(IzjasnjavanjeServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see message.IzjasnjavanjeServicePortType#setIzjasnjavanje(java.lang.String message)*
     */
    public String setIzjasnjavanje(String message) {
        LOG.info("Executing operation setIzjasnjavanje");
        try {
            ObjectFactory of = new ObjectFactory();
            Message messageObj = of.createMessage();
            messageObj.setBody(of.createMessageBody());
            messageObj.getBody().setValue(message);
            messageService.create(messageObj);

            return "OK";
        } catch (Exception ex) {
            return "Error";
        }
    }

}
