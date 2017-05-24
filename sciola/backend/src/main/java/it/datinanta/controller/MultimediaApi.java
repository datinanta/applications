package it.datinanta.controller;

import it.datinanta.model.MultimediaStream;

import io.swagger.annotations.*;
import it.datinanta.model.Multimedia;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

@Api(value = "opera", description = "the opera API")
public interface MultimediaApi {

    @ApiOperation(value = "Create a multimedia", notes = "Endpoint create a multimedia and return the multimedia location in header property.", response = Void.class, tags={ "Multimedia","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Multimedia created", response = Void.class),
        @ApiResponse(code = 500, message = "Opera not created", response = Void.class) })
    @RequestMapping(value = "/opera/{id}/multimedia",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<MultimediaStream> operaIdMultimediaPost(@ApiParam(value = "Opera id",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "multimedia data." ,required=true ) @RequestBody MultimediaStream multimedia, HttpServletRequest request);


    @ApiOperation(value = "Delete requested Multimedia", notes = "Endpoint delete the request multimedia", response = Void.class, tags={ "Multimedia","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Multimedia deleted", response = Void.class),
        @ApiResponse(code = 500, message = "Multimedia not deleted", response = Void.class) })
    @RequestMapping(value = "/opera/{operaId}/multimedia/{mediaId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<MultimediaStream> operaOperaIdMultimediaMediaIdDelete(@ApiParam(value = "Opera id",required=true ) @PathVariable("operaId") String operaId,
        @ApiParam(value = "Media id",required=true ) @PathVariable("mediaId") String mediaId);


    @ApiOperation(value = "Get specific multimedia data", notes = "Endpoint return multimedia information related on requested id", response = MultimediaStream.class, tags={ "Multimedia","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Multimedia found and returned.", response = MultimediaStream.class),
        @ApiResponse(code = 404, message = "Multimedia not found", response = MultimediaStream.class) })
    @RequestMapping(value = "/opera/{operaId}/multimedia/{mediaId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MultimediaStream> operaOperaIdMultimediaMediaIdGet(@ApiParam(value = "Opera id",required=true ) @PathVariable("operaId") String operaId,
        @ApiParam(value = "Media id",required=true ) @PathVariable("mediaId") String mediaId);

}
