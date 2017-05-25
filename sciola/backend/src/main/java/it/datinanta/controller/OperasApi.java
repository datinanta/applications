package it.datinanta.controller;

import it.datinanta.model.Opera;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

@Api(value = "operas", description = "the operas API")
public interface OperasApi {

    @ApiOperation(value = "Return all operas", notes = "Endpoint return all opera.", response = Opera.class, responseContainer = "List", tags={ "Opera","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Operas data", response = Opera.class),
        @ApiResponse(code = 500, message = "Operas retrieve error", response = Opera.class) })
    @RequestMapping(value = "/operas",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Opera>> operasGet();


    @ApiOperation(value = "Delete requested opera", notes = "Endpoint delete the request opera", response = Void.class, tags={ "Opera","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Opera deleted", response = Void.class),
        @ApiResponse(code = 500, message = "Opera not deleted", response = Void.class) })
    @RequestMapping(value = "/operas/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Opera> operasIdDelete(@ApiParam(value = "Opera id",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "Get specific opera data", notes = "Endpoint return opera information related on requested id", response = Opera.class, tags={ "Opera","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Opera found and returned.", response = Opera.class),
        @ApiResponse(code = 404, message = "Opera not found", response = Opera.class) })
    @RequestMapping(value = "/operas/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Opera> operasIdGet(@ApiParam(value = "Opera id",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "Opera update", notes = "Endpoint update the opera requested and return the opera location in header property.", response = Void.class, tags={ "Opera","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Opera updatetd", response = Void.class),
        @ApiResponse(code = 500, message = "Opera not updated", response = Void.class) })
    @RequestMapping(value = "/operas/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Opera> operasIdPut(@ApiParam(value = "Opera id",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "Opera data." ,required=true ) @RequestBody Opera scheda, HttpServletRequest request);


    @ApiOperation(value = "Create an opera", notes = "Endpoint create the opera and return the opera location in header property.", response = Void.class, tags={ "Opera","Iccd","Datinanta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Opera created", response = Void.class),
        @ApiResponse(code = 500, message = "Opera not created", response = Void.class) })
    @RequestMapping(value = "/operas",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Opera> operasPost(@ApiParam(value = "Opera data." ,required=true ) @RequestBody Opera opera, HttpServletRequest request);

}
