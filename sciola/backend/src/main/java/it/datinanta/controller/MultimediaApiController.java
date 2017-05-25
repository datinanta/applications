package it.datinanta.controller;

import it.datinanta.model.MultimediaStream;

import io.swagger.annotations.*;
import it.datinanta.service.MultimediaService;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

@Controller
public class MultimediaApiController implements MultimediaApi {

    @Autowired
    MultimediaService multimediaService;
    
    public ResponseEntity<MultimediaStream> operaIdMultimediaPost(@ApiParam(value = "Opera id",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "multimedia data." ,required=true ) @RequestBody MultimediaStream multimedia, HttpServletRequest request) {
        // do some magic!
                HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<MultimediaStream> respEntity = null;
        try {
            MultimediaStream mediaInserted = multimediaService.insert(multimedia);
            URI locationURI = new URI(request.getRequestURL() +"/" +mediaInserted.getItem().getId());

            responseHeaders.setLocation(locationURI);
            responseHeaders.set("Location", locationURI.toString());
            respEntity = new ResponseEntity<MultimediaStream>(responseHeaders, HttpStatus.CREATED);
        } catch (URISyntaxException usex) {

            respEntity = new ResponseEntity<MultimediaStream>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return respEntity;
        }
    }

    public ResponseEntity<MultimediaStream> operaOperaIdMultimediaMediaIdDelete(@ApiParam(value = "Opera id",required=true ) @PathVariable("operaId") String operaId,
        @ApiParam(value = "Media id",required=true ) @PathVariable("mediaId") String mediaId) {
        // do some magic!
                return multimediaService.delete(mediaId)?(new ResponseEntity<MultimediaStream>(HttpStatus.OK)):(new ResponseEntity<MultimediaStream>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<MultimediaStream> operaOperaIdMultimediaMediaIdGet(@ApiParam(value = "Opera id",required=true ) @PathVariable("operaId") String operaId,
        @ApiParam(value = "Media id",required=true ) @PathVariable("mediaId") String mediaId) {
        // do some magic!
                MultimediaStream mediaFound = null;
        mediaFound = multimediaService.findById(mediaId);
        if (mediaFound == null) {
            return new ResponseEntity<MultimediaStream>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<MultimediaStream>(mediaFound, HttpStatus.OK);
        }

        //return new ResponseEntity<Multimedia>(HttpStatus.OK);
    }

}
