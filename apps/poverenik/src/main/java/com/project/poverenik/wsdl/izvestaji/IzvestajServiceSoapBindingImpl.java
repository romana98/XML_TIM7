
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.project.poverenik.wsdl.izvestaji;

import com.project.poverenik.model.izvestaj.ObjectFactory;
import com.project.poverenik.model.izvestaj.Tbody;
import com.project.poverenik.model.izvestaj.database.IzvestajRef;
import com.project.poverenik.service.IzvestajRefService;
import com.project.poverenik.service.ZalbaCutanjeService;
import com.project.poverenik.service.ZalbaOdlukaService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-03T01:53:05.350+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "IzvestajService",
                      portName = "IzvestajServiceSoapBinding",
                      targetNamespace = "http://izvestaji",
                      wsdlLocation = "classpath:wsdl/Izvestaj.wsdl",
                      endpointInterface = "com.project.poverenik.wsdl.izvestaji.IzvestajServicePortType")
@Service
public class IzvestajServiceSoapBindingImpl implements IzvestajServicePortType {

    @Autowired
    ZalbaCutanjeService zalbaCutanjeService;

    @Autowired
    ZalbaOdlukaService zalbaOdlukaService;

    @Autowired
    IzvestajRefService izvestajRefService;

    private static final Logger LOG = Logger.getLogger(IzvestajServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see izvestaji.IzvestajServicePortType#getPodaci()*
     */
    public Tbody getPodaci() {
        LOG.info("Executing operation getPodaci");
        try {
            ObjectFactory of = new ObjectFactory();
            Tbody _return = of.createTbody();
            _return.setZalbeCutanjeOdbijeno(new Tbody.ZalbeCutanjeOdbijeno()); 
            _return.getZalbeCutanjeOdbijeno().setValue(BigInteger.valueOf(zalbaCutanjeService.getOdbijene()));
            
            _return.setZalbeCutanjePodneti(new Tbody.ZalbeCutanjePodneti()); 
            _return.getZalbeCutanjePodneti().setValue(BigInteger.valueOf(zalbaCutanjeService.getPodnete()));
            
            _return.setZalbeCutanjePonisteno(new Tbody.ZalbeCutanjePonisteno()); 
            _return.getZalbeCutanjePonisteno().setValue(BigInteger.valueOf(zalbaCutanjeService.getPonistene()));
            
            _return.setZalbeCutanjePrihvaceno(new Tbody.ZalbeCutanjePrihvaceno()); 
            _return.getZalbeCutanjePrihvaceno().setValue(BigInteger.valueOf(zalbaCutanjeService.getPrihvacene()));

            
            _return.setZalbeOdlukeOdbijeno(new Tbody.ZalbeOdlukeOdbijeno()); 
            _return.getZalbeOdlukeOdbijeno().setValue(BigInteger.valueOf(zalbaOdlukaService.getOdbijene()));
            
            _return.setZalbeOdlukePodneti(new Tbody.ZalbeOdlukePodneti()); 
            _return.getZalbeOdlukePodneti().setValue(BigInteger.valueOf(zalbaOdlukaService.getPodnete()));
            
            _return.setZalbeOdlukePonisteno(new Tbody.ZalbeOdlukePonisteno()); 
            _return.getZalbeOdlukePonisteno().setValue(BigInteger.valueOf(zalbaOdlukaService.getPonistene()));
            
            _return.setZalbeOdlukePrihvaceno(new Tbody.ZalbeOdlukePrihvaceno()); 
            _return.getZalbeOdlukePrihvaceno().setValue(BigInteger.valueOf(zalbaOdlukaService.getPrihvacene()));
            _return.setId("0");
            return _return;
        } catch (Exception ex) {
            ObjectFactory of = new ObjectFactory();
            Tbody tbody = of.createTbody();
            tbody.setId("-1");
            return  tbody;
        }
    }

    /* (non-Javadoc)
     * @see izvestaji.IzvestajServicePortType#podnesiIzvestaj(izvestaji.Tbody izvestaj)*
     */
    public String podnesiIzvestaj(String izvestajRef) {
        LOG.info("Executing operation podnesiIzvestaj");
        try {
            com.project.poverenik.model.izvestaj.database.ObjectFactory of = new com.project.poverenik.model.izvestaj.database.ObjectFactory();
            IzvestajRef izvestajRefObj = of.createIzvestajRef();
            izvestajRefObj.setBody(of.createBody());
            izvestajRefObj.getBody().setValue(izvestajRef);
            izvestajRefObj.getBody().setProcitano("ne");

            izvestajRefService.create(izvestajRefObj);

            return "OK";
        } catch (Exception ex) {
            return "Error";
        }
    }

}
