package com.project.organ_vlasti.repository;

import com.project.organ_vlasti.database.ExistManager;
import com.project.organ_vlasti.model.obavestenje.Obavestenje;
import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

@Repository
public class ObavestenjeRepository {

    @Autowired
    public ExistManager existManager;

    private final String collectionUri = "db/organ_vlasti/xml/obavestenje";

    private final String TARGET_NAMESPACE = "http://www.obavestenje";

    public final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS + "\" xmlns:oba=\"" + TARGET_NAMESPACE + "\"" + " xmlns:re=\"" + "http://reusability" +  "\">" +
            "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";
    public final  String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns:oba=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";


    public boolean create(Obavestenje obavestenje) throws XMLDBException {
        return existManager.store(collectionUri, obavestenje.getBroj(), obavestenje);
    }

    public ResourceSet getAll() throws XMLDBException {
        return existManager.retrieve(collectionUri, "/obavestenje", TARGET_NAMESPACE);
    }

    public XMLResource getOne(String broj) throws XMLDBException {
        return existManager.load(collectionUri, broj);
    }

    public boolean delete(String broj) throws XMLDBException {
        return existManager.remove(collectionUri, broj);
    }

    public boolean update(String broj, String patch) throws XMLDBException {
        String xpath =  String.format("/obavestenje[@broj='%s']", broj);
        return existManager.update(collectionUri, broj, xpath, patch, UPDATE);
    }
    
    public ResourceSet getMaxId() throws XMLDBException  {
        String xpath = "/obavestenje[@id = max(/obavestenje/@id)]";
        return existManager.retrieve(collectionUri, xpath, TARGET_NAMESPACE);
    }
}