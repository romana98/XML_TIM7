package com.project.organ_vlasti.service;

import com.project.organ_vlasti.jaxb.JaxB;
import com.project.organ_vlasti.model.user.User;
import com.project.organ_vlasti.model.util.lists.UserList;
import com.project.organ_vlasti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JaxB jaxB;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean create(User user, String role) throws XMLDBException, JAXBException {
        if (getOne(user.getEmail()) != null) {
        	return false;
        }
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        if (jaxB.validate(user.getClass(), user)) {
            return userRepository.create(user);
        }
        return false;
    }

    public UserList getAll() throws XMLDBException, JAXBException {
        List<User> users = new ArrayList<>();

        ResourceSet resourceSet = userRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()) {
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            if (xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            User user = (User) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            users.add(user);
        }
        return new UserList(users);
    }

    public User getOne(String email) throws XMLDBException, JAXBException {
        XMLResource xmlResource = userRepository.getOne(email);

        if (xmlResource == null)
            return null;

        User user;

        JAXBContext context = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        user = (User) unmarshaller.unmarshal(xmlResource.getContentAsDOM());

        return user;
    }

    public boolean delete(String email) throws XMLDBException {
        return userRepository.delete(email);
    }

    public Long hasRoleOrganVlasti() throws XMLDBException {
        ResourceSet resourceSet = userRepository.hasRoleOrganVlasti();
        return resourceSet.getSize();
    }

    public boolean update(User user) throws JAXBException, XMLDBException {
    	if (getOne(user.getEmail()) == null) {
    		return false;
    	}
    	if (user.getPassword().equals("")) {
    		user.setPassword(getOne(user.getEmail()).getPassword());
    	} else {
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	}
        String patch = jaxB.marshall(user.getClass(), user);
        //u patch moraju biti navedeni svi elementi unutar root elementa inace ce biti obrisani
        patch = patch.substring(patch.lastIndexOf("<u:name>"), patch.indexOf("</u:role>") + "</u:role>".length());
        return userRepository.update(user.getEmail(), patch);
    }
}
