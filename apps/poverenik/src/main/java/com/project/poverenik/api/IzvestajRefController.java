package com.project.poverenik.api;

import com.project.poverenik.model.izvestaj.client.getIzvestajByIdResponse;
import com.project.poverenik.model.util.file.Tpath;
import com.project.poverenik.model.util.lists.IzvestajRefList;
import com.project.poverenik.service.IzvestajRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin(origins = "https://localhost:4201")
@RestController
@RequestMapping(value = "/izvestaj", produces = MediaType.APPLICATION_XML_VALUE)
public class IzvestajRefController {

    @Autowired
    IzvestajRefService izvestajRefService;

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @RequestMapping(value = "/{procitano}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IzvestajRefList> getIzvestajListByStatus(@PathVariable String procitano) throws XMLDBException, JAXBException {
        IzvestajRefList izvestajRefList = izvestajRefService.getAll(procitano);

        if (izvestajRefList != null)
            return new ResponseEntity<>(izvestajRefList, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @RequestMapping(value = "izvestaj/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getIzvestaj(@PathVariable String id) throws JAXBException, XMLDBException {
        // TODO dodati za front xhtml transformacije
        getIzvestajByIdResponse getIzvestajByIdResponse = izvestajRefService.getIzvestaj(id);

        if (getIzvestajByIdResponse != null) {
            return new ResponseEntity<>(getIzvestajByIdResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @RequestMapping(value = "/search-metadata/{status}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IzvestajRefList> searchMetadata(@PathVariable String status, @RequestParam("datumAfter") String datumAfter, @RequestParam("datumBefore") String datumBefore) throws XMLDBException, JAXBException {

        IzvestajRefList izvestajRefList = izvestajRefService.searchMetadata(datumAfter, datumBefore, status);
        if (izvestajRefList != null) {
            return new ResponseEntity<>(izvestajRefList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/downloadRdf/{broj}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> downloadRdf(@PathVariable String broj) {
        Tpath path = izvestajRefService.getRdf(broj);
        if (path.getBytes() != null)
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) path.getBytes());

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/xml; charset=utf-8");
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=izvestaj" + broj + ".rdf");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/downloadJson/{broj}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> downloadJson(@PathVariable String broj) {
        Tpath path = izvestajRefService.getJson(broj);
        if (path.getBytes() != null)
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) path.getBytes());

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/xml; charset=utf-8");
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=izvestaj" + broj + ".json");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/izvestajDownloadXHTML/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> downloadIzvestajXHTML(@PathVariable String id) throws XMLDBException, JAXBException {
        String path = izvestajRefService.downloadIzvestajXHTML(id);
        if (!path.equals(""))
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/xml; charset=utf-8");
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=izvestaj" + id + ".pdf");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/izvestajDownloadPDF/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> downloadZalbaOdluka(@PathVariable String id) throws XMLDBException, JAXBException {
        String path = izvestajRefService.downloadIzvestajPDF(id);
        if (!path.equals(""))
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/xml; charset=utf-8");
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=izvestaj" + id + ".pdf");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
