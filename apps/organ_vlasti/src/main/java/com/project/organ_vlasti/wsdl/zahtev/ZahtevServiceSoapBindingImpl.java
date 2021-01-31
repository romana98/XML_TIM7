
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.project.organ_vlasti.wsdl.zahtev;

import com.project.organ_vlasti.model.zahtev.Tzahtev;
import com.project.organ_vlasti.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import javax.jws.WebService;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-30T17:41:49.509+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "ZahtevService",
                      portName = "ZahtevServiceSoapBinding",
                      targetNamespace = "http://www.zahtevcir",
                      wsdlLocation = "classpath:wsdl/Zahtev.wsdl",
                      endpointInterface = "com.project.organ_vlasti.wsdl.zahtev.ZahtevServicePortType")
@Service
public class ZahtevServiceSoapBindingImpl implements ZahtevServicePortType {

    @Autowired
    ZahtevService zahtevService;

    private static final Logger LOG = Logger.getLogger(ZahtevServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see zahtevcir.ZahtevServicePortType#getZahtevById(java.lang.String id)*
     */
    public Tzahtev getZahtevById(String id) {
        LOG.info("Executing operation getZahtevById");
        System.out.println(id);
        try {
            Tzahtev _return = zahtevService.getOne(id).getZahtevBody();
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}