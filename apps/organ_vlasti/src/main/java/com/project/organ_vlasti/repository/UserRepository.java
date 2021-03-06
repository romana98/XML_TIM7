package com.project.organ_vlasti.repository;

import com.project.organ_vlasti.database.ExistManager;
import com.project.organ_vlasti.model.user.User;
import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

@Repository
public class UserRepository {

    @Autowired
    public ExistManager existManager;

    private final String collectionUri = "db/organ_vlasti/xml/users";

    private final String TARGET_NAMESPACE = "http://user";

    public final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns:u=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";
    public final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns:u=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";

    public boolean create(User user) throws XMLDBException {
        return existManager.store(collectionUri, user.getEmail(), user, false);
    }

    public XMLResource getOne(String email) throws XMLDBException {
        return existManager.load(collectionUri, email);
    }

    public ResourceSet getAll() throws XMLDBException {
        return existManager.retrieve(collectionUri, "/user", TARGET_NAMESPACE);

    }

    public ResourceSet hasRoleOrganVlasti() throws XMLDBException {
        return existManager.retrieve(collectionUri, "/user/role[.='ROLE_ORGAN_VLASTI']", TARGET_NAMESPACE);
    }

    public boolean delete(String email) throws XMLDBException {
        return existManager.remove(collectionUri, email);
    }

    public boolean update(String email, String xmlEntity) throws XMLDBException {

        String xpath = String.format("/u:user[u:email='%s']", email);
        return existManager.update(collectionUri, email, xpath, xmlEntity, UPDATE);
    }
}
