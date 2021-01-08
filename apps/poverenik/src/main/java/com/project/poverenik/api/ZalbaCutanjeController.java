package com.project.poverenik.api;

import com.project.poverenik.model.user.User;
import com.project.poverenik.model.util.lists.UserList;
import com.project.poverenik.model.util.lists.ZalbaCutanjeList;
import com.project.poverenik.model.zalba_cutanje.ZalbaCutanje;
import com.project.poverenik.service.ZalbaCutanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping(value = "/zalba-cutanje", produces = MediaType.APPLICATION_XML_VALUE)
public class ZalbaCutanjeController {

    @Autowired
    ZalbaCutanjeService zalbaCutanjeService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createZalbaCutanje(@RequestBody ZalbaCutanje zalbaCutanje) throws XMLDBException {
        if (zalbaCutanjeService.create(zalbaCutanje)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZalbaCutanjeList> getZalbaCutanjeList() throws XMLDBException, JAXBException {
        ZalbaCutanjeList zalbaCutanjeList = zalbaCutanjeService.getAll();

        if(zalbaCutanjeList != null)
            return new ResponseEntity(zalbaCutanjeList, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getZalbaCutanje(@PathVariable String id) throws XMLDBException, JAXBException {
        ZalbaCutanje zalbaCutanje = zalbaCutanjeService.getOne(id);
        if(zalbaCutanje != null)
            return new ResponseEntity(zalbaCutanje, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity delete(@PathVariable String id) throws XMLDBException, JAXBException {
        boolean isDeleted = zalbaCutanjeService.delete(id);
        if(isDeleted)
            return new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity update(@RequestBody ZalbaCutanje zalbaCutanje) throws XMLDBException, JAXBException {
        boolean isUpdated = zalbaCutanjeService.update(zalbaCutanje);
        if(isUpdated)
            return new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}