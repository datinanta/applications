package it.datinanta.controller;

import it.datinanta.model.Opera;

import io.swagger.annotations.*;
import it.datinanta.service.OperaService;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

@Controller
public class OperasApiController implements OperasApi {

    @Autowired
    OperaService operaService;

    @CrossOrigin
    public ResponseEntity<List<Opera>> operasGet() {
        // do some magic!

        return new ResponseEntity<List<Opera>>(operaService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Opera> operasIdDelete(@ApiParam(value = "Opera id", required = true) @PathVariable("id") String id) {
        // do some magic!
        
        return operaService.delete(id)?(new ResponseEntity<Opera>(HttpStatus.OK)):(new ResponseEntity<Opera>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Opera> operasIdGet(@ApiParam(value = "Opera id", required = true) @PathVariable("id") String id) {
        // do some magic!
        Opera operaFound = null;
        operaFound = operaService.findById(id);
        if (operaFound == null) {
            return new ResponseEntity<Opera>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Opera>(operaFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<Opera> operasIdPut(@ApiParam(value = "Opera id", required = true) @PathVariable("id") String id,
            @ApiParam(value = "Opera data.", required = true) @RequestBody Opera opera, HttpServletRequest request) {
        // do some magic!
                HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Opera> respEntity = null;
        try {
        operaService.update(opera);
           URI locationURI = new URI(request.getRequestURL() +"/" +id);

            responseHeaders.setLocation(locationURI);
            responseHeaders.set("Location", locationURI.toString());
            respEntity = new ResponseEntity<Opera>(responseHeaders,HttpStatus.OK);
        } catch (URISyntaxException usex) {

            respEntity = new ResponseEntity<Opera>(HttpStatus.NOT_MODIFIED);
        } finally {
            return respEntity;
        }
        
    }

    public ResponseEntity<Opera> operasPost(@ApiParam(value = "Opera data.", required = true) @RequestBody Opera opera, HttpServletRequest request) {
        // do some magic!
        
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Opera> respEntity = null;
        try {
            Opera operaInserted = operaService.insert(opera);
            URI locationURI = new URI(request.getRequestURL() +"/" +operaInserted.getId());

            responseHeaders.setLocation(locationURI);
            responseHeaders.set("Location", locationURI.toString());
            respEntity = new ResponseEntity<Opera>(responseHeaders, HttpStatus.CREATED);
        } catch (URISyntaxException usex) {

            respEntity = new ResponseEntity<Opera>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return respEntity;
        }
    }

}
