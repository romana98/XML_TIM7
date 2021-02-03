/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.project.poverenik.wsdl.resenje;

import com.project.poverenik.model.resenje.ObjectFactory;
import com.project.poverenik.model.resenje.Resenje;
import com.project.poverenik.model.resenje.Tresenje;
import com.project.poverenik.model.util.lists.ResenjeList;
import com.project.poverenik.model.util.parametars.ParametarMap;
import com.project.poverenik.model.util.parametars.RefIdList;
import com.project.poverenik.service.ResenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebService;

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
            ObjectFactory objectFactory = new ObjectFactory();
            Tresenje tresenje = objectFactory.createTresenje();
            tresenje.setBroj("-1");
            return tresenje;
        }
    }

    /* (non-Javadoc)
     * @see resenje.ResenjeServicePortType#getAllResenja()*
     */
    public ResenjeList getAllResenja() {
        LOG.info("Executing operation getAllResenja");
        try {
            ResenjeList _return = resenjeService.getAll();
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see resenje.ResenjeServicePortType#getRefs(parametars.ParametarMap parametars)*
     */
    public RefIdList getRefs(ParametarMap parametars) {
        LOG.info("Executing operation getRefs");
        try {

            ResenjeList resenjeList;
            RefIdList refIdList = new RefIdList();

            if(parametars.getValue().get(0).getName().equals("input")) {
                resenjeList = resenjeService.searchText(parametars.getValue().get(0).getName().equals("input") ? parametars.getValue().get(0).getValue() : "");
            }else {

                resenjeList = resenjeService.searchMetadata(
                        parametars.getValue().get(0).getName().equals("poverenik") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("trazilac") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("zalba") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("datumAfter") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("datumBefore") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("tip") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("organVlasti") ? parametars.getValue().get(0).getValue() : "",
                        parametars.getValue().get(0).getName().equals("mesto") ? parametars.getValue().get(0).getValue() : "");
            }

            for (Resenje resenje: resenjeList.getAny()) {
                refIdList.getRef().add(resenje.getResenjeBody().getBroj());
            }

            return refIdList;
        } catch (java.lang.Exception ex) {
            RefIdList refIdList = new RefIdList();
            refIdList.getRef().add("-1");
            return refIdList;
        }
    }
}