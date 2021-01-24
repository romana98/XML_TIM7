package com.project.organ_vlasti.service;

import com.project.organ_vlasti.jaxb.JaxB;
import com.project.organ_vlasti.model.util.lists.ZahtevList;
import com.project.organ_vlasti.model.zahtev.Zahtev;
import com.project.organ_vlasti.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ZahtevService {

    @Autowired
    private JaxB jaxB;

    @Autowired
    private ZahtevRepository zahtevRepository;

    /*
    private String getMaxId() throws XMLDBException, JAXBException {
        ResourceSet max = zalbaCutanjeRepository.getMaxId();
        ResourceIterator resourceIterator = max.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            if(xmlResource == null)
                return "0";
            JAXBContext context = JAXBContext.newInstance(ZalbaCutanje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaCutanje zalbaCutanjeMax = (ZalbaCutanje) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            return zalbaCutanjeMax.getId();
        }
        return "0";
    }
     */

    public boolean create(Zahtev zahtev) throws XMLDBException, JAXBException {
        /*
        if (jaxB.validate(obavestenje.getClass(), obavestenje)){
            String id = String.valueOf(Integer.parseInt(getMaxId())+1);

            ZalbaCutanje zalbaCutanje = ZalbaCutanjeMapper.mapFromDTO(zalbaCutanjeDTO, id);

            if(jaxB.validate(zalbaCutanje.getClass(), zalbaCutanje)){
                return zalbaCutanjeRepository.create(zalbaCutanje);
            }else {
                return false;
            }
        }
        return false;
         */
        if(jaxB.validate(zahtev.getClass(), zahtev)){
            return zahtevRepository.create(zahtev);
        }else{
            return false;
        }
    }

    public ZahtevList getAll() throws XMLDBException, JAXBException {
        List<Zahtev> zahtevList = new ArrayList<>();

        ResourceSet resourceSet = zahtevRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(Zahtev.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Zahtev zahtev = (Zahtev) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            zahtevList.add(zahtev);
        }
        return new ZahtevList(zahtevList);
    }

    public Zahtev getOne(String id) throws JAXBException, XMLDBException {
        XMLResource xmlResource = zahtevRepository.getOne(id);

        if(xmlResource == null)
            return null;

        Zahtev zahtev = null;

        JAXBContext context = JAXBContext.newInstance(Zahtev.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        zahtev = (Zahtev) unmarshaller.unmarshal(xmlResource.getContentAsDOM());

        return zahtev;
    }

    public boolean delete(String id) throws XMLDBException {
        return zahtevRepository.delete(id);
    }

    public boolean update(Zahtev zahtev) throws JAXBException, XMLDBException {
        String patch = jaxB.marshall(zahtev.getClass(), zahtev);
        //u patch moraju biti navedeni svi elementi unutar root elementa inace ce biti obrisani
        patch = patch.substring(patch.lastIndexOf("<zcir:ciljani_organ_vlasti>"), patch.indexOf("</zcir:fusnote>") + "</zcir:fusnote>".length());
        return zahtevRepository.update(zahtev.getId(), patch);
    }
}
