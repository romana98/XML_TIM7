package com.project.organ_vlasti.wsdl.zahtev;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-01-30T17:41:49.517+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "ZahtevService", 
                  wsdlLocation = "classpath:wsdl/Zahtev.wsdl",
                  targetNamespace = "http://www.zahtevcir") 
public class ZahtevService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.zahtevcir", "ZahtevService");
    public final static QName ZahtevServiceSoapBinding = new QName("http://www.zahtevcir", "ZahtevServiceSoapBinding");
    static {
        URL url = ZahtevService.class.getClassLoader().getResource("wsdl/Zahtev.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(ZahtevService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/Zahtev.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public ZahtevService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ZahtevService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZahtevService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ZahtevService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ZahtevService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ZahtevService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ZahtevServicePortType
     */
    @WebEndpoint(name = "ZahtevServiceSoapBinding")
    public ZahtevServicePortType getZahtevServiceSoapBinding() {
        return super.getPort(ZahtevServiceSoapBinding, ZahtevServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZahtevServicePortType
     */
    @WebEndpoint(name = "ZahtevServiceSoapBinding")
    public ZahtevServicePortType getZahtevServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(ZahtevServiceSoapBinding, ZahtevServicePortType.class, features);
    }

}
