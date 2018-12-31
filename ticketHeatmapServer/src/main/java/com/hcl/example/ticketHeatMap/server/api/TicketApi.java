package com.hcl.example.ticketHeatMap.server.api;

import com.hcl.example.ticketHeatMap.server.model.Ticket;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-30T19:37:21.031Z")

@Api(value = "ticket", description = "the ticket API")
public interface TicketApi {

    @ApiOperation(value = "Get summary ticket information", nickname = "getTicketsForHeatmap", notes = "Retrieve tickets with just fields useful for a heat map.", response = Ticket.class, responseContainer = "List", tags={ "itTicket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Ticket.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @RequestMapping(value = "/ticket/heatmap",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Ticket>> getTicketsForHeatmap(@ApiParam(value = "identify the regions to be returned" ,required=true) @RequestHeader(value="regions", required=true) List<String> regions,@ApiParam(value = "Ticket statuses to include.", allowableValues = "any, closed, open", defaultValue = "any") @Valid @RequestParam(value = "status", required = false, defaultValue="any") String status);

}
