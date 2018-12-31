package com.hcl.example.ticketHeatMap.server.api;

import com.hcl.example.ticketHeatMap.server.model.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-30T19:37:21.031Z")

@Controller
public class TicketApiController implements TicketApi {

    private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TicketApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Ticket>> getTicketsForHeatmap(@ApiParam(value = "identify the regions to be returned" ,required=true) @RequestHeader(value="regions", required=true) List<String> regions, @ApiParam(value = "Ticket statuses to include.", allowableValues = "any, closed, open", defaultValue = "any") @Valid @RequestParam(value = "status", required = false, defaultValue="any") String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Ticket>>(objectMapper.readValue("[ {  \"urgency\" : 15,  \"location\" : {    \"latitude\" : -75.5850925717018,    \"longitude\" : 36.988422590534526  },  \"id\" : \"id\",  \"status\" : { }}, {  \"urgency\" : 15,  \"location\" : {    \"latitude\" : -75.5850925717018,    \"longitude\" : 36.988422590534526  },  \"id\" : \"id\",  \"status\" : { }} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
